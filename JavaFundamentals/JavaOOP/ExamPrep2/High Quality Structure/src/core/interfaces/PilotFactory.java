package src.core.interfaces;

import src.entities.interfaces.Pilot;

public interface PilotFactory {
    Pilot createPilot(String name);
}
