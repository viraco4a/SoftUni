using System;

namespace PizzaCalories
{
    public class Dough
    {
        private const double WHITE = 1.5;
        private const double WHOLEGRAIN = 1.0;
        private const double CRISPY = 0.9;
        private const double CHEWY = 1.1;
        private const double HOMEMADE = 1.0;

        private string type;
        private string bakingTechnique;
        private int weight;

        public Dough(string type, string bakingTEchnique, int weight)
        {
            this.Type = type;
            this.BakingTechnique = bakingTEchnique;
            this.Weight = weight;
        }

        private int Weight
        {
            get { return weight; }
            set
            {
                if (value < 1 || value > 200)
                {
                    throw new ArgumentException("Dough weight should be in the range [1..200].");
                }
                weight = value;
            }
        }
        private string BakingTechnique
        {
            get { return bakingTechnique; }
            set
            {
                if (value.ToLower() != "crispy" && 
                    value.ToLower() != "chewy" && 
                    value.ToLower() != "homemade")
                {
                    throw new ArgumentException("Invalid type of dough.");
                }
                bakingTechnique = value;
            }
        }

        private string Type
        {
            get { return type; }
            set
            {
                if (value.ToLower() != "white" && value.ToLower() != "wholegrain")
                {
                    throw new ArgumentException("Invalid type of dough.");
                }
                type = value;
            }
        }

        public double Calories()
        {
            double firstMod = this.Type.ToLower() == "white" ? 
                WHITE : 
                WHOLEGRAIN;
            double secondMod = this.BakingTechnique.ToLower() == "crispy" ?
                CRISPY :
                this.BakingTechnique.ToLower() == "chewy" ?
                    CHEWY :
                    HOMEMADE;

            return 2 * this.Weight * firstMod * secondMod;
        }
    }
}
