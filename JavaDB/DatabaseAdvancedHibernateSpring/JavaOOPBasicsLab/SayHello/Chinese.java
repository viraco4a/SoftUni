package SayHello;

public class Chinese implements Person {
    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void sayHello() {
        System.out.println("Djydjybydjy");
    }
}
