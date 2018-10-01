using System;
using System.Collections.Generic;
using System.Linq;

namespace ParkingLot
{
    class ParkingLot
    {
        static void Main(string[] args)
        {
            HashSet<string> set = new HashSet<string>();
            string input = Console.ReadLine();
            while (input != "END")
            {
                var splitted = input
                    .Split(", ", StringSplitOptions.RemoveEmptyEntries);
                string direction = splitted[0];
                string car = splitted[1];
                if (direction == "IN")
                {
                    set.Add(car);
                }
                else
                {
                    set.Remove(car);
                }

                input = Console.ReadLine();
            }
            if (set.Count == 0)
            {
                Console.WriteLine("Parking Lot is Empty");
                return;
            }
            set.ToList().ForEach(s => Console.WriteLine(s));
        }
    }
}
