package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public long getTotalCalories() {
        long sum = 0;
        for (Vegetable vegetable : this.products) {
            sum += vegetable.getCalories();
        }
        return sum;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* Salad %s is %d calories and have %d products:",
                this.getName(),
                this.getTotalCalories(),
                this.getProductCount()));
        sb.append(System.lineSeparator());
        for (int i = 0; i < this.products.size(); i++) {
            if (i != this.products.size() - 1) {
                sb.append(this.products.get(i)).append(System.lineSeparator());
            } else {
                sb.append(this.products.get(i));
            }
        }
        return sb.toString();
    }
}
