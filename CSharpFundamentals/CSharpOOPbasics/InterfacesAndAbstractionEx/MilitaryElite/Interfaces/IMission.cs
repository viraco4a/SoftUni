namespace MilitaryElite.Interfaces
{
    using MilitaryElite.Enums;
    public interface IMission
    {
        string CodeName { get; }
        MissionState MissionState { get; }
        void CompleteMission();
    }
}
