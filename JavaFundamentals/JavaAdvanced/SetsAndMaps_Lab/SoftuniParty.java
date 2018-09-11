import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String guest = reader.readLine();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> guests = new TreeSet<>();
        while (!"PARTY".equals(guest)){
            if (Character.isDigit(guest.charAt(0))){
                vipGuests.add(guest);
            } else {
                guests.add(guest);
            }
            guest = reader.readLine();
        }

        guest = reader.readLine();
        while (!"END".equals(guest)){
            if (vipGuests.contains(guest)){
                vipGuests.remove(guest);
            } else {
                guests.remove(guest);
            }
            guest = reader.readLine();
        }
        guests.addAll(vipGuests);
        System.out.println(guests.size());
        for (String missing : guests) {
            System.out.println(missing);
        }
    }
}
