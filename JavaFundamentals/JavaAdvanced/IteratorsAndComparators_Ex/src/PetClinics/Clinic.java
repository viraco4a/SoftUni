package PetClinics;

public class Clinic {
    private String name;
    private int nextRoomIndex;
    private int petsCount;
    private Pet[] rooms;

    public Clinic(String name, int capacity) {
        this.name = name;
        this.setRooms(capacity);
        this.petsCount = 0;
        this.nextRoomIndex = capacity / 2;
    }

    public void setRooms(int capacity) {
        if (capacity % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Pet[capacity];
    }

    public boolean addPet(Pet pet) {
        if (!this.hasEmptyRooms()) {
            return false;
        }
        this.rooms[this.nextRoomIndex] = pet;
        this.petsCount++;
        this.incrementRoomIndex();
        return true;
    }

    private void incrementRoomIndex() {
        int mid = this.rooms.length / 2;
        int diff = (this.petsCount + 1) / 2;
        this.nextRoomIndex = this.nextRoomIndex < mid ? mid + diff : mid - diff;
    }

    public boolean hasEmptyRooms() {
        return this.petsCount < this.rooms.length;
    }

    public boolean releasePet() {
        int index = this.rooms.length / 2;
        for (int i = index; i < this.rooms.length; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                this.petsCount--;
                return true;
            }
        }
        for (int i = 0; i < index; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                this.petsCount--;
                return true;
            }
        }
        return false;
    }

    public String getPet(int petIndex) {
        return this.rooms[--petIndex] == null ? "Room empty" : this.rooms[petIndex].toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pet pet : this.rooms) {
            sb.append(pet == null ? "Room empty" : pet.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
