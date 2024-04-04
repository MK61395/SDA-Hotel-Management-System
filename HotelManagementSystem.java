package HMS;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(0); // Initialize the hotel with 10 rooms

        while (true) {
            System.out.println("\nHotel Management System Menu:");
            System.out.println("1. Add Room");
            System.out.println("2. Display Available Rooms");
            System.out.println("3. Search Guest");
            System.out.println("4. Book Room");
            System.out.println("5. Reserve Room");
            System.out.println("6. Add Food Item");
            System.out.println("7. Place Food Order");
            System.out.println("8. Generate Bill");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.addRoom();
                    break;
                case 2:
                    hotel.displayAvailableRooms();
                    break;
                case 3:
                    System.out.print("Enter Guest ID to search: ");
                    int guestId = scanner.nextInt();
                    Guest guest = hotel.searchGuest(guestId);
                    if (guest != null) {
                        System.out.println("Guest ID: " + guest.getGuestId() + ", Name: " + guest.getName());
                    } else {
                        System.out.println("Guest not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Room Number to book: ");
                    int roomToBook = scanner.nextInt();
                    System.out.print("Enter Guest ID: ");
                    int guestToBook = scanner.nextInt();
                    hotel.bookRoom(roomToBook, guestToBook);
                    break;
                case 5:
                    System.out.print("Enter Room Number to reserve: ");
                    int roomToReserve = scanner.nextInt();
                    hotel.reserveRoom(roomToReserve);
                    break;
                case 6:
                    System.out.print("Enter Food Item ID: ");
                    int itemId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Food Item Name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter Food Item Price: ");
                    double itemPrice = scanner.nextDouble();
                    hotel.addMenuItem(itemId, itemName, itemPrice);
                    break;
                case 7:
                    System.out.print("Enter Guest ID for Food Order: ");
                    int guestIdForOrder = scanner.nextInt();
                    System.out.println("Menu:");
                    List<FoodItem> menu = hotel.getMenu();
                    for (FoodItem item : menu) {
                        System.out.println("Item ID: " + item.getItemId() + ", Name: " + item.getItemName() + ", Price: $" + item.getItemPrice());
                    }
                    System.out.print("Enter Food Item IDs (comma-separated) for the order: ");
                    String itemIdsInput = scanner.next();
                    String[] itemIdsArray = itemIdsInput.split(",");
                    List<Integer> itemIdsList = new ArrayList<>();
                    for (String itemIdStr : itemIdsArray) {
                        itemIdsList.add(Integer.parseInt(itemIdStr));
                    }
                    hotel.placeOrder(guestIdForOrder, itemIdsList);
                    break;
                case 8:
                    System.out.print("Enter Guest ID to generate the bill: ");
                    int guestIdForBill = scanner.nextInt();
                    hotel.generateBill(guestIdForBill);
                    break;
                case 9:
                    System.out.println("Exiting Hotel Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
