﻿using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Compression;

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
                    using (GZipStream readFile = new GZipStream(new FileStream(path + ".gz", FileMode.Open),
                        CompressionMode.Decompress))
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

                    string destPath = $"{destinationDirectory}Part{i + 1}.mp4";
                    
                    paths.Add(destPath);

                    long readedBytes = 0;
                    
                    using (FileStream writeFile = new FileStream(destPath, FileMode.Create))
                    {
                        int bytesCouynt = readFile.Read(buffer, 0, buffer.Length);
                        writeFile.Write(buffer, 0, buffer.Length);
                    }

                    using (GZipStream gz = new GZipStream(new FileStream(destPath + ".gz", FileMode.Create), 
                        CompressionMode.Compress, false))
                    {
                        gz.Write(buffer, 0, buffer.Length);
                    }
                }
            }
        }
    }
}
