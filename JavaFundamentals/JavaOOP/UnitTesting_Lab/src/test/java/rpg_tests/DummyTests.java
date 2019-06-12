package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {

    @Test
    public void dummyLosesHealthAfterAttack() {
        Axe axe = new Axe(5, 10);
        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);

        Assert.assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyCannotBeAttacked() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyGivesExperience() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);

        Assert.assertEquals(10, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCannotGiveExperience() {
        Axe axe = new Axe(5, 10);
        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);

        dummy.giveExperience();
    }
}
