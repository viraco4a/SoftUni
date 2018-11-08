using MilitaryElitePractice.Contracts;
using MilitaryElitePractice.Enums;
using MilitaryElitePractice.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MilitaryElitePractice.Core
{
    public class Engine
    {
        private ICollection<ISoldier> soldiers;
        private ISoldier soldier;

        public Engine()
        {
            soldiers = new List<ISoldier>();
        }

        public void Run()
        {
            string input = Console.ReadLine();

            while (input != "End")
            {
                string[] splitted = input.Split();
                string soldierType = splitted[0];
                int id = int.Parse(splitted[1]);
                string firstName = splitted[2];
                string lastName = splitted[3];

                switch (soldierType)
                {
                    case "Private":
                        decimal salary = decimal.Parse(splitted[4]);
                        soldier = GetPrivateSoldier(id, firstName, lastName, salary);
                        break;
                    case "LieutenantGeneral":
                        salary = decimal.Parse(splitted[4]);
                        soldier = GetLieutenantGeneral(id, firstName, lastName, salary, splitted);
                        break;
                    case "Engineer":
                        salary = decimal.Parse(splitted[4]);
                        soldier = GetEngineer(id, firstName, lastName, salary, splitted);
                        break;
                    case "Commando":
                        salary = decimal.Parse(splitted[4]);
                        soldier = GetCommando(id, firstName, lastName, salary, splitted);
                        break;
                    case "Spy":
                        int codeNumber = int.Parse(splitted[4]);
                        soldier = GetSpy(id, firstName, lastName, codeNumber);
                        break;
                }

                if (soldier != null)
                {
                    this.soldiers.Add(soldier);
                }

                input = Console.ReadLine();
            }

            foreach (var soldier in soldiers)
            {
                Console.WriteLine(soldier);
            }
        }

        private ISoldier GetSpy(int id, string firstName, string lastName, int codeNumber)
        {
            ISpy spy = new Spy(id, firstName, lastName, codeNumber);
            return spy;
        }

        private ISoldier GetCommando(int id, string firstName, string lastName, decimal salary,
            string[] splitted)
        {
            string corpsVal = splitted[5];
            if (!Enum.TryParse(corpsVal, out Corps corps))
            {
                return null;
            }

            ICommando commando = new Commando(id, firstName, lastName, salary, corps);

            for (int i = 6; i < splitted.Length; i+=2)
            {
                string missionCodeName = splitted[i];
                string missionState = splitted[i + 1];
                if (!Enum.TryParse(missionState, out State state))
                {
                    continue;
                }
                IMission mission = new Mission(missionCodeName, state);
                commando.Missions.Add(mission);
            }

            return commando;
        }

        private ISoldier GetEngineer(int id, string firstName, string lastName, decimal salary,
            string[] splitted)
        {
            string corpsVal = splitted[5];
            if (!Enum.TryParse(corpsVal, out Corps corps))
            {
                return null;
            }

            IEngineer engineer = new Engineer(id, firstName, lastName, salary, corps);

            for (int i = 6; i < splitted.Length; i+=2)
            {
                string repairPart = splitted[i];
                int repairHour = int.Parse(splitted[i + 1]);
                IRepair repair = new Repair(repairPart, repairHour);
                engineer.Repairs.Add(repair);
            }

            return engineer;
        }

        private ISoldier GetLieutenantGeneral(int id, string firstName, string lastName, decimal salary,
            string[] splitted)
        {
            ILieutenantGeneral lieutenantGeneral = new LieutenantGeneral(id, firstName, lastName, salary);
            for (int i = 5; i < splitted.Length; i++)
            {
                IPrivate soldier = (IPrivate)this.soldiers
                    .FirstOrDefault(s => s.Id == int.Parse(splitted[i]));
                lieutenantGeneral.Privates.Add(soldier);
            }
            return lieutenantGeneral;
        }

        private ISoldier GetPrivateSoldier(int id, string firstName, string lastName, decimal salary)
        {
            IPrivate privateSoldier = new Private(id, firstName, lastName, salary);
            return privateSoldier;
        }
    }
}
