package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private HeroRepository heroRepository;
    private Hero hero;
    private Item item;

    @Before
    public void initialize() {
        this.item = new Item(10, 10, 10);
        this.hero = new Hero("Pesho", 5, this.item);
        this.heroRepository = new HeroRepository();
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestIfDublicatedHeroThrowsException() {
        this.heroRepository.add(this.hero);
        this.heroRepository.add(this.hero);
    }

    @Test(expected = NullPointerException.class)
    public void TestIfRemovingMissingHeroThrowsException() {
        this.heroRepository.remove("Gosho");
    }

    @Test(expected = NullPointerException.class)
    public void TestNoHeroWithHighestStrengthExists() {
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test(expected = NullPointerException.class)
    public void TestNoHeroWithHighestAgilityExists() {
        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test(expected = NullPointerException.class)
    public void TestNoHeroWithHighestIntelligenceExists() {
        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void TestNormalAddingOfHero() {
        this.heroRepository.add(this.hero);
        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test
    public void TestNormalRemovingOfHero() {
        this.heroRepository.add(this.hero);
        this.heroRepository.remove(this.hero.getName());
        Assert.assertEquals(0, this.heroRepository.getCount());
    }

    @Test
    public void ShouldReturnCorrectHighestStrength() {
        this.heroRepository.add(this.hero);
        Item item2 = new Item(9, 9, 9);
        this.heroRepository.add(new Hero("Gosho", 5, item2));
        Assert.assertEquals(this.hero, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test
    public void ShouldReturnCorrectHighestAgility() {
        this.heroRepository.add(this.hero);
        Item item2 = new Item(9, 9, 9);
        this.heroRepository.add(new Hero("Gosho", 5, item2));
        Assert.assertEquals(this.hero, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test
    public void ShouldReturnCorrectHighestIntelligence() {
        this.heroRepository.add(this.hero);
        Item item2 = new Item(9, 9, 9);
        this.heroRepository.add(new Hero("Gosho", 5, item2));
        Assert.assertEquals(this.hero, this.heroRepository.getHeroWithHighestStrength());
    }
}