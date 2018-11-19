namespace AnimalCentre.Models.Contracts
{
    public interface IAnimal
    {
        string Name { get; set; }
        int Happiness { get; set; }
        int Energy { get; set; }
        int ProcedureTime { get; set; }
        string Owner { get; set; }
        bool IsAdopt { get; set; }
        bool IsChipped { get; set; }
        bool IsVaccinated { get; set; }
        //string Name { get; }
        //int Happiness { get; }
        //int Energy { get; }
        //int ProcedureTime { get; }
        //string Owner { get; }
        //bool IsAdopt { get; }
        //bool IsChipped { get; }
        //bool IsVaccinated { get; }
    }
}
