using AnimalCentre.Factories;
using AnimalCentre.Models;
using AnimalCentre.Models.Contracts;
using AnimalCentre.Models.Hotels;
using AnimalCentre.Models.Procedures;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AnimalCentre.Core
{
    public class AnimalCentre
    {
        private AnimalFactory animalFactory;
        private ProcedureFactory procedureFactory;
        private Hotel hotel;
        private Dictionary<string, List<IAnimal>> procedures;
        private IAnimal currentAnimal;

        public AnimalCentre()
        {
            animalFactory = new AnimalFactory();
            procedureFactory = new ProcedureFactory();
            hotel = new Hotel();
            procedures = new Dictionary<string, List<IAnimal>>();
        }

        public string RegisterAnimal(string type, string name, int energy,
            int happiness, int procedureTime)
        {
            Animal animal = animalFactory.CreateAnimal(type, name, energy,
                happiness, procedureTime);
            this.hotel.Accommodate(animal);

            string result = $"Animal {name} registered successfully";

            return result;
        }

        public string Chip(string name, int procedureTime)
        {
            if (!hotel.Animals.ContainsKey(name))
            {
                throw new ArgumentException($"Animal {name} does not exist");
            }

            DoWork(name, procedureTime, "Chip");

            string result = $"{name} had chip procedure";
            return result;
        }

        public string Vaccinate(string name, int procedureTime)
        {
            if (!hotel.Animals.ContainsKey(name))
            {
                throw new ArgumentException($"Animal {name} does not exist");
            }

            DoWork(name, procedureTime, "Vaccinate");

            string result = $"{name} had vaccination procedure";
            return result;
        }

        public string Fitness(string name, int procedureTime)
        {
            if (!hotel.Animals.ContainsKey(name))
            {
                throw new ArgumentException($"Animal {name} does not exist");
            }

            DoWork(name, procedureTime, "Fitness");

            string result = $"{name} had fitness procedure";
            return result;
        }

        public string Play(string name, int procedureTime)
        {
            if (!hotel.Animals.ContainsKey(name))
            {
                throw new ArgumentException($"Animal {name} does not exist");
            }

            DoWork(name, procedureTime, "Play");

            string result = $"{name} was playing for {procedureTime} hours";
            return result;
        }

        public string DentalCare(string name, int procedureTime)
        {
            if (!hotel.Animals.ContainsKey(name))
            {
                throw new ArgumentException($"Animal {name} does not exist");
            }

            DoWork(name, procedureTime, "DentalCare");

            string result = $"{name} had dental care procedure";
            return result;
        }

        public string NailTrim(string name, int procedureTime)
        {
            if (!hotel.Animals.ContainsKey(name))
            {
                throw new ArgumentException($"Animal {name} does not exist");
            }

            DoWork(name, procedureTime, "NailTrim");

            string result = $"{name} had nail trim procedure";
            return result;
        }

        public string Adopt(string animalName, string owner)
        {
            if (!hotel.Animals.ContainsKey(animalName))
            {
                throw new ArgumentException($"Animal {animalName} does not exist");
            }

            this.currentAnimal = this.hotel.Animals[animalName];

            hotel.Adopt(animalName, owner);

            string result = "";

            if (this.currentAnimal.IsChipped)
            {
                result = $"{owner} adopted animal with chip";
            }
            else
            {
                result = $"{owner} adopted animal without chip";
            }

            return result;
        }

        public string History(string type)
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine(type);

            foreach (var kvp in procedures.Where(s => s.Key == type))
            {
                foreach (Animal animal in kvp.Value)
                {
                    sb.AppendLine(animal.ToString());
                }
            }
            return sb.ToString().TrimEnd();
        }

        private void DoWork(string name, int procedureTime, string procedureType)
        {
            Procedure procedure = procedureFactory.CreateProcedure(procedureType);

            this.currentAnimal = hotel.Animals[name];

            procedure.DoService(this.currentAnimal, procedureTime);

            if (!procedures.ContainsKey(procedureType))
            {
                procedures.Add(procedureType, new List<IAnimal>());
            }

            procedures[procedureType].Add(this.currentAnimal);
        }
    }
}
