package military_elite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName,
                        double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : this.repairs) {
            sb.append("  ").append(repair.toString()).append(System.lineSeparator());
        }
        return super.toString() + System.lineSeparator() + sb.toString().trim();
    }
}
