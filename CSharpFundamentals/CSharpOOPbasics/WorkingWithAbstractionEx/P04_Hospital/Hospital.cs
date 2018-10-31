using System;
using System.Collections.Generic;
using System.Linq;

namespace P04_Hospital
{
    public class Hospital
    {
        private static Dictionary<string, List<string>> doctors;
        private static Dictionary<string, List<List<string>>> departments;
        public static void Main()
        {
            doctors = new Dictionary<string, List<string>>();
            departments = new Dictionary<string, List<List<string>>>();

            string input = Console.ReadLine();
            while (input != "Output")
            {
                string[] args = input.Split();
                var departament = args[0];
                var docFirstName = args[1];
                var docLastName = args[2];
                var patient = args[3];
                var doctorName = docFirstName + docLastName;

                FillData(departament, doctorName);

                FillBeds(departament, patient, doctorName);

                input = Console.ReadLine();
            }

            input = Console.ReadLine();

            while (input != "End")
            {
                string[] args = input.Split();

                Print(args);
                input = Console.ReadLine();
            }
        }

        private static void Print(string[] args)
        {
            if (args.Length == 1)
            {
                Console.WriteLine(string.Join("\n",
                    departments[args[0]]
                    .Where(x => x.Count > 0)
                    .SelectMany(x => x)));
            }
            else if (args.Length == 2 &&
                int.TryParse(args[1],
                out int room))
            {
                Console.WriteLine(string.Join("\n",
                    departments[args[0]][room - 1]
                    .OrderBy(x => x)));
            }
            else
            {
                Console.WriteLine(string.Join("\n",
                    doctors[args[0] + args[1]]
                    .OrderBy(x => x)));
            }
        }

        private static void FillBeds(string departament, string patient, string doctorName)
        {
            bool hasFreeBeds = departments[departament]
                .SelectMany(x => x).Count() < 60;
            if (hasFreeBeds)
            {
                int room = 0;
                doctors[doctorName].Add(patient);
                for (int i = 0; i < departments[departament].Count; i++)
                {
                    if (departments[departament][i].Count < 3)
                    {
                        room = i;
                        break;
                    }
                }
                departments[departament][room].Add(patient);
            }
        }

        private static void FillData(string departament, string doctorName)
        {
            if (!doctors.ContainsKey(doctorName))
            {
                doctors[doctorName] = new List<string>();
            }
            if (!departments.ContainsKey(departament))
            {
                departments[departament] = new List<List<string>>();
                for (int i = 0; i < 20; i++)
                {
                    departments[departament].Add(new List<string>());
                }
            }
        }
    }
}
