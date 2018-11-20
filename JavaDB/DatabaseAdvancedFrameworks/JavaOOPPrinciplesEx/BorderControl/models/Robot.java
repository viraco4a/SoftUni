package BorderControl.models;

import BorderControl.contracts.Serializable;

public class Robot implements Serializable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
