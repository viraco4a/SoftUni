import java.util.HashSet;
import java.util.Set;

public class Category {
    private String name;
    private Set<User> users;
    private Set<Category> children;
    private Category parent;

    public Category(String name) {
        this.setName(name);
        this.users = new HashSet<>();
        this.children = new HashSet<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addChild(Category category) {
        this.children.add(category);
        category.assignParent(this);
    }

    public void assignParent(Category category) {
        this.parent = category;
        category.addChild(this);
    }
}
