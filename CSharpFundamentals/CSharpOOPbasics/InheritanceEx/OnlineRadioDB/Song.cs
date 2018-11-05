namespace OnlineRadioDB
{
    public class Song
    {
        private string artist;
        private string name;
        private int minutes;
        private int seconds;

        public Song(string artist, string name, int minutes, int seconds)
        {
            this.Artist = artist;
            this.Name = name;
            this.Minutes = minutes;
            this.Seconds = seconds;
        }

        public int Seconds
        {
            get { return seconds; }
            private set
            {
                if (value < InvalidSongSecondsException.MIN_SECONDS ||
                    value > InvalidSongSecondsException.MAX_SECONDS)
                {
                    throw new InvalidSongSecondsException();
                }
                seconds = value;
            }
        }

        public int Minutes
        {
            get { return minutes; }
            private set
            {
                if (value < InvalidSongMinutesException.MIN_MINUTES ||
                    value > InvalidSongMinutesException.MAX_MINUTES)
                {
                    throw new InvalidSongMinutesException();
                }
                minutes = value;
            }
        }

        public string Name
        {
            get { return name; }
            private set
            {
                if (value.Length < InvalidSongNameException.MIN_SONG_NAME_LENGTH ||
                    value.Length > InvalidSongNameException.MAX_SONG_NAME_LENGTH)
                {
                    throw new InvalidSongNameException();
                }
                name = value;
            }
        }

        public string Artist
        {
            get { return artist; }
            private set
            {
                if (value.Length < InvalidArtistNameException.MIN_ARTIST_NAME_LENGTH ||
                    value.Length > InvalidArtistNameException.MAX_ARTIST_NAME_LENGTH)
                {
                    throw new InvalidArtistNameException();
                }
                artist = value;
            }
        }
    }
}
