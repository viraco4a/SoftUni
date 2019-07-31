package military_elite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName,
                                 double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public List<Private> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Privates:").append(System.lineSeparator());
        for (Private aPrivate : this.privates.stream()
                .sorted((a, b) -> b.getId() - a.getId())
                .collect(Collectors.toList())) {
            sb.append("  ").append(aPrivate.toString()).append(System.lineSeparator());
        }
        return super.toString() + System.lineSeparator() + sb.toString().trim();
    }
}
