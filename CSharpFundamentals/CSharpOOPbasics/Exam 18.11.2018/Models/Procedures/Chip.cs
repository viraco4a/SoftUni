using AnimalCentre.Models.Contracts;
using System;

namespace AnimalCentre.Models.Procedures
{
    public class Chip : Procedure
    {
        public Chip() : base() { }

        public override void DoService(IAnimal animal, int procedureTime)
        {
            if (animal.IsChipped)
            {
                throw new ArgumentException($"{animal.Name} is already chipped");
            }

            if (animal.ProcedureTime < procedureTime)
            {
                throw new ArgumentException("Animal doesn't have enough procedure time");
            }

            animal.IsChipped = true;
            animal.Happiness -= 5;

            animal.ProcedureTime -= procedureTime;

            this.procedureHistory.Add(animal);
        }
    }
}
