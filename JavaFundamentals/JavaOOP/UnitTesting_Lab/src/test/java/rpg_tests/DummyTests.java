package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int HEALTH = 15;
    private static final int EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeAxe() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthAfterAttack() {
        this.axe.attack(this.dummy);

        Assert.assertEquals("Wrong dummy health",5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyCannotBeAttacked() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void deadDummyGivesExperience() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);

        Assert.assertEquals(10, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCannotGiveExperience() {
        this.axe.attack(this.dummy);

        dummy.giveExperience();
    }
}
