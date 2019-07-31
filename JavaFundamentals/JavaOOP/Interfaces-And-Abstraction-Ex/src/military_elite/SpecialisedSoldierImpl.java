package military_elite;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName,
                                  double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (corps.equals("Airforces") || corps.equals("Marines")){
            this.corps = Corps.valueOf(corps);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }
}
