namespace MilitaryElite
{
    using MilitaryElite.Interfaces;

    public abstract class Soldier : ISoldier
    {
        public int Id { get; }
        public string FirstName { get; }
        public string LastName { get; }

        public Soldier(int id, string firstName, string lastName)
        {
            Id = id;
            FirstName = firstName;
            LastName = lastName;
        }

        public override string ToString()
        {
            return $"Name: {FirstName} {LastName} Id: {Id}";
        }
    }
}
