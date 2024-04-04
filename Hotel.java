package HMS;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private List<Room> rooms;
    private List<Guest> guests;
    private List<FoodItem> menu;
    private List<Order> orders;

    public Hotel(int numRooms) {
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        menu = new ArrayList<>();
        orders = new ArrayList<>();

        // Initialize rooms
        for (int i = 1; i <= numRooms; i++) {
            rooms.add(new Room(i));
        }
    }
    
    public void addMenuItem(int itemId, String itemName, double itemPrice) {
        menu.add(new FoodItem(itemId, itemName, itemPrice));
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    public void placeOrder(int guestId, List<Integer> itemIds) {
        Guest guest = findGuestById(guestId);
        if (guest != null) {
            Order order = new Order(orders.size() + 1);
            for (int itemId : itemIds) {
                FoodItem item = findMenuItemById(itemId);
                if (item != null) {
                    order.addItem(item);
                }
            }
            guest.placeOrder(order);
            orders.add(order);
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Guest not found.");
        }
    }

    public void generateBill(int guestId) {
        Guest guest = findGuestById(guestId);
        if (guest != null) {
            List<Order> guestOrders = guest.getOrders();
            double totalBill = 0;
            for (Order order : guestOrders) {
                totalBill += order.calculateTotalBill();
            }
            System.out.println("Guest " + guestId + "'s Total Bill: $" + totalBill);
        } else {
            System.out.println("Guest not found.");
        }
    }

    public void addRoom() {
        int roomNumber = rooms.size() + 1;
        rooms.add(new Room(roomNumber));
        System.out.println("Room " + roomNumber + " added successfully.");
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked() && !room.isReserved()) {
                System.out.println("Room " + room.getRoomNumber());
            }
        }
    }

    public Guest searchGuest(int guestId) {
        for (Guest guest : guests) {
            if (guest.getGuestId() == guestId) {
                return guest;
            }
        }
        return null;
    }

    public void bookRoom(int roomNumber, int guestId) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null && !room.isBooked() && !room.isReserved()) {
            room.bookRoom();
            guests.add(new Guest(guestId, "Guest " + guestId));
            System.out.println("Room " + roomNumber + " booked successfully for Guest " + guestId);
        } else {
            System.out.println("Room " + roomNumber + " cannot be booked.");
        }
    }

    public void reserveRoom(int roomNumber) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null && !room.isBooked() && !room.isReserved()) {
            room.reserveRoom();
            System.out.println("Room " + roomNumber + " reserved successfully.");
        } else {
            System.out.println("Room " + roomNumber + " cannot be reserved.");
        }
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
    
    private FoodItem findMenuItemById(int itemId) {
        for (FoodItem item : menu) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    private Guest findGuestById(int guestId) {
        for (Guest guest : guests) {
            if (guest.getGuestId() == guestId) {
                return guest;
            }
        }
        return null;
    }
}


