using System.Collections.Generic;

namespace MilitaryElite.Interfaces
{
    public interface ICommando : ISpecializedSoldier
    {
        ICollection<IMission> Missions { get; }
        void AddMission(IMission mission);
        void CompleteMission(string missionCodeName);
    }
}
