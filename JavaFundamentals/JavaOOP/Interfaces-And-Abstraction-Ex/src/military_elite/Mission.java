package military_elite;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (state.equals("inProgress") || state.equals("finished")){
            this.state = State.valueOf(state);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public State getState() {
        return this.state;
    }

    public void completeMission() {
        this.state = State.valueOf("finished");
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.codeName, this.state);
    }
}
