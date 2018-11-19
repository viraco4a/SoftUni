using AnimalCentre.Models.Contracts;
using System;

namespace AnimalCentre.Models.Procedures
{
    public class DentalCare : Procedure
    {
        public DentalCare() : base() { }
        public override void DoService(IAnimal animal, int procedureTime)
        {
            if (animal.ProcedureTime < procedureTime)
            {
                throw new ArgumentException("Animal doesn't have enough procedure time");
            }

            animal.Happiness += 12;
            animal.Energy += 10;

            animal.ProcedureTime -= procedureTime;

            this.procedureHistory.Add(animal);
        }
    }
}
