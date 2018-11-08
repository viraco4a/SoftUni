using System.Collections.Generic;

namespace CollectionHierarchy
{
    class AddRemoveCollection : IAdd, IRemove
    {
        private List<string> data;

        public AddRemoveCollection()
        {
            this.data = new List<string>();
        }

        public int Add(string element)
        {
            this.data.Insert(0, element);
            return this.data.IndexOf(element);
        }

        public string Remove()
        {
            string element = data[data.Count - 1];
            this.data.RemoveAt(this.data.Count - 1);
            return element;
        }
    }
}
