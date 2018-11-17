using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace StorageMaster.Core
{
    public class Engine
    {
        private StorageMaster storageMaster;
        private bool isRunning;

        public Engine()
        {
            this.storageMaster = new StorageMaster();
            this.isRunning = false;
        }

        public void Run()
        {
            this.isRunning = true;

            while (this.isRunning)
            {
                string input = Console.ReadLine();
                string[] tokens = input.Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string command = tokens[0];
                string type;
                string storageName;
                int garageSlot;
                string result = "";

                try
                {
                    switch (command)
                    {
                        case "AddProduct":
                            type = tokens[1];
                            double price = double.Parse(tokens[2]);
                            result = this.storageMaster.AddProduct(type, price);
                            break;
                        case "RegisterStorage":
                            type = tokens[1];
                            string name = tokens[2];
                            result = this.storageMaster.RegisterStorage(type, name);
                            break;
                        case "SelectVehicle":
                            storageName = tokens[1];
                            garageSlot = int.Parse(tokens[2]);
                            result = this.storageMaster.SelectVehicle(storageName, garageSlot);
                            break;
                        case "LoadVehicle":
                            result = this.storageMaster.LoadVehicle(tokens.Skip(1));
                            break;
                        case "SendVehicleTo":
                            string sourceName = tokens[1];
                            int sourceGarageSlot = int.Parse(tokens[2]);
                            string destinationName = tokens[3];
                            result = this.storageMaster
                                .SendVehicleTo(sourceName, sourceGarageSlot, destinationName);
                            break;
                        case "UnloadVehicle":
                            storageName = tokens[1];
                            garageSlot = int.Parse(tokens[2]);
                            result = this.storageMaster.UnloadVehicle(storageName, garageSlot);
                            break;
                        case "GetStorageStatus":
                            storageName = tokens[1];
                            result = this.storageMaster.GetStorageStatus(storageName);
                            break;
                        case "END":
                            result = this.storageMaster.GetSummary();
                            this.isRunning = false;
                            break;
                    }
                }
                catch (InvalidOperationException ex)
                {
                    result = $"Error: {ex.Message}";
                }

                Console.WriteLine(result);
            }
        }
    }
}
