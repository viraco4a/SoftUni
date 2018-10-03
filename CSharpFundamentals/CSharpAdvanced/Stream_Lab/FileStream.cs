using System;
using System.IO;
using System.Text;

namespace FileStreamName
{
    class FileStreamClass
    {
        static void Main(string[] args)
        {
            string text = "Кирилица3";
            var fileStream = new FileStream("../../log.txt", FileMode.Create);

            try
            {
                byte[] bytes = Encoding.UTF8.GetBytes(text);
                fileStream.Write(bytes, 0, bytes.Length);
            }
            finally
            {
                fileStream.Close();
            }
        }
    }
}