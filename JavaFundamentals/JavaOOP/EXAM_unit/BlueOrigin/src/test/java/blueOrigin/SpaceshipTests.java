package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private static final int SPACESHIP_CAPACITY = 5;
    private static final String SPACESHIP_NAME = "S1";
    private static final String ASTRONAUT_NAME = "A1";
    private static final double OXYGEN_PERCENTAGE = 50;
    private static final Astronaut astronaut = new Astronaut(ASTRONAUT_NAME, OXYGEN_PERCENTAGE);
    private Spaceship spaceship;

    @Before
    public void init() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, SPACESHIP_CAPACITY);
    }

    @Test
    public void TestCorrectAddingOfAstronaut() {
        this.spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowCountGetsHigherThanCapacity() {
        Astronaut astronaut1 = new Astronaut("1", 5);
        Astronaut astronaut2 = new Astronaut("2", 5);
        Astronaut astronaut3 = new Astronaut("3", 5);
        Astronaut astronaut4 = new Astronaut("4", 5);
        Astronaut astronaut5 = new Astronaut("5", 5);
        this.spaceship.add(astronaut);
        this.spaceship.add(astronaut1);
        this.spaceship.add(astronaut2);
        this.spaceship.add(astronaut3);
        this.spaceship.add(astronaut4);
        this.spaceship.add(astronaut5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowAstronautAlreadyExists() {
        this.spaceship.add(astronaut);
        this.spaceship.add(astronaut);
    }

    @Test
    public void IsRemovedCorrectly() {
        this.spaceship.add(astronaut);
        Assert.assertTrue(this.spaceship.remove(astronaut.getName()));
    }

    @Test
    public void IsNotRemovedCorrectly() {
        Assert.assertFalse(this.spaceship.remove(astronaut.getName()));
    }

    @Test
    public void SetCapacityCorrect(){
        Spaceship spaceship1 = new Spaceship("S2", 4);
        Assert.assertEquals(4, spaceship1.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TrowsSetNegativeCapacity(){
        Spaceship spaceship1 = new Spaceship("S2", -2);
    }

    @Test(expected = NullPointerException.class)
    public void TrowsSetNullName(){
        Spaceship spaceship1 = new Spaceship(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void TrowsSetEmptyName(){
        Spaceship spaceship1 = new Spaceship("", 5);
    }
}
