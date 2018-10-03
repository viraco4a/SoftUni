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
            string destination = Path.Combine("../../../", "copyMe-copy1.png");

            using (FileStream readFile = new FileStream(path, FileMode.Open, FileAccess.ReadWrite))
            {
                using (FileStream writeFile = new FileStream(destination, FileMode.Create, FileAccess.ReadWrite))
                {
                    byte[] buffer = new byte[4096];

                    while (true)
                    {
                        int bytesCount = readFile.Read(buffer, 0, buffer.Length);
                        if (bytesCount == 0)
                        {
                            break;
                        }
                        writeFile.Write(buffer, 0, bytesCount);
                    }
                }
            }
        }
    }
}
