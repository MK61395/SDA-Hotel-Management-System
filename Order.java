package HMS;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<FoodItem> items;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public double calculateTotalBill() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getItemPrice();
        }
        return total;
    }
}
