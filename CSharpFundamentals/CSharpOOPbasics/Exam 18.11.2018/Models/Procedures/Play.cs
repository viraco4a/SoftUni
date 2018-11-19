using AnimalCentre.Models.Contracts;
using System;

namespace AnimalCentre.Models.Procedures
{
    public class Play : Procedure
    {
        public Play() : base() { }

        public override void DoService(IAnimal animal, int procedureTime)
        {
            if (animal.ProcedureTime < procedureTime)
            {
                throw new ArgumentException("Animal doesn't have enough procedure time");
            }

            animal.Happiness += 12;
            animal.Energy -= 6;

            animal.ProcedureTime -= procedureTime;

            this.procedureHistory.Add(animal);
            
        }
    }
}
