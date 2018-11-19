using AnimalCentre.Models.Contracts;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace AnimalCentre.Models.Hotels
{
    public class Hotel : IHotel
    {
        private Dictionary<string, IAnimal> animals;
        public int Capacity { get; private set; }

        public Hotel()
        {
            this.Capacity = 10;
            this.animals = new Dictionary<string, IAnimal>();
        }

        public IReadOnlyDictionary<string, IAnimal> Animals => new ReadOnlyDictionary<string, IAnimal>(this.animals);

        public void Accommodate(IAnimal animal)
        {
            string animalName = animal.Name;

            if (this.Capacity <= this.Animals.Count)
            {
                throw new InvalidOperationException("Not enough capacity");
            }

            if (this.Animals.ContainsKey(animalName))
            {
                throw new ArgumentException($"Animal {animalName} already exist");
            }

            this.animals.Add(animalName, animal);

        }

        public void Adopt(string animalName, string owner)
        {
            if (!this.Animals.ContainsKey(animalName))
            {
                throw new ArgumentException($"Animal {animalName} does not exist");
            }

            IAnimal animal = this.Animals[animalName];

            animal.IsAdopt = true;
            animal.Owner = owner;
            this.animals.Remove(animalName);
        }
    }
}
