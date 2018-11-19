using AnimalCentre.Models.Procedures;

namespace AnimalCentre.Factories
{
    public class ProcedureFactory
    {
        public Procedure CreateProcedure(string type)
        {
            Procedure procedure = null;

            switch (type)
            {
                case "Chip":
                    procedure = new Chip();
                    break;
                case "DentalCare":
                    procedure = new DentalCare();
                    break;
                case "Fitness":
                    procedure = new Fitness();
                    break;
                case "NailTrim":
                    procedure = new NailTrim();
                    break;
                case "Play":
                    procedure = new Play();
                    break;
                case "Vaccinate":
                    procedure = new Vaccinate();
                    break;
            }

            return procedure;
        }
    }
}
