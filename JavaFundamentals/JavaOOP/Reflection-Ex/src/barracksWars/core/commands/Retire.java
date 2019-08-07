package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;

public class Retire extends Command {

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            String unitType = super.getData()[1];
            this.repository.removeUnit(unitType);
            return unitType + " retired!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
