using System.Collections.Generic;

namespace CollectionHierarchy
{
    public class MyList : IAdd, IRemove, ICountable
    {
        private List<string> data;
        public int Used { get; private set; }

        public MyList()
        {
            this.data = new List<string>();
        }

        public int Add(string element)
        {
            this.data.Insert(0, element);
            Used++;
            return this.data.IndexOf(element);
        }

        public string Remove()
        {
            string element = this.data[0];
            this.data.RemoveAt(0);
            Used--;
            return element;
        }
    }
}
