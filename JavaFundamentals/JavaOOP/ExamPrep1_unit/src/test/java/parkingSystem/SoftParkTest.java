package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoftParkTest {
    private SoftPark park;
    private Car car;

    @Before
    public void initialize() {
        this.park = new SoftPark();
        this.car = new Car("dd", "1234");

    }

    @Test
    public void testValidImplementationConstructor() {
        int actualParkCount = this.park.getParking().size();

        Assert.assertEquals(12, actualParkCount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testModifyUnmodifiableParkingLot() {
        this.park.getParking().remove("A1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParkCarThrowsExceptionWhenCarSpotNotExist() {
        this.park.parkCar("D1", this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParkCarThrowsExceptionWhenCarSpotTaken() {
        this.park.parkCar("A1", this.car);
        Car car2 = new Car("aa", "4321");
        this.park.parkCar("A1", car2);
    }

    @Test(expected = IllegalStateException.class)
    public void testParkCarThrowsExceptionWhenCarAlreadyParked() {
        this.park.parkCar("A1", this.car);
        this.park.parkCar("A2", this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParkCarThrowsExceptionRemovingWhenCarSpotNotExist() {
        this.park.parkCar("A1", this.car);
        this.park.removeCar("D1", this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParkCarThrowsExceptionCarForThatSpotDoesntExist() {
        this.park.parkCar("A1", this.car);
        Car car2 = new Car("aa", "4321");
        this.park.removeCar("A1", car2);
    }
}