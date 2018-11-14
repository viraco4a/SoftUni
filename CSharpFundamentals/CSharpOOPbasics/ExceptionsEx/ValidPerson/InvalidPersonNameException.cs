using System;

namespace ValidPerson
{
    public class InvalidPersonNameException : Exception
    {
        public string MessageKur { get; set; }
        public InvalidPersonNameException(string message)
        {
            this.MessageKur = message;
        }
    }
}
