using StorageMaster.Factories;
using StorageMaster.Models.Products;
using StorageMaster.Models.Storage;
using StorageMaster.Models.Vehicles;
using System;
using System.Collections.Generic;
using System.Linq;

namespace StorageMaster.Core
{
    public class StorageMaster
    {
        private Vehicle currentVehicle;
        private Dictionary<string, Stack<Product>> products;
        private Dictionary<string, Storage> storages;
        private ProductFactory productFactory;
        private StorageFactory storageFactory;

        public StorageMaster()
        {
            productFactory = new ProductFactory();
            storageFactory = new StorageFactory();
            products = new Dictionary<string, Stack<Product>>();
            storages = new Dictionary<string, Storage>();
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
            this.currentVehicle = this.storages[storageName].GetVehicle(garageSlot);

            return $"Selected {this.currentVehicle.GetType().Name}";
        }

        public string LoadVehicle(IEnumerable<string> productNames)
        {
            int productCount = productNames.Count();
            int loadedProductsCount = 0;
            string vehicleType = this.currentVehicle.GetType().Name;
            foreach (string productName in productNames)
            {
                if (!this.products.ContainsKey(productName)
                    || this.products[productName].Count == 0)
                {
                    throw new InvalidOperationException($"{productName} is out of stock!");
                }

                if (this.currentVehicle.IsFull)
                {
                    break;
                }


                Product product = this.products[productName].Pop();

                this.currentVehicle.LoadProduct(product);
                loadedProductsCount++;
            }

            return $"Loaded {loadedProductsCount}/{productCount} products into {vehicleType}";
        }

        public string SendVehicleTo(string sourceName, int sourceGarageSlot, string destinationName)
        {
            if (!storages.ContainsKey(sourceName))
            {
                throw new InvalidOperationException("Invalid source storage!");
            }

            if (!storages.ContainsKey(destinationName))
            {
                throw new InvalidOperationException("Invalid destination storage!");
            }

            Storage sourceStorage = this.storages[sourceName];
            Storage destinationStorage = this.storages[destinationName];
            Vehicle vehicle = sourceStorage.GetVehicle(sourceGarageSlot);

            int destinationGarageSlot = sourceStorage
                .SendVehicleTo(sourceGarageSlot, destinationStorage);

            string vehicleType = vehicle.GetType().Name;

            return $"Sent {vehicleType} to {destinationName} (slot {destinationGarageSlot})";
        }

        public string UnloadVehicle(string storageName, int garageSlot)
        {
            Storage storage = this.storages[storageName];
            Vehicle vehicle = storage.GetVehicle(garageSlot);

            int productsInVehicle = vehicle.Trunk.Count;

            int unloadedProductsCount = storage.UnloadVehicle(garageSlot);

            return $"Unloaded {unloadedProductsCount}/{productsInVehicle} products at {storageName}";
        }

        public string GetStorageStatus(string storageName)
        {
            Storage storage = this.storages[storageName];

            Dictionary<string, int> groupedProducts = GetGroupedProducts(storage);

            string stockLine = GetStockLine(storage, groupedProducts);

            string garageLine = GetGarageLine(storage);

            string result = stockLine + Environment.NewLine + garageLine;

            return result;
        }

        public string GetSummary()
        {
            string[] formatedStorages = this.storages
                .Select(s => s.Value)
                .OrderByDescending(o => o.Products.Sum(s => s.Price))
                .Select(s => 
                $"{s.Name}:{Environment.NewLine}Storage worth: ${s.Products.Sum(m => m.Price):F2}")
                .ToArray();

            string result = string.Join("\n", formatedStorages);

            return result;
        }

        private static string GetGarageLine(Storage storage)
        {
            string[] garageLineData = storage.Garage
                .Select(s => s == null ? "empty" : $"{s.GetType().Name}")
                .ToArray();

            string garageLine = string.Join("|", garageLineData);
            return $"Garage: [{garageLine}]";
        }

        private static string GetStockLine(Storage storage, Dictionary<string, int> groupedProducts)
        {
            string[] stockInfoData = groupedProducts
                .OrderByDescending(o => o.Value)
                .ThenBy(o => o.Key)
                .Select(s => $"{s.Key} ({s.Value})")
                .ToArray();
            string stockInfo = string.Join(", ", stockInfoData);
            double sumWeight = storage.Products.Sum(s => s.Weight);
            string stockLine = $"Stock ({sumWeight}/{storage.Capacity}): [{stockInfo}]";
            return stockLine;
        }

        private static Dictionary<string, int> GetGroupedProducts(Storage storage)
        {
            Dictionary<string, int> groupedProducts = new Dictionary<string, int>();
            foreach (Product product in storage.Products)
            {
                string productName = product.GetType().Name;
                if (!groupedProducts.ContainsKey(productName))
                {
                    groupedProducts.Add(productName, 0);
                }

                groupedProducts[productName]++;
            }

            return groupedProducts;
        }
    }
}
