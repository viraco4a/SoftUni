import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scanner.nextLine());
        String[] phrases = {
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can't live without this product."
        };
        String[] events = {
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
        };
        String[] author = { "Diana", "Petya", "Stella", "Elena",
                "Katya", "Iva", "Annie", "Eva"
        };
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rand = new Random();

        for (int i = 0; i < numberOfMessages; i++) {
            int phraseIndex = rand.nextInt(phrases.length);
            int eventIndex = rand.nextInt(events.length);
            int authorIndex = rand.nextInt(author.length);
            int cityIndex = rand.nextInt(cities.length);
            String currentPhrase = phrases[phraseIndex];
            String currentEvent = events[eventIndex];
            String currentAuthor = author[authorIndex];
            String currentCity = cities[cityIndex];
            System.out.printf("%s %s %s - %s\n", currentPhrase, currentEvent,
                    currentAuthor, currentCity);
        }
    }
}
