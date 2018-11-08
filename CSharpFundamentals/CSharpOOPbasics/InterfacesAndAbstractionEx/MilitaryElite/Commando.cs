using MilitaryElite.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace MilitaryElite
{
    public class Commando : SpecializedSoldier, ICommando
    {
        private ICollection<IMission> missions;
        public IReadOnlyCollection<IMission> Missions => (IReadOnlyCollection<IMission>)this.missions;        

        public Commando(int id, string firstName, string lastName, decimal salary, string corps)
            : base(id, firstName, lastName, salary, corps)
        {
            this.missions = new List<IMission>();
        }

        public void AddMission(IMission mission)
        {
            missions.Add(mission);
        }

        public void CompleteMission(string missionCodeName)
        {
            IMission mission = this.Missions.FirstOrDefault(s => s.CodeName == missionCodeName);
            if (mission == null)
            {
                throw new ArgumentException("Mission not found!");
            }

            mission.CompleteMission();
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine(base.ToString());
            sb.AppendLine("Missions:");
            missions.ToList().ForEach(m =>
            {
                sb.AppendLine($"  {m}");
            });

            return sb.ToString().TrimEnd();
        }
    }
}
