package military_elite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName,
                        double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        for (Mission mission : this.missions) {
            if (String.valueOf(mission.getState()).equals("inProgress")) {
                sb.append("  ").append(mission.toString()).append(System.lineSeparator());
            }
        }
        return super.toString() + System.lineSeparator() + sb.toString().trim();
    }
}
