package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL_PISTOL = 10;
    private static final int PISTOL_TOTAL_BULLETS = 100;
    private static final int PISTOL_SHOTS_PER_FIRE = 1;
    private static final int ZERO = 0;

    protected Pistol(String name) {
        super(name, BULLETS_PER_BARREL_PISTOL, PISTOL_TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (super.canFire()){
            if (super.getBulletsPerBarrel() == 0) {
                super.reload();
            }
            super.setBulletsPerBarrel(super.getBulletsPerBarrel() - PISTOL_SHOTS_PER_FIRE);
            return PISTOL_SHOTS_PER_FIRE;
        }
        return ZERO;
    }
}
