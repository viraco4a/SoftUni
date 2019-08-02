package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public abstract class StreamableObject {
    private int length;

    private int sent;

    public int getLength() {
        return this.length;
    }

    public int getSent() {
        return this.sent;
    }
}
