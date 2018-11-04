using System;

namespace PizzaCalories
{
    public class StartUp
    {
        private static Pizza pizza;
        static void Main(string[] args)
        {
            var pizzaInput = Console.ReadLine().Split();
            string pizzaName = pizzaInput[1];
            try
            {
                pizza = new Pizza(pizzaName);
            }
            catch (ArgumentException argEx)
            {
                Console.WriteLine(argEx.Message);
                return;
            }

            var doughInput = Console.ReadLine().Split();
            string doughType = doughInput[1];
            string bakingTEchnique = doughInput[2];
            int doughWeight = int.Parse(doughInput[3]);            

            try
            {
                Dough dough = new Dough(doughType, bakingTEchnique, doughWeight);
                pizza.Dough = dough;
            }
            catch (ArgumentException argEx)
            {
                Console.WriteLine(argEx.Message);
                return;
            }

            string command = Console.ReadLine();
            while (command != "END")
            {
                var toppingInput = command.Split();
                string toppingType = toppingInput[1];
                int toppingWeight = int.Parse(toppingInput[2]);

                try
                {
                    Topping topping = new Topping(toppingType, toppingWeight);
                    try
                    {
                        pizza.AddTopping(topping);
                    }
                    catch (ArgumentException argEx)
                    {
                        Console.WriteLine(argEx.Message);
                        return;
                    }
                }
                catch (ArgumentException argEx)
                {
                    Console.WriteLine(argEx.Message);
                    return;
                }
                command = Console.ReadLine();
            }

            Console.WriteLine(pizza);
        }
    }
}
