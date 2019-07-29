package JediGalaxy.jediGalaxy;

public class Ivo {
    private long stars;
    private int x;
    private int y;

    public Ivo() {
        this.stars = 0;
        this.x = 0;
        this.y = 0;
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

    public long getStars() {
        return this.stars;
    }

    public void setStarterPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void collectStars(Galaxy galaxy) {
        while (this.getX() >= 0 && this.getY() < galaxy .getColLength()) {
            if (isInRange(galaxy, this.getX(), this.getY())) {
                this.stars += galaxy.getStarValue(this.getX(), this.getY());
            }
            moveIvo();
        }
    }

    private void moveIvo() {
        this.x--;
        this.y++;
    }

    private boolean isInRange(Galaxy galaxy, int x, int y) {
        return x >= 0 && x < galaxy.getRowLength() && y >= 0 && y < galaxy.getColLength();
    }
}
