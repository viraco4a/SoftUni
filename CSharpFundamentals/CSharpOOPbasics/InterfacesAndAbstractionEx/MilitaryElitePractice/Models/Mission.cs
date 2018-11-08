using MilitaryElitePractice.Contracts;
using MilitaryElitePractice.Enums;
using System;
using System.Collections.Generic;
using System.Text;

namespace MilitaryElitePractice.Models
{
    public class Mission : IMission
    {
        public string CodeName { get; private set; }
        public State State { get; private set; }

        public Mission(string codeName, State state)
        {
            CodeName = codeName;
            State = state;
        }

        public void CompleteMission()
        {
            this.State = State.Finished;
        }

        public override string ToString()
        {
            return $"Code Name: {CodeName} State: {State}";
        }
    }
}
