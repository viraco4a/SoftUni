package shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<String, Person> people = new LinkedHashMap<>();
    private static Map<String, Product> products = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] peopleData = reader.readLine().split(";");
        String[] productData = reader.readLine().split(";");

        getAllPeople(peopleData);
        getAllProducts(productData);
        peopleGetProducts(reader);
        people.values().forEach(System.out::println);
    }

    private static void peopleGetProducts(BufferedReader reader) throws IOException {
        String command;

        while (!"END".equals(command = reader.readLine())) {
            try {
                String[] tokens = command.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];
                if (people.containsKey(personName)) {
                    Person person = people.get(personName);
                    Product product = products.get(productName);
                    person.buyProduct(product);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getAllProducts(String[] productData) {
        for (String data : productData) {
            String[] tokens = data.split("=");
            String name = tokens[0];
            double cost = Double.parseDouble(tokens[1]);
            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getAllPeople(String[] peopleData) {
        for (String data : peopleData) {
            String[] tokens = data.split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);
            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
