namespace MordorCruelPlan.Foods
{
    public abstract class Food
    {
        public int Happiness { get; }

        protected Food(int happiness)
        {
            this.Happiness = happiness;
        }
    }
}
