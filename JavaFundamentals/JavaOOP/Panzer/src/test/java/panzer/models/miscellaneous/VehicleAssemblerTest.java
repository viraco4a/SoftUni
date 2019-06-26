package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTest {

    private Assembler vehicleAssembler;

    private AttackModifyingPart attackModifyingPart;

    private DefenseModifyingPart defenseModifyingPart;

    private HitPointsModifyingPart hitPointsModifyingPart;

    @Before
    public void setUp() throws Exception {
        this.vehicleAssembler = new VehicleAssembler();
        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
        this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);
        this.vehicleAssembler.addShellPart(this.defenseModifyingPart);
    }

    @Test
    public void getTotalWeight() {
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.defenseModifyingPart.getWeight()).thenReturn(20.0);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(30.0);

        double actualTotalWeight = this.vehicleAssembler.getTotalWeight();
        double expectedTotalWeight = 60.0;

        Assert.assertEquals(expectedTotalWeight, actualTotalWeight, 0.1);
    }

    @Test
    public void getTotalPrice() {
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(BigDecimal.ZERO);
        Mockito.when(this.defenseModifyingPart.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);

        BigDecimal actualTotalPrice = this.vehicleAssembler.getTotalPrice();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(11);

        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void getTotalPriceWithoutParts() {

        Assembler assembler = new VehicleAssembler();

        BigDecimal actualTotalPrice = assembler.getTotalPrice();
        BigDecimal expectedTotalPrice = BigDecimal.ZERO;

        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void getTotalAttackModification() {
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(50);
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        Mockito.when((attackModifyingPart).getAttackModifier()).thenReturn(120);
        this.vehicleAssembler.addArsenalPart(attackModifyingPart);

        long actualTotalAttackModification = this.vehicleAssembler.getTotalAttackModification();
        long expectedAttackModification = 170;

        Assert.assertEquals(expectedAttackModification, actualTotalAttackModification);
    }

    @Test
    public void getTotalDefenseModification() {
        Mockito.when(this.defenseModifyingPart.getDefenseModifier()).thenReturn(50);
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when((defenseModifyingPart).getDefenseModifier()).thenReturn(120);
        this.vehicleAssembler.addShellPart(defenseModifyingPart);

        long actualTotalDefenseModification = this.vehicleAssembler.getTotalDefenseModification();
        long expectedDefenseModification = 170;

        Assert.assertEquals(expectedDefenseModification, actualTotalDefenseModification);
    }

    @Test
    public void getTotalHitPointModification() {
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(50);
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when((hitPointsModifyingPart).getHitPointsModifier()).thenReturn(120);
        this.vehicleAssembler.addEndurancePart(hitPointsModifyingPart);

        long actualTotalHitPointModification = this.vehicleAssembler.getTotalHitPointModification();
        long expectedTotalHitPointModification = 170;

        Assert.assertEquals(expectedTotalHitPointModification, actualTotalHitPointModification);
    }

    @Test
    public void addArsenalPart() {
        Assembler assembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part1.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        assembler.addArsenalPart(part1);
        assembler.addArsenalPart(part2);

        long actualTotalAttackModification = assembler.getTotalAttackModification();
        long expectedTotalAttackModification = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void addShellPart() {
        Assembler assembler = new VehicleAssembler();
        DefenseModifyingPart part1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part2 = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(part1.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        assembler.addShellPart(part1);
        assembler.addShellPart(part2);

        long actualTotalDefenseModification = assembler.getTotalDefenseModification();
        long expectedTotalDefenseModification = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(actualTotalDefenseModification, expectedTotalDefenseModification);
    }

    @Test
    public void addEndurancePart() {
        Assembler assembler = new VehicleAssembler();
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part2 = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        assembler.addEndurancePart(part1);
        assembler.addEndurancePart(part2);

        long actualTotalHitPointModification = assembler.getTotalHitPointModification();
        long expectedTotalHitPointModification = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(actualTotalHitPointModification, expectedTotalHitPointModification);
    }

    @Test
    public void addArsenalPartSize() {
        Assembler assembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part3 = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part1.getAttackModifier()).thenReturn(10);
        Mockito.when(part2.getAttackModifier()).thenReturn(10);
        Mockito.when(part3.getAttackModifier()).thenReturn(10);

        assembler.addArsenalPart(part1);
        assembler.addArsenalPart(part2);
        assembler.addArsenalPart(part3);

        int actualSize = 0;
        try {
            Field arsenalParts = assembler.getClass().getDeclaredField("arsenalParts");
            arsenalParts.setAccessible(true);
            List<AttackModifyingPart> parts =
                    (List<AttackModifyingPart>) arsenalParts.get(assembler);

            actualSize = parts.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 3;

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addShellPartSize() {
        Assembler assembler = new VehicleAssembler();
        DefenseModifyingPart part1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part2 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part3 = Mockito.mock(DefenseModifyingPart.class);

        assembler.addShellPart(part1);
        assembler.addShellPart(part2);
        assembler.addShellPart(part3);

        int actualSize = 0;
        try {
            Field shellParts = assembler.getClass().getDeclaredField("shellParts");
            shellParts.setAccessible(true);
            List<DefenseModifyingPart> parts =
                    (List<DefenseModifyingPart>) shellParts.get(assembler);

            actualSize = parts.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 3;

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addEndurancePartSize() {
        Assembler assembler = new VehicleAssembler();
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part2 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part3 = Mockito.mock(HitPointsModifyingPart.class);

        assembler.addEndurancePart(part1);
        assembler.addEndurancePart(part2);
        assembler.addEndurancePart(part3);

        int actualSize = 0;
        try {
            Field enduranceParts = assembler.getClass().getDeclaredField("enduranceParts");
            enduranceParts.setAccessible(true);
            List<HitPointsModifyingPart> parts =
                    (List<HitPointsModifyingPart>) enduranceParts.get(assembler);

            actualSize = parts.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 3;

        Assert.assertEquals(expectedSize, actualSize);
    }
}