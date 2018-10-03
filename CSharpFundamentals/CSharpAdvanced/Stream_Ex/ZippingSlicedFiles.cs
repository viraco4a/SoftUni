using System;
using System.Collections.Generic;
using System.IO;

namespace ZippingSlicedFiles
{
    class ZippingSlicedFiles
    {
        private static List<string> paths = new List<string>();
        static void Main(string[] args)
        {
            string dir = "../../../";
            string sourceFile = "sliceMe.mp4";
            string path = Path.Combine(dir, sourceFile);
            int parts = 4;

            Slice(path, dir, parts);

            Assemble(dir + "//assembled.mp4");
        }


        private static void Assemble(string destinationDirectory)
        {
            using (FileStream writeFile = new FileStream(destinationDirectory, FileMode.Create))
            {
                byte[] buffer = new byte[1024];

                foreach (var path in paths)
                {
                    using (FileStream readFile = new FileStream(path, FileMode.Open))
                    {

                        while (true)
                        {
                            int byteCount = readFile.Read(buffer, 0, buffer.Length);

                            if (byteCount == 0)
                            {
                                break;
                            }

                            writeFile.Write(buffer, 0, byteCount);
                        }
                    }
                }
            }
        }

        private static void Slice(string sourceFile, string destinationDirectory, int parts)
        {
            using (FileStream readFile = new FileStream(sourceFile, FileMode.Open))
            {
                long size = readFile.Length / parts + readFile.Length % parts;

                byte[] buffer = new byte[size];

                for (int i = 0; i < parts; i++)
                {
                    long readedBytes = 0;

                    string destPath = $"{destinationDirectory}Part{i + 1}.mp4";

                    paths.Add(destPath);

                    using (FileStream writeFile = new FileStream(destPath, FileMode.Create))
                    {
                        int bytesCouynt = readFile.Read(buffer, 0, buffer.Length);
                        writeFile.Write(buffer, 0, buffer.Length);
                    }
                }
            }
        }
    }
}
