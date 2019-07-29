package RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList myRandomList = new RandomArrayList();

        myRandomList.add("Kur1");
        myRandomList.add("Kur2");
        myRandomList.add("Kur3");

        System.out.println(myRandomList.getRandomElement());
    }
}
