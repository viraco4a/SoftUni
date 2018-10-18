using System;
using System.Collections.Generic;
using System.Linq;

namespace PokemonTrainer
{
    public class StartUp
    {
        public static Dictionary<string, Trainer> trainers = new Dictionary<string, Trainer>();
        static void Main(string[] args)
        {
            ReadData();

            PlayGame();

            trainers
                .OrderByDescending(s => s.Value.Badges)
                .ToList()
                .ForEach(e =>
                {
                    Console.WriteLine($"{e.Key} {e.Value.Badges} {e.Value.Pokemons.Count}");
                });
        }

        private static void PlayGame()
        {
            string input = Console.ReadLine();
            while (input != "End")
            {
                foreach (var trainer in trainers.ToList())
                {
                    if (Exist(trainer.Value, input))
                    {
                        trainers[trainer.Key].Badges++;
                    }
                    else
                    {
                        trainers[trainer.Key].Pokemons.ForEach(p =>
                        {
                            p.Health -= 10;
                        });
                        trainers[trainer.Key].Pokemons.RemoveAll(s => s.Health <= 0);
                    }
                }

                input = Console.ReadLine();
            }
        }

        private static bool Exist(Trainer trainer, string input)
        {
            return trainer
                        .Pokemons
                        .Any(s => s.Element == input);
        }

        private static void ReadData()
        {
            string input = Console.ReadLine();
            while (input != "Tournament")
            {
                var splitted = input
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string trainerName = splitted[0];
                string pokemonName = splitted[1];
                string element = splitted[2];
                int health = int.Parse(splitted[3]);

                if (!trainers.ContainsKey(trainerName))
                {
                    Trainer trainer = new Trainer(trainerName, 0, new List<Pokemon>());
                    trainers.Add(trainerName, trainer);
                }

                Pokemon pokemon = new Pokemon(pokemonName, element, health);

                trainers[trainerName].Pokemons.Add(pokemon);

                input = Console.ReadLine();
            }
        }
    }
}
