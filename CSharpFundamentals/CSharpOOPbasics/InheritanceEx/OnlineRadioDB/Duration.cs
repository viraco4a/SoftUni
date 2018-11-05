namespace OnlineRadioDB
{
    public class Duration
    {
        public int Hours { get; set; }
        public int Minutes { get; set; }
        public int Seconds { get; set; }

        public void CalcAll()
        {
            long totalSeconds = this.Seconds + this.Minutes * 60;
            this.Hours = (int)(totalSeconds / 3600);
            int restMin = (int)(totalSeconds % 3600);
            this.Minutes = restMin / 60;
            this.Seconds = restMin % 60;
        }
    }
}
