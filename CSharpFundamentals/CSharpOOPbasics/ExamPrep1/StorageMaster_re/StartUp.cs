namespace StorageMaster
{
    using StorageMaster.Core;
    using System;

    public class StartUp
    {
        static void Main(string[] args)
        {
            Engine engine = new Engine();
            engine.Run();
        }
    }
}
