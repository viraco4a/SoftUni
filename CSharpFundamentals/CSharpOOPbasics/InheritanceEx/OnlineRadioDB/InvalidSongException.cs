using System;

namespace OnlineRadioDB
{
    public class InvalidSongException : Exception
    {
        public override string Message => "Invalid song.";
    }
}
