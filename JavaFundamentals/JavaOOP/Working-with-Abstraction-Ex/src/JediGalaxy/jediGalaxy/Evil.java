package JediGalaxy.jediGalaxy;

public class Evil {
    private int x;
    private int y;

    public Evil() {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStarterPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void destroyStar(Galaxy galaxy) {
        while (this.getX() >= 0 && this.getY() >= 0) {
            if (isInRange(galaxy, this.getY(), this.getY())) {
                galaxy.setStarValye(this.getX(), this.getY());
            }
            moveEvil();
        }
    }

    private void moveEvil() {
        this.x--;
        this.y--;
    }

    private boolean isInRange(Galaxy galaxy, int y, int y1) {
        return x >= 0 && x < galaxy.getRowLength() && y >= 0 && y < galaxy.getColLength();
    }
}
