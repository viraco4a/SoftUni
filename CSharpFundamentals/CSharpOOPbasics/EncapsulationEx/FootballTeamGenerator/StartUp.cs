using System;
using System.Collections.Generic;
using System.Linq;

namespace FootballTeamGenerator
{
    public class StartUp
    {
        private static Dictionary<string, FootballTeam> footballTeams = new Dictionary<string, FootballTeam>();
        static void Main(string[] args)
        {
            string command = Console.ReadLine();
            while (command != "END")
            {
                string[] splitted = command.Split(";", StringSplitOptions.RemoveEmptyEntries);
                switch (splitted[0])
                {
                    case "Team": AddTeam(splitted[1]); break;
                    case "Add": AddPlayer(splitted); break;
                    case "Remove": RemovePlayer(splitted); break;
                    case "Rating": ShowRating(splitted[1]); break;
                }
                command = Console.ReadLine();
            }
        }

        private static void ShowRating(string team)
        {
            if (!footballTeams.ContainsKey(team))
            {
                Console.WriteLine($"Team {team} does not exist.");
            }
            else
            {
                Console.WriteLine($"{footballTeams[team].Name} - {footballTeams[team].Rating}");
            }
        }

        private static void RemovePlayer(string[] splitted)
        {
            string teamName = splitted[1];
            if (!footballTeams.ContainsKey(teamName))
            {
                Console.WriteLine($"Team {teamName} does not exist.");
            }
            else
            {
                string playerName = splitted[2];
                try
                {
                    footballTeams[teamName].RemovePlayer(playerName);
                }
                catch (NullReferenceException nullEx)
                {
                    Console.WriteLine(nullEx.Message);
                }
            }
        }

        private static void AddPlayer(string[] splitted)
        {
            string teamName = splitted[1];
            if (!footballTeams.ContainsKey(teamName))
            {
                Console.WriteLine($"Team {teamName} does not exist.");
            }
            else
            {
                string playerName = splitted[2];
                int endurance = int.Parse(splitted[3]);
                int sprint = int.Parse(splitted[4]);
                int dribble = int.Parse(splitted[5]);
                int passing = int.Parse(splitted[6]);
                int shooting = int.Parse(splitted[7]);
                try
                {
                    Player player = new Player(playerName, endurance, sprint, 
                        dribble, passing, shooting);
                    footballTeams[teamName].AddPlayer(player);
                }
                catch (ArgumentException argEx)
                {
                    Console.WriteLine(argEx.Message);
                }
            }
        }

        private static void AddTeam(string team)
        {
            try
            {
                FootballTeam footballTeam = new FootballTeam(team);
                footballTeams.Add(team, footballTeam);
            }
            catch (ArgumentException argEx)
            {
                Console.WriteLine(argEx.Message);
            }
        }
    }
}
