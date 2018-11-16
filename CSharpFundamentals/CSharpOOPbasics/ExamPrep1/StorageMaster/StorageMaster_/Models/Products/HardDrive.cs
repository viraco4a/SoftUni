namespace StorageMaster.Models.Products
{
    public class HardDrive : Product
    {
        private const double HD_WEIGHT = 1;

        public HardDrive(double price) 
            : base(price, HD_WEIGHT) { }
    }
}
