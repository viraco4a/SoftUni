import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Lab\\FilesAndDirectories_Lab\\resources\\";

        String serializableObjectPatch = resourceFolder + "object.ser";

        //  Create object:
//        FootballPlayer player = new FootballPlayer
//                ("Cristiano Ronaldo", 32, "Real Madrid", 12);

//        try (FileOutputStream fos = new FileOutputStream(serializableObjectPatch);
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(player);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // read object:
        try (FileInputStream fis = new FileInputStream(serializableObjectPatch);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            FootballPlayer player = (FootballPlayer) ois.readObject();
            System.out.println(player);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
