package common;

public class OutputMessages {

    public static final String pilotHired = "Pilot %s hired";

    public static final String pilotExists = "Pilot %s is hired already";

    public static final String tankManufactured = "Tank %s manufactured - attack: %.2f; defense: %.2f";

    public static final String fighterManufactured = "Fighter %s manufactured - attack: %.2f; defense: %.2f";

    public static final String machineExists = "Machine %s is manufactured already";

    public static final String machineHasPilotAlready = "Machine %s is already occupied";

    public static final String pilotNotFound = "Pilot %s could not be found";

    public static final String machineNotFound = "Machine %s could not be found";

    public static final String machineEngaged = "Pilot %s engaged machine %s";

    public static final String fighterOperationSuccessful = "Fighter %s toggled aggressive mode";

    public static final String tankOperationSuccessful = "Tank %s toggled defense mode";

    public static final String notSupportedOperation = "Machine %s does not support this operation";

    public static final String attackSuccessful = "Machine %s was attacked by machine %s - current health: %.2f";

    public static final String NULL_MACHINE_NAME =
            "Machine name cannot be null or empty.";

    public static final String NULL_PILOT =
            "Pilot cannot be null.";

    public static final String NULL_PILOT_NAME =
            " Pilot name cannot be null or empty string.";

    public static final String BASE_MACHINE_NULL_TARGET =
            "Attack target cannot be null or empty string.";

    public static final String NULL_MACHINE_ADDED_TO_PILOT =
            "Null machine cannot be added to the pilot.";
}
