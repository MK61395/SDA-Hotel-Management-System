package HMS;
import java.util.ArrayList;
import java.util.List;

public class Room {
	private int roomNumber;
    private boolean isBooked;
    private boolean isReserved;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.isReserved = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        isBooked = true;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserveRoom() {
        isReserved = true;
    }

    public void unreserveRoom() {
        isReserved = false;
    }

}
