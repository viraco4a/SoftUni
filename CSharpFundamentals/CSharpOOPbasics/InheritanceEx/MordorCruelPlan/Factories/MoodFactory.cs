namespace MordorCruelPlan.Factories
{
    using System;
    using Moods;

    public class MoodFactory
    {
        public Mood CreateMood(string type)
        {
            type = type.ToLower();
            switch (type)
            {
                case "angry": return new Angry();
                case "sad": return new Sad();
                case "happy": return new Happy();
                case "javascript": return new JavaScript();
                default: throw new ArgumentException("Invalid mood type");
            }
        }
    }
}
