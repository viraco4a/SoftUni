﻿using System;

namespace PersonsInfo
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            var lines = int.Parse(Console.ReadLine());
            Team team = new Team("SoftUni");

            for (int i = 0; i < lines; i++)
            {
                var cmdArgs = Console.ReadLine().Split();

                try
                {
                    var person = new Person(cmdArgs[0],
                        cmdArgs[1],
                        int.Parse(cmdArgs[2]),
                        decimal.Parse(cmdArgs[3]));
                    team.AddPlayer(person);
                }
                catch (ArgumentException argEx)
                {
                    Console.WriteLine(argEx.Message);
                }
            }

            Console.WriteLine(team.ToString());
        }
    }
}
