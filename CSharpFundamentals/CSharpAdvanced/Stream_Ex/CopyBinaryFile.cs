using System;
using System.IO;

namespace CopyBinaryFile
{
    class CopyBinaryFile
    {
        static void Main(string[] args)
        {
            string path = "../../../";
            path = Path.Combine(path, "copyMe.png");
            string destination = Path.Combine("../../../", "copyMe-copy.png");

            using (FileStream readFile = new FileStream(path, FileMode.Open, FileAccess.ReadWrite))
            {
                var size = readFile.Length;

                byte[] buffer = new byte[size];

                readFile.Read(buffer, 0, buffer.Length);

                using (FileStream writeFile = new FileStream(destination, FileMode.Create, FileAccess.ReadWrite))
                {
                    writeFile.Write(buffer, 0, buffer.Length);
                }
            }
        }
    }
}
