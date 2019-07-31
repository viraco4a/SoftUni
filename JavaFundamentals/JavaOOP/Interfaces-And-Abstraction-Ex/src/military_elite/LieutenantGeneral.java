package military_elite;

import java.util.List;

public interface LieutenantGeneral extends Private {
    List<Private> getPrivates();
    void addPrivate(Private priv);
}