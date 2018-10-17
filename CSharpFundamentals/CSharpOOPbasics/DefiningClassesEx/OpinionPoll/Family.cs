using System;
using System.Collections.Generic;
using System.Text;

namespace DefiningClasses
{
    public class Family
    {
        private List<Person> familyMembers;

        public List<Person> FamilyMembers
        {
            get
            {
                return this.familyMembers;
            }
            set
            {
                this.familyMembers = value;
            }
        }

        public Family()
        {
            this.familyMembers = new List<Person>();
        }

        public void AddMember(Person member)
        {
            if (!this.familyMembers.Contains(member))
            {
                this.familyMembers.Add(member);
            }
        }
    }
}
