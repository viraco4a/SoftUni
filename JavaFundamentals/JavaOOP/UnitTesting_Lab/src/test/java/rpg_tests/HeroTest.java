package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Hero;

public class HeroTest {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int HEALTH = 10;
    private static final int XP = 10;
    private Weapon weapon;
    private Target target;

    @Before
    public void initializeWeaponAndDummy() {
        this.weapon = new Weapon() {
            public int getAttackPoints() {
                return ATTACK;
            }

            public int getDurabilityPoints() {
                return DURABILITY;
            }

            public void attack(Target target) {
                target.giveExperience();
            }
        };

        this.target = new Target() {
            public int getHealth() {
                return HEALTH;
            }

            public void takeAttack(int attackPoints) {

            }

            public int giveExperience() {
                return XP;
            }

            public boolean isDead() {
                return true;
            }
        };
    }

    @Test
    public void heroGainsXP() {
        Hero hero = new Hero("hero", this.weapon);
        hero.attack(this.target);

        Assert.assertEquals(hero.getExperience(), XP);
    }
}
