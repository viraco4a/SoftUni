using System.Collections.Generic;

namespace MilitaryElite.Interfaces
{
    public interface ICommando : ISpecializedSoldier
    {
        IReadOnlyCollection<IMission> Missions { get; }
        void AddMission(IMission mission);
        void CompleteMission(string missionCodeName);
    }
}
