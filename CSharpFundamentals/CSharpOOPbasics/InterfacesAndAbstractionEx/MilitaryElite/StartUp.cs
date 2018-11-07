using MilitaryElite.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;

namespace MilitaryElite
{
    public class StartUp
    {
        private static List<ISoldier> soldiers = new List<ISoldier>();
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            while (input != "End")
            {
                string[] splitted = input.Split();

                string soldierType = splitted[0];
                int id = int.Parse(splitted[1]);
                string firstName = splitted[2];
                string lastName = splitted[3];
                decimal salary = decimal.Parse(splitted[4]);

                ISoldier soldier = null;

                try
                {
                    switch (soldierType)
                    {
                        case "Private":
                            soldier = new Private(id, firstName, lastName, salary);
                            break;
                        case "Spy":
                            soldier = new Spy(id, firstName, lastName, int.Parse(splitted[4]));
                            break;
                        case "LieutenantGeneral":
                            LieutenantGeneral lieutenant = new LieutenantGeneral(id, firstName, lastName, salary);

                            for (int i = 5; i < splitted.Length; i++)
                            {
                                int privateId = int.Parse(splitted[i]);
                                ISoldier currentPrivate = soldiers
                                    .FirstOrDefault(s => s.Id == privateId);
                                lieutenant.AddPrivate(currentPrivate);
                            }

                            soldier = lieutenant;
                            break;
                        case "Engineer":
                            string engineerCorps = splitted[5];
                            Engineer engineer = new Engineer(id, firstName, lastName, salary, engineerCorps);

                            for (int i = 6; i < splitted.Length; i += 2)
                            {
                                string repairPart = splitted[i];
                                int repairHours = int.Parse(splitted[i + 1]);
                                IRepair repair = new Repair(repairPart, repairHours);
                                engineer.AddRepair(repair);
                            }

                            soldier = engineer;
                            break;
                        case "Commando":
                            string commandoCorps = splitted[5];
                            Commando commando = new Commando(id, firstName, lastName, salary, commandoCorps);

                            for (int i = 6; i < splitted.Length; i += 2)
                            {
                                string missionCodeName = splitted[i];
                                string missionState = splitted[i + 1];

                                try
                                {
                                    IMission mission = new Mission(missionCodeName, missionState);
                                    commando.AddMission(mission);
                                }
                                catch (ArgumentException) { }

                            }

                            soldier = commando;
                            break;
                        default:
                            throw new ArgumentException("Invalid soldier type!");
                    }
                    soldiers.Add(soldier);
                }
                catch (ArgumentException) { }

                input = Console.ReadLine();
            }

            foreach (var soldier in soldiers)
            {
                Console.WriteLine(soldier);
            }
        }
    }
}
