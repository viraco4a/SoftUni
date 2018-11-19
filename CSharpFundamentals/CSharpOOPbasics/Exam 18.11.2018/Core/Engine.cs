using AnimalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AnimalCentre.Core
{
    public class Engine
    {
        StringBuilder debug = new StringBuilder();
        private AnimalCentre animalCentre;
        private bool isRunning;
        SortedDictionary<string, List<string>> owners;

        public Engine()
        {
            this.animalCentre = new AnimalCentre();
            this.isRunning = false;
            owners = new SortedDictionary<string, List<string>>();
        }

        public void Run()
        {
            this.isRunning = true;

            while (this.isRunning)
            {
                string input = Console.ReadLine();
                string[] tokens = input.Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string command = tokens[0];
                string name;
                int procedureTime;
                string output = "";

                try
                {
                    switch (command)
                    {
                        case "RegisterAnimal":
                            string type = tokens[1];
                            name = tokens[2];
                            int energy = int.Parse(tokens[3]);
                            int happiness = int.Parse(tokens[4]);
                            procedureTime = int.Parse(tokens[5]);
                            output = animalCentre.RegisterAnimal(type, name, energy,
                                happiness, procedureTime);
                            break;
                        case "Chip":
                            name = tokens[1];
                            procedureTime = int.Parse(tokens[2]);
                            output = animalCentre.Chip(name, procedureTime);
                            break;
                        case "Vaccinate":
                            name = tokens[1];
                            procedureTime = int.Parse(tokens[2]);
                            output = animalCentre.Vaccinate(name, procedureTime);
                            break;
                        case "Fitness":
                            name = tokens[1];
                            procedureTime = int.Parse(tokens[2]);
                            output = animalCentre.Fitness(name, procedureTime);
                            break;
                        case "Play":
                            name = tokens[1];
                            procedureTime = int.Parse(tokens[2]);
                            output = animalCentre.Play(name, procedureTime);
                            break;
                        case "DentalCare":
                            name = tokens[1];
                            procedureTime = int.Parse(tokens[2]);
                            output = animalCentre.DentalCare(name, procedureTime);
                            break;
                        case "NailTrim":
                            name = tokens[1];
                            procedureTime = int.Parse(tokens[2]);
                            output = animalCentre.NailTrim(name, procedureTime);
                            break;
                        case "Adopt":
                            name = tokens[1];
                            string owner = tokens[2];
                            output = animalCentre.Adopt(name, owner);
                            if (!owners.ContainsKey(owner))
                            {
                                owners.Add(owner, new List<string>());
                            }
                            owners[owner].Add(name);
                            break;
                        case "History":
                            string procedureType = tokens[1];
                            output = animalCentre.History(procedureType);
                            break;
                        case "End":
                            this.isRunning = false;
                            output = Print();
                            break;
                    }
                }
                catch (InvalidOperationException ioex)
                {
                    output = $"InvalidOperationException: {ioex.Message}";
                }
                catch (ArgumentException aex)
                {
                    output = $"ArgumentException: {aex.Message}";
                }
                Console.WriteLine(output);
                debug.Append(output + Environment.NewLine);
            }

            //Console.WriteLine("_________________________________");
            //Console.WriteLine(debug.ToString());
        }

        private string Print()
        {
            StringBuilder sb = new StringBuilder();
            foreach (var owner in owners)
            {
                sb.AppendLine($"--Owner: {owner.Key}");
                sb.AppendLine($"    - Adopted animals: {string.Join(" ", owner.Value)}");
            }
            return sb.ToString().TrimEnd();
        }
    }
}
