using System;
using System.Collections.Generic;

namespace CollectionHierarchy
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            AddCollection addCollection = new AddCollection();
            AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
            MyList myList = new MyList();

            string[] input = Console.ReadLine().Split();
            int countOfRemoves = int.Parse(Console.ReadLine());

            List<int> addData = new List<int>();
            List<int> removeData = new List<int>();
            List<int> totData = new List<int>();
            List<string> removeResult = new List<string>();
            List<string> totResult = new List<string>();

            foreach (string word in input)
            {
                addData.Add(addCollection.Add(word));
                removeData.Add(addRemoveCollection.Add(word));
                totData.Add(myList.Add(word));
            }

            for (int i = 0; i < countOfRemoves; i++)
            {
                removeResult.Add(addRemoveCollection.Remove());
                totResult.Add(myList.Remove());
            }

            Console.WriteLine(string.Join(" ", addData));
            Console.WriteLine(string.Join(" ", removeData));
            Console.WriteLine(string.Join(" ", totData));
            Console.WriteLine(string.Join(" ", removeResult));
            Console.WriteLine(string.Join(" ", totResult));
        }
    }
}
