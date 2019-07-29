package JediGalaxy.jediGalaxy;

public class Galaxy {
    private int[][] galaxy;

    public Galaxy(int rows, int cols) {
        this.galaxy = new int[rows][cols];
        fillTheGalaxy();
    }

    public int getColLength() {
        return this.galaxy[1].length;
    }

    public int getRowLength() {
        return this.galaxy.length;
    }

    public int getStarValue(int x, int y) {
        return this.galaxy[x][y];
    }

    public void setStarValye(int x, int y) {
        this.galaxy[x][y] = 0;
    }

    private void fillTheGalaxy() {
        int value = 0;
        for (int i = 0; i < this.galaxy.length; i++) {
            for (int j = 0; j < this.galaxy.length; j++) {
                this.galaxy[i][j] = value++;
            }
        }
    }
}
