using System;
using System.Collections.Generic;
using System.Linq;

namespace FootballTeamGenerator
{
    public class FootballTeam
    {
        private string name;
        private int rating;
        private List<Player> players;

        public FootballTeam(string name)
        {
            this.Name = name;
            this.Players = new List<Player>();
        }

        private List<Player> Players
        {
            get { return players; }
            set { players = value; }
        }

        public int Rating
        {
            get { return rating; }
            private set
            {
                rating = CalcRating();
            }
        }

        public string Name
        {
            get { return name; }
            private set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("A name should not be empty.");
                }
                name = value;
            }
        }

        private int CalcRating()
        {
            double rating = Players.Sum(s => s.AverageStats) / Players.Count;
            if (Players.Count == 0)
            {
                return 0;
            }
            return (int)Math.Round(rating, 0);
        }

        public void AddPlayer(Player player)
        {
            Players.Add(player);
            this.Rating = CalcRating();
        }

        public void RemovePlayer(string playerName)
        {
            Player player = Players.FirstOrDefault(s => s.Name == playerName);
            if (player == null)
            {
                throw new NullReferenceException($"Player {playerName} is not in {Name} team.");
            }
            Players.Remove(player);
            this.Rating = CalcRating();
        }
    }
}
