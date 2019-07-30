package shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.length() == 0 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            System.out.printf("%s can't afford %s%n",
                    this.getName(),
                    product.getName());
        } else {
            this.products.add(product);
            this.setMoney(this.money - product.getCost());
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - ");
        if (this.products.size() == 0) {
            sb.append("Nothing bought");
        } else {
            for (int i = 0; i < this.products.size() - 1; i++) {
                sb.append(products.get(i).getName()).append(", ");
            }
            sb.append(products.get(products.size() - 1).getName());
        }
        return sb.toString().trim();
    }
}
