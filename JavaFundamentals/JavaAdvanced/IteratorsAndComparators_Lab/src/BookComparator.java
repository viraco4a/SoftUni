import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book first, Book second) {
        if (first.getTitle().compareTo(second.getTitle()) == 0) {
            return first.getYear() - second.getYear();
        } else {
            return first.getTitle().compareTo(second.getTitle());
        }
    }
}
