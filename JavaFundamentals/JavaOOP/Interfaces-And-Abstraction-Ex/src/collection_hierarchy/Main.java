package collection_hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Addable addCollection = new AddCollection();
        AddRemovable addRemovable = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        List<Integer> addOperationsAddable = new ArrayList<>();
        List<Integer> addOperationsRemovable = new ArrayList<>();
        List<Integer> addOperationsMyList = new ArrayList<>();
        List<String> removeItemsRemovable = new ArrayList<>();
        List<String> removeItemsMyList = new ArrayList<>();

        String[] itemsToAdd = reader.readLine().split("\\s+");
        int removeOperations = Integer.parseInt(reader.readLine());

        for (String item : itemsToAdd) {
            addOperationsAddable.add(addCollection.add(item));
            addOperationsRemovable.add(addRemovable.add(item));
            addOperationsMyList.add(myList.add(item));
        }

        for (int i = 0; i < removeOperations; i++) {
            removeItemsRemovable.add(addRemovable.remove());
            removeItemsMyList.add(myList.remove());
        }

        System.out.println(addOperationsAddable.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(addOperationsRemovable.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(addOperationsMyList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(String.join(" ", removeItemsRemovable));
        System.out.println(String.join(" ", removeItemsMyList));
    }
}
