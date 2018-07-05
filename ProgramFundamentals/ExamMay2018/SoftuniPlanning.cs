using System;
using System.Collections.Generic;
using System.Linq;

namespace SoftuniPlanning
{
    class Program
    {
        private static List<string> lessons;

        static void Main()
        {
            lessons = Console.ReadLine().Split(new string[] { ", " }, StringSplitOptions.RemoveEmptyEntries).ToList();
            string input = Console.ReadLine();
            while (input != "course start")
            {
                var splitted = input.Split(':');
                string command = splitted[0];
                if (command == "Add")
                {
                    AddCourse(splitted[1]);
                }
                if (command == "Insert")
                {
                    InsertCourse(splitted[1], int.Parse(splitted[2]));
                }
                if (command == "Remove")
                {
                    RemoveCourse(splitted[1]);
                }
                if (command == "Swap")
                {
                    SwapCourse(splitted[1], splitted[2]);
                }
                if (command == "Exercise")
                {
                    ExerciseCourse(splitted[1]);
                }

                input = Console.ReadLine();
            }
            for (int i = 0; i < lessons.Count; i++)
            {
                Console.WriteLine($"{i + 1}.{lessons[i]}");
            }
        }

        private static void ExerciseCourse(string course)
        {
            string exercise = course + "-Exercise";
            if (!lessons.Contains(course))
            {
                lessons.Add(course);
                lessons.Add(exercise);
                return;
            }
            if (lessons.Contains(exercise))
            {
                return;
            }
            int courseIndex = lessons.IndexOf(course);
            List<string> newLessons = new List<string>(lessons.Count + 1);
            newLessons.AddRange(lessons.Take(courseIndex + 1));

            newLessons.Add(exercise);

            for (int i = courseIndex + 1; i < lessons.Count; i++)
            {
                newLessons.Add(lessons[i]);
            }
            lessons = newLessons;
        }

        private static void SwapCourse(string first, string second)
        {
            if (!(lessons.Contains(first) && lessons.Contains(second)))
            {
                return;
            }
            int firstIndex = lessons.IndexOf(first);
            int secondIndex = lessons.IndexOf(second);
            lessons[firstIndex] = second;
            lessons[secondIndex] = first;
            string exerciseFirst = first + "-Exercise";
            string exerciseSecond = second + "-Exercise";

            if (lessons.Contains(exerciseFirst) && lessons.Contains(exerciseSecond))
            {
                SwapCourse(exerciseFirst, exerciseSecond);
                return;
            }
            if (lessons.Contains(exerciseFirst) && !lessons.Contains(exerciseSecond))
            {
                RemoveCourse(exerciseFirst);
                InsertCourse(exerciseFirst, secondIndex + 1);
                return;
            }
            if (!lessons.Contains(exerciseFirst) && lessons.Contains(exerciseSecond))
            {
                RemoveCourse(exerciseSecond);
                InsertCourse(exerciseSecond, firstIndex + 1);
                return;
            }

            return;
        }

        private static void RemoveCourse(string course)
        {
            if (!lessons.Contains(course))
            {
                return;
            }
            lessons.Remove(course);
            string exercise = course + "-Exercise";
            if (lessons.Contains(exercise))
            {
                lessons.Remove(exercise);
            }
        }

        private static void InsertCourse(string course, int index)
        {
            if (lessons.Contains(course) || index < 0 || index > (lessons.Count))
            {
                return;
            }
            lessons.Insert(index, course);
        }

        private static void AddCourse(string course)
        {
            if (lessons.Contains(course))
            {
                return;
            }
            lessons.Add(course);
        }
    }
}
