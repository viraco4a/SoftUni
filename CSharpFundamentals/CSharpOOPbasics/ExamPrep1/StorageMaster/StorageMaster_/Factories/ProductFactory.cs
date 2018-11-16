using StorageMaster.Models.Products;
using System;
using System.Collections.Generic;
using System.Text;

namespace StorageMaster.Factories
{
    public class ProductFactory
    {
        public Product CreateProduct(string type, double price)
        {
            Product product = null;
            switch (type)
            {
                case "":
                    product = new Gpu(price);
                    break;
                default:
                    break;
            }

            return product;
        }
    }
}
