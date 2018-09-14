import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SrbskoUnleashed {
    private static Map<String, LinkedHashMap<String, Long>> allSingers = new LinkedHashMap<>();
    private static Map<String, Long> venues = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        readSingers();
        allSingers.entrySet().stream()
                .forEach(venue ->{
                    System.out.println(venue.getKey());
                    venue.getValue().entrySet().stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(singer -> {
                                System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue());
                            });
                });
    }

    private static void readSingers() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] splittedTot = input.split(" @");
            if (splittedTot.length < 2){
                input = reader.readLine();
                continue;
            }
            String[] splitted = splittedTot[1].split("\\s");
            if (splitted.length < 3){
                input = reader.readLine();
                continue;
            }

            String singerName = splittedTot[0];
            String venueName = getString(splitted);
            long profit = getProfit(splitted);
            if (profit == -1){
                input = reader.readLine();
                continue;
            }
            if (!allSingers.containsKey(venueName)){
                allSingers.put(venueName, new LinkedHashMap<>());
                venues.put(venueName, 0L);
            }
            if (!allSingers.get(venueName).containsKey(singerName)){
                allSingers.get(venueName).put(singerName, 0L);
            }

            allSingers.get(venueName).put(singerName, allSingers.get(venueName).get(singerName) + profit);
            venues.put(venueName, venues.get(venueName) + profit);

            input = reader.readLine();
        }
    }

    private static long getProfit(String[] splitted) {
        try{
            int ticketsPrice = Integer.parseInt(splitted[splitted.length - 2]);
            int ticketsCount = Integer.parseInt(splitted[splitted.length - 1]);
            return (long) (ticketsCount * ticketsPrice);
        } catch (Exception e){
            return -1;
        }

    }

    private static String getString(String[] splitted) {
        String singerName = "";
        for (int i = 0; i < splitted.length - 2; i++) {
            if (i != splitted.length - 3){
                singerName = singerName + splitted[i] + " ";
            } else {
                singerName = singerName + splitted[i];
            }
        }
        return singerName;
    }
}
