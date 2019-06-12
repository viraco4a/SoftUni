package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeAxe() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void weaponAttacksLosesDurability() {
        axe.attack(dummy);

        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        axe.attack(dummy);
        axe.attack(dummy);
    }
}
