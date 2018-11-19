namespace AnimalCentre.Models.Contracts
{
    using System.Collections.Generic;
    using System.Collections.ObjectModel;

    public interface IProcedure
    {
        ReadOnlyCollection<IAnimal> ProcedureHistory { get; }

        string History();

        void DoService(IAnimal animal, int procedureTime);
    }
}
