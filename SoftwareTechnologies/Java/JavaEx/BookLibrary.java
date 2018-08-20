import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookLibrary {

    public static class Book{
        private String Title;
        private String Author;
        private String Publisher;
        private Calendar ReleaseDate;
        private String ISBNnumber;
        private double Price;

        public Book(String title,
                    String author,
                    String publisher,
                    Calendar releaseDate,
                    String ISBNnumber,
                    double price) {
            Title = title;
            Author = author;
            Publisher = publisher;
            ReleaseDate = releaseDate;
            this.ISBNnumber = ISBNnumber;
            Price = price;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String author) {
            Author = author;
        }

        public String getPublisher() {
            return Publisher;
        }

        public void setPublisher(String publisher) {
            Publisher = publisher;
        }

        public Calendar getReleaseDate() {
            return ReleaseDate;
        }

        public void setReleaseDate(Calendar releaseDate) {
            ReleaseDate = releaseDate;
        }

        public String getISBNnumber() {
            return ISBNnumber;
        }

        public void setISBNnumber(String ISBNnumber) {
            this.ISBNnumber = ISBNnumber;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double price) {
            Price = price;
        }
    }

    public static class Library{
        private String Name;
        public ArrayList<Book> Books;

        public Library(String name, ArrayList<Book> books) {
            Name = name;
            Books = books;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public ArrayList<Book> getBooks() {
            return Books;
        }

        public void setBooks(ArrayList<Book> books) {
            Books = books;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        int n = Integer.parseInt(scanner.nextLine());
        Library library = new Library("private", new ArrayList<>());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s");
            Calendar releaseDate = Calendar.getInstance();
            try {
                releaseDate.setTime(dateFormat.parse(input[3]));
            } catch (ParseException e){
                System.out.println("Try again, invalid date!");
                continue;
            }
            Book currentBook = new Book(
                    input[0],
                    input[1],
                    input[2],
                    releaseDate,
                    input[4],
                    Double.parseDouble(input[5])
            );
            library.getBooks().add(currentBook);
        }
//        original task:
//        PrintByPricePerAuthor(library);

        Calendar givenDate = Calendar.getInstance();
        try {
            givenDate.setTime(dateFormat.parse(scanner.nextLine()));
        } catch (ParseException ignored){}
        PrintAfterGivenDate(library, givenDate, dateFormat);

    }

    private static void PrintAfterGivenDate(Library library,
                                            Calendar givenDate,
                                            SimpleDateFormat dateFormat) {
        HashMap<String, Calendar> titleDate = new HashMap<>();

        for (Book book : library.getBooks()) {
            if (book.getReleaseDate().compareTo(givenDate) > 0){
                titleDate.put(book.getTitle(), book.getReleaseDate());
            }
        }

        //sort by date and by title lexigr
        LinkedHashMap<String, Calendar> sortedTitles = new LinkedHashMap<>();
        titleDate.entrySet().stream()
                .sorted(Map.Entry.<String, Calendar>comparingByKey())
                .sorted(Map.Entry.<String, Calendar>comparingByValue())
                .forEachOrdered(b -> System.out.printf("%s -> %s\n",
                        b.getKey(),
                        dateFormat.format(b.getValue().getTime())));
    }

    private static void PrintByPricePerAuthor(Library library) {
        LinkedHashMap<String, Double> authorPrice = new LinkedHashMap<>();

        for (Book book : library.getBooks()) {
            if (!authorPrice.containsKey(book.getAuthor())){
                authorPrice.put(book.getAuthor(), book.getPrice());
            } else {
                authorPrice.put(book.getAuthor(), book.getPrice() +
                        authorPrice.get(book.getAuthor()));
            }
        }

        // Sorting by Price and then by Author

        LinkedHashMap<String, Double> sortedAutorsByPrice = new LinkedHashMap<>();
        authorPrice.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByKey())
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEachOrdered(x -> sortedAutorsByPrice.put(x.getKey(), x.getValue()));

        for (String author : authorPrice.keySet()) {
            System.out.printf("%s -> %.2f\n", author, authorPrice.get(author));
        }
    }
}
