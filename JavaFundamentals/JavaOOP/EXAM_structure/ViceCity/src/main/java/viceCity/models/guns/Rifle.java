package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL_RIFLE = 50;
    private static final int RIFLE_TOTAL_BULLETS = 500;
    private static final int RIFLE_SHOTS_PER_FIRE = 5;
    private static final int ZERO = 0;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL_RIFLE, RIFLE_TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (super.canFire()){
            if (super.getBulletsPerBarrel() == 0) {
                this.reload();
            }
            super.setBulletsPerBarrel(super.getBulletsPerBarrel() - RIFLE_SHOTS_PER_FIRE);
            return RIFLE_SHOTS_PER_FIRE;
        }
        return ZERO;
    }

    protected void reload() {
        int bullets = BULLETS_PER_BARREL_RIFLE;
        this.setTotalBullets(this.getTotalBullets() - bullets);
        this.setBulletsPerBarrel(bullets);
    }
}
