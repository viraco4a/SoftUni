using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace TCPServer
{
    class TCPServer
    {
        static void Main(string[] args)
        {
            byte[] buffer = new byte[4096];
            int PortNumber = 3080;

            var tcpListener = new TcpListener(IPAddress.Loopback, PortNumber);
            tcpListener.Start();
            Console.WriteLine($"TCP Server listening on port {PortNumber}");

            while (true)
            {
                using (var stream = tcpListener.AcceptTcpClient().GetStream())
                {
                    int readBytes = stream.Read(buffer, 0, buffer.Length);

                    while (readBytes != 0)
                    {
                        Console.WriteLine(Encoding.UTF8.GetString(buffer, 0, readBytes));
                        readBytes = stream.Read(buffer, 0, buffer.Length);
                    }

                    Console.WriteLine();


                    string html = string.Format("{0}{1}{2}{3} - {4}{2}{1}{0}",
                        "<html>", "<body>", "<h1>", "Welcome to my awesome site!", DateTime.Now);

                    byte[] htmlBytes = Encoding.UTF8.GetBytes(html);
                    stream.Write(htmlBytes, 0, htmlBytes.Length);
                }
            }
        }
    }
}
