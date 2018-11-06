using System;
using System.Text.RegularExpressions;

namespace Telephony
{
    public class Smartphone : IWeb, ICallable
    {
        private const string ONLY_DIGIT_PATTERN = @"[\d]";
        private const string NO_DIGIT_PATTERN = @"[^\d]";
        private string calledPhone;
        private string url;

        public string Url
        {
            get { return url; }
            set
            {
                string pattern = ONLY_DIGIT_PATTERN;
                if (Regex.IsMatch(value, pattern))
                {
                    throw new ArgumentException("Invalid URL!");
                }
                url = value;
            }
        }

        public string CalledPhone
        {
            get { return calledPhone; }
            set
            {
                string pattern = NO_DIGIT_PATTERN;
                if (Regex.IsMatch(value, pattern))
                {
                    throw new ArgumentException("Invalid number!");
                }
                calledPhone = value;
            }
        }

        public string Browsing()
        {
            return $"Browsing: {this.Url}!";
        }

        public string Calling()
        {
            return $"Calling... {this.CalledPhone}";
        }
    }
}
