package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class File extends StreamableObject{
    private String name;

    private int length;

    private int sent;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
