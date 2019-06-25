import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIterator {
    private List<String> characters;
    private int internalIndex;

    public ListIterator(String[] data) throws OperationNotSupportedException {
        this.internalIndex = 0;
        this.setCharacters(data);
    }

    public List<String> getCharacters() {
        return characters;
    }

    public int getInternalIndex() {
        return internalIndex;
    }

    public void setCharacters(String[] data) throws OperationNotSupportedException {
        this.characters = new ArrayList<>();
        if (data != null && data.length > 0) {
            this.characters.addAll(Arrays.asList(data));
        } else {
            throw new OperationNotSupportedException();
        }
    }

    public boolean move() {
        if (hasNext()) {
            internalIndex++;
            return true;
        }
        return false;
    }

    public void print() throws OperationNotSupportedException {
        if (this.characters.size() > 0) {
            System.out.println(characters.get(internalIndex));
        } else {
            throw new OperationNotSupportedException("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        return this.internalIndex + 1 < this.characters.size();
    }
}
