package HMS;
import java.util.ArrayList;
import java.util.List;

public class Guest {
	private int guestId;
    private String name;
    private List<Order> orders;

    public Guest(int guestId, String name) {
        this.guestId = guestId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public int getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

}
