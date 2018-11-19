package CarShopExtend;

public abstract class Rentable implements Car{
    protected Integer minRentDays;
    protected Double pricePerDay;
    public abstract Integer getMinRentDay();
    public abstract Double getPricePerDay();
}
