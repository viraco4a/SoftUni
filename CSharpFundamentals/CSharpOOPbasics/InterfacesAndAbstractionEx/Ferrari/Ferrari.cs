using System.Text;

namespace Ferrari
{
    public class Ferrari : ICar
    {
        private const string MODEL = "488-Spider";
        private const string STOP = "Brakes!";
        private const string START = "Zadu6avam sA!";

        public string Model { get; private set; }
        public string Driver { get; private set; }

        public Ferrari(string driver)
        {
            this.Driver = driver;
            this.Model = MODEL;
        }

        public string brake()
        {
            return STOP;
        }

        public string gas()
        {
            return START;
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append($"{Model}/{brake()}/{gas()}/{Driver}");
            return sb.ToString().TrimEnd();
        }
    }
}
