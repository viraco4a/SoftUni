using StorageMaster.Factories;
using StorageMaster.Models.Products;
using StorageMaster.Models.Storages;
using StorageMaster.Models.Vehicles;
using System;
using System.Collections.Generic;
using System.Linq;

namespace StorageMaster.Core
{
    public class StorageMaster
    {
        private ProductFactory productFactory;
        private StorageFactory storageFactory;
        private Vehicle currentVehicle;
        private Dictionary<string, Stack<Product>> products;
        private Dictionary<string, Storage> storages;

        public StorageMaster()
        {
            this.productFactory = new ProductFactory();
            this.storageFactory = new StorageFactory();
            this.products = new Dictionary<string, Stack<Product>>();
            this.storages = new Dictionary<string, Storage>();
        }

        public string AddProduct(string type, double price)
        {
            Product product = this.productFactory.CreateProduct(type, price);
            if (!this.products.ContainsKey(type))
            {
                this.products.Add(type, new Stack<Product>());
            }

            this.products[type].Push(product);

            return $"Added {type} to pool";
        }

        public string RegisterStorage(string type, string name)
        {
            Storage storage = this.storageFactory.CreateStorage(type, name);
            this.storages.Add(name, storage);

            return $"Registered {name}";
        }

        public string SelectVehicle(string storageName, int garageSlot)
        {
            Storage storage = storages[storageName];
            this.currentVehicle = storage.GetVehicle(garageSlot);

            return $"Selected {this.currentVehicle.GetType().Name}";
        }

        public string LoadVehicle(IEnumerable<string> productNames)
        {
            int loadedProducts = 0;
            int productCount = productNames.Count();
            foreach (var productName in productNames)
            {
                if (!currentVehicle.IsFull)
                {
                    break;
                }
                if (!this.products.ContainsKey(productName) ||
                    this.products[productName].Count == 0)
                {
                    throw new InvalidOperationException(
                        $"{productName} is out of stock!");
                }
                Product product = this.products[productName].Pop();
                this.currentVehicle.LoadProduct(product);
                loadedProducts++;
            }
            string vehicleType = currentVehicle.GetType().Name;

            return $"Loaded {loadedProducts}/{productCount} products into {vehicleType}";
        }

        public string SendVehicleTo(string sourceName, int sourceGarageSlot,
            string destinationName)
        {
            if (!storages.ContainsKey(sourceName))
            {
                throw new InvalidOperationException("Invalid source storage!");
            }

            if (!storages.ContainsKey(destinationName))
            {
                throw new InvalidOperationException("Invalid destination storage!");
            }

            Vehicle vehicle = this.storages[sourceName].GetVehicle(sourceGarageSlot);

            int destinationGarageSlot = this.storages[sourceName]
                 .SendVehicleTo(sourceGarageSlot, this.storages[destinationName]);

            string vehicleType = vehicle.GetType().Name;

            return $"Sent {vehicleType} to {destinationName} (slot {destinationGarageSlot})";
        }

        public string UnloadVehicle(string storageName, int garageSlot)
        {
            Vehicle vehicle = this.storages[storageName].GetVehicle(garageSlot);
            int unloadedProducts = this.storages[storageName].UnloadVehicle(garageSlot);
            int productsInVehicle = vehicle.Trunk.Count();

            return $"Unloaded {unloadedProducts}/{productsInVehicle} products at {storageName}";
        }

        public string GetStorageStatus(string storageName)
        {
            Storage storage = this.storages[storageName];

            double sumProductWeight = storage.Products.Sum(s => s.Weight);
            int capacity = storage.Capacity;

            Dictionary<string, int> products = new Dictionary<string, int>();
            foreach (Product product in storage.Products)
            {
                string productName = product.GetType().Name;
                if (!products.ContainsKey(productName))
                {
                    products.Add(productName, 0);
                }
                products[productName]++;
            }

            //Option 1:
            //var sortedProducts = products
            //    .OrderByDescending(s => s.Value)
            //    .ThenBy(s => s.Key)
            //    .ToDictionary(k => k.Key, v => v.Value);

            //string[] stockInfo = new string[sortedProducts.Count];
            //int firstIndex = 0;
            //foreach (var product in sortedProducts)
            //{
            //    string currentResult = $"{product.Key} ({product.Value})";
            //    stockInfo[firstIndex++] = currentResult;
            //}
            //Option 2:

            string[] stockInfo = products
                .OrderByDescending(s => s.Value)
                .ThenBy(s => s.Key)
                .Select(kvp => $"{kvp.Key} ({kvp.Value})")
                .ToArray();

            string stockLine = $"Stock ({sumProductWeight}/{capacity}): [{string.Join(", ", stockInfo)}]";
            //TODO: continue
            string[] vehicles = new string[storage.Garage.Count];

            int index = 0;
            foreach (Vehicle vehicle in storage.Garage)
            {
                if (vehicle == null)
                {
                    vehicles[index] = "empty";
                }
                else
                {
                    vehicles[index] = vehicle.GetType().Name;
                }
                index++;
            }

        }

        public string GetSummary()
        {
            throw new NotImplementedException();
        }
    }
}
