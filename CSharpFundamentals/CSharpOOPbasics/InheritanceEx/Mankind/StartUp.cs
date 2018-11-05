using System;

namespace Mankind
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            try
            {
                string[] studentData = ReadData();
                string studentFirstName = studentData[0];
                string studentLastName = studentData[1];
                string facultyNumber = studentData[2];
                Student student = new Student(studentFirstName,
                                              studentLastName,
                                              facultyNumber);

                string[] workerData = ReadData();
                string workerFirstName = workerData[0];
                string workerLastName = workerData[1];
                decimal salary = decimal.Parse(workerData[2]);
                double workHours = double.Parse(workerData[3]);
                Worker worker = new Worker(workerFirstName,
                              workerLastName,
                              salary,
                              workHours);

                Console.WriteLine(student);
                Console.WriteLine();
                Console.WriteLine(worker);
            }
            catch (ArgumentException ae)
            {
                Console.WriteLine(ae.Message);
            }
        }

        private static string[] ReadData()
        {
            return Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries);
        }
    }
}