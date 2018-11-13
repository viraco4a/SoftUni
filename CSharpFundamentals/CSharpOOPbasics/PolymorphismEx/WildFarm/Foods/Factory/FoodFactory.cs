using System;

namespace WildFarm.Foods.Factory
{
    public class FoodFactory
    {
        public Food CreateFood(string type, int quantity)
        {
            type = type.ToLower();
            switch (type)
            {
                case "vegetable":
                    return new Vegetable(quantity);
                case "fruit":
                    return new Vegetable(quantity);
                case "meat":
                    return new Vegetable(quantity);
                case "seeds":
                    return new Vegetable(quantity);
                default:
                    return null;
            }
        }
    }
}
