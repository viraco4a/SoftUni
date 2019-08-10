package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaceEntryTest {
    private RaceEntry raceEntry;
    private static final UnitMotorcycle UNIT_MOTORCYCLE = new UnitMotorcycle("M1", 10, 10);
    private static final UnitRider UNIT_RIDER = new UnitRider("R1", UNIT_MOTORCYCLE);

    @Before
    public void init() {
        this.raceEntry = new RaceEntry();
    }

    @Test
    public void ConstructorTest() {
        this.raceEntry.addRider(UNIT_RIDER);
        Assert.assertEquals(1, this.raceEntry.getRiders().size());
    }

    @Test(expected = NullPointerException.class)
    public void AddNullRiderEx() {
        this.raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddingAlreadyAddedRiderEx() {
        this.raceEntry.addRider(UNIT_RIDER);
        this.raceEntry.addRider(UNIT_RIDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void StartingRaceWithBelowMinParticipantsEx() {
        this.raceEntry.addRider(UNIT_RIDER);
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void CheckIfAverageHorsePowerIsCorrectlyCalc() {
        this.raceEntry.addRider(UNIT_RIDER);
        UnitMotorcycle motorcycle = new UnitMotorcycle("M1", 20, 20);
        UnitRider rider = new UnitRider("R2", motorcycle);
        this.raceEntry.addRider(rider);
        Assert.assertEquals(15, this.raceEntry.calculateAverageHorsePower(), 0.1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowWhenModifyingReturnedCollection(){
        this.raceEntry.addRider(UNIT_RIDER);
        this.raceEntry.getRiders().remove(UNIT_RIDER);
    }
}
