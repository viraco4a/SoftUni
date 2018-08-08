using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;

namespace HornetWings
{
    class Program
    {
        static void Main()
        {
            string messagePattern = @"^(\d+) <-> ([A-Za-z0-9]+)$";
            string broadCastPattern = @"^([^\d\n]+) <-> ([A-Za-z0-9]+)$";

            List<string> privateMessages = new List<string>();
            List<string> broadCasts = new List<string>();

            string input = Console.ReadLine();

            while (input != "Hornet is Green")
            {
                Match privateMessage = Regex.Match(input, messagePattern);
                Match broadCast = Regex.Match(input, broadCastPattern);
                if (privateMessage.Success)
                {
                    string recepientCode = string.Join("", privateMessage.Groups[1].Value.Reverse());
                    string message = privateMessage.Groups[2].Value;
                    privateMessages.Add(recepientCode + " -> " + message);
                }

                if (broadCast.Success)
                {
                    string frequencyInput = broadCast.Groups[2].Value;
                    string frequency = "";
                    for (int i = 0; i < frequencyInput.Length; i++)
                    {
                        if (char.IsUpper(frequencyInput[i]))
                        {
                            frequency += frequencyInput[i].ToString().ToLower();
                        }
                        else
                        {
                            frequency += frequencyInput[i].ToString().ToUpper();
                        }
                    }
                    string message = broadCast.Groups[1].Value;

                    broadCasts.Add(frequency + " -> " + message);
                }

                input = Console.ReadLine();
            }

            Console.WriteLine("Broadcasts:");

            Console.WriteLine(broadCasts.Count > 0 ? string.Join("\n", broadCasts) : "None");

            Console.WriteLine("Messages:");

            Console.WriteLine(privateMessages.Count > 0 ? string.Join("\n", privateMessages) : "None");
        }
    }
}
