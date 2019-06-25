import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class User {
    private String name;
    private Set<Category> categories;

    public User(String name) {
        this.setName(name);
        this.categories = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void add(Category category) {
        this.categories.add(category);
        category.addUser(this);
    }

    public void remove(Category... categories){
        for (Category category : categories) {
            for (Iterator<Category> i = this.categories.iterator(); i.hasNext();) {
                Category element = i.next();
                if (element.getName().equals(category.getName())) {
                    i.remove();
                }
            }
        }
    }
}
