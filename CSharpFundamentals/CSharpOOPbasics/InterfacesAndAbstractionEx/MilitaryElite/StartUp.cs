using System;
using MilitaryElite.Interfaces;
using MilitaryElite.Enums;
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
                }

                soldiers.Add(soldier);

                input = Console.ReadLine();
            }
        }
    }
}
