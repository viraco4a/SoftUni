using AnimalCentre.Models.Contracts;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace AnimalCentre.Models.Procedures
{
    public abstract class Procedure : IProcedure
    {
        protected List<IAnimal> procedureHistory { get; set; }

        public ReadOnlyCollection<IAnimal> ProcedureHistory => this.procedureHistory.AsReadOnly();

        protected Procedure()
        {
            this.procedureHistory = new List<IAnimal>();
        }

        public string History()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine(this.GetType().Name);
            foreach (var animal in ProcedureHistory)
            {
                sb.AppendLine($"    - {animal.Name} - Happiness: {animal.Happiness} - Energy: {animal.Energy}");
            }

            return sb.ToString().TrimEnd();
        }

        public abstract void DoService(IAnimal animal, int procedureTime);
    }
}
