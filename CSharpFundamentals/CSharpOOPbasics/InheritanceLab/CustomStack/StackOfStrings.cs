using System.Collections.Generic;
using System.Linq;

namespace CustomStack
{
    public class StackOfStrings
    {
        private List<string> data = new List<string>();

        public void Push(string element)
        {
            this.data.Add(element);
        }

        public string Pop()
        {
            string result = string.Empty;

            if (!IsEmpty())
            {
                result = this.data.Last();
                data.RemoveAt(this.data.Count - 1);
            }

            return result;
        }

        public string Peek()
        {
            return this.data.Last();
        }

        public bool IsEmpty()
        {
            return this.data.Count == 0;
        }
    }
}
