using System;
using System.Collections.Generic;
using System.Linq;

namespace OnlineRadioDB
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            List<Song> database = new List<Song>();
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine()
                    .Split(new char[] { ';', ':' }, StringSplitOptions.RemoveEmptyEntries);
                string artistName = input[0];
                string songName = input[1];
                try
                {
                    bool validMinutes = int.TryParse(input[2], out int minutes);
                    bool validSeconds = int.TryParse(input[3], out int seconds);
                    if (validMinutes == false && validSeconds == false)
                    {
                        throw new InvalidSongLengthException();
                    }

                    Song song = new Song(artistName, songName, minutes, seconds);
                    database.Add(song);
                    Console.WriteLine("Song added.");
                }
                catch (InvalidSongLengthException invalidLength)
                {
                    Console.WriteLine(invalidLength.Message);
                }
                catch (InvalidSongException invalidSong)
                {
                    Console.WriteLine(invalidSong.Message);
                }
            }
            Console.WriteLine($"Songs added: {database.Count}");
            //Duration duration = new Duration();
            //foreach (Song song in database)
            //{
            //    duration.Minutes += song.Minutes;
            //    duration.Seconds += song.Seconds;
            //    duration.CalcAll();
            //}
            int totalSecons = database.Sum(s => s.Seconds + s.Minutes * 60);
            TimeSpan timeSpan = TimeSpan.FromSeconds(totalSecons);
            string duration = string.Format($"{timeSpan.Hours}h {timeSpan.Minutes}m {timeSpan.Seconds}s");
            Console.WriteLine($"Playlist length: {duration}");
        }
    }
}
