package collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private int maxSize;
    private List<String> items;

    public Collection() {
        this.maxSize = 100;
        this.items = new ArrayList<>(maxSize);
    }

    protected List<String> getItems() {
        return this.items;
    }
}
