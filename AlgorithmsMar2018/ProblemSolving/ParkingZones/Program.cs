using System;
using System.Collections.Generic;
using System.Linq;

namespace ParkingZones
{
    class ParkingZone
    {
        public string Name { get; set; }
        public int X { get; set; }
        public int Y { get; set; }
        public int Width { get; set; }
        public int Height { get; set; }
        public double PriceMin { get; set; }

        public bool IsPresent(ParkingSpot current)
        {
            if (current.X >= X && current.X <= X + Width)
            {
                if (current.Y >= Y && current.Y <= Y + Height)
                {
                    return true;
                }
            }

            return false;
        }

        public int CalcDistance(ParkingSpot current, ParkingSpot target)
        {
            var distance = Math.Abs(current.X - target.X) + Math.Abs(current.Y - target.Y) - 1;
            return distance;
        }
    }

    class ParkingSpot
    {
        public int X { get; set; }
        public int Y { get; set; }
    }

    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            var allZones = new List<ParkingZone>();

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split(new char[] { ':' }, StringSplitOptions.RemoveEmptyEntries);
                var numbers = input[1].Split(new char[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries);
                allZones.Add(new ParkingZone
                {
                    Name = input[0],
                    X = int.Parse(numbers[0]),
                    Y = int.Parse(numbers[1]),
                    Width = int.Parse(numbers[2]),
                    Height = int.Parse(numbers[3]),
                    PriceMin = double.Parse(numbers[4])
                });
            }

            var freeInput = Console.ReadLine()
                .Split(new char[] { ';', ' ', ',' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            var freeParkSpots = new List<ParkingSpot>();

            for (int i = 0; i < freeInput.Length; i += 2)
            {
                freeParkSpots.Add(new ParkingSpot
                {
                    X = freeInput[i],
                    Y = freeInput[i + 1]
                });
            }
            var targetLine = Console.ReadLine()
                .Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var target = new ParkingSpot
            {
                X = targetLine[0],
                Y = targetLine[1]
            };
            var timeToPassABlock = int.Parse(Console.ReadLine());
            var finalPrice = double.MaxValue;
            var bestTime = double.MaxValue;
            string finalZone = string.Empty;
            ParkingSpot finalSpot = new ParkingSpot();

            foreach (var zone in allZones)
            {
                for (int i = 0; i < freeParkSpots.Count; i++)
                {
                    var current = freeParkSpots[i];
                    if (zone.IsPresent(current))
                    {
                        var distance = zone.CalcDistance(current, target);
                        var time = Math.Ceiling(distance * 2.0 * timeToPassABlock / 60.0);
                        double price = Math.Ceiling(distance * 2.0 * timeToPassABlock / 60.0) * zone.PriceMin;
                        if (time < bestTime)
                        {
                            bestTime = time;
                        }
                        if (price < finalPrice || (price == finalPrice && time == bestTime) )
                        {
                            finalPrice = price;
                            finalZone = zone.Name;
                            finalSpot.X = current.X;
                            finalSpot.Y = current.Y;
                        }
                    }
                }
            }
            Console.WriteLine($"Zone Type: {finalZone}; X: {finalSpot.X}; Y: {finalSpot.Y}; Price: {finalPrice:F2}");
        }
    }
}
