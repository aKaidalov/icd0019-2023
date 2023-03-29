package generics.cart;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T extends CartItem> {

    private ArrayList<CurrentCartItem> cart;
    private Double total;
    private Double discount;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
        this.total = 0d;
        this.discount = 0d;
    }

    public void add(T item) {
        if (item != null && !hasSameElement(item)) {
            cart.add(new CurrentCartItem(item));
        }
    }

    private boolean hasSameElement(T item) {
        if (!cart.isEmpty()) {
            for (CurrentCartItem currentCartItem : cart) {
                if (currentCartItem.getCurrentIdentifier().equals(item.getId()) &&
                        currentCartItem.getCurrentPrice().equals(item.getPrice())) {
                    currentCartItem.increaseQuantity();
                    return true;
                }
            }
        }
        return false;
    }

    public void removeById(String id) {

        List<CurrentCartItem> copiedList = new ArrayList<>();
        copiedList.addAll(cart);

        for (CurrentCartItem currentCartItem : copiedList) {
            if (currentCartItem.getCurrentIdentifier().equals(id)) {
                cart.remove(currentCartItem);
            }
        }
    }

    public Double getTotal() {
        checkIfNeedToCalculate();
        return total;
    }

    public void checkIfNeedToCalculate() {
        if (total == 0d) {
            calculateTotal();
        }
    }

    public void calculateTotal() {
        for (CurrentCartItem currentCartItem : cart) {
            total += currentCartItem.getCurrentPrice() * currentCartItem.getCurrentQuantity();
        }
    }

    public void increaseQuantity(String id) {
        for (CurrentCartItem currentCartItem : cart) {
            if (currentCartItem.getCurrentIdentifier().equals(id)) {
                currentCartItem.increaseQuantity();
            }
        }
    }

    public void applyDiscountPercentage(Double discount) {
        checkIfNeedToCalculate();
        this.discount = discount;
        total *= 1 - (this.discount / 100.0);
    }

    public void removeLastDiscount() {
        checkIfNeedToCalculate();
        total /= 1 - (this.discount / 100.0);
        discount = 0d;
    }

    public void addAll(List<T> items) {
        for (T item : items) {
            CurrentCartItem<T> currentItem = new CurrentCartItem<>(item);
            cart.add(currentItem);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean isFirst = true;

        for (CurrentCartItem currentCartItem : cart) {
            if (isFirst) {
                result.append(currentCartItem.toString());
                isFirst = false;
            } else {
                result.append(", " + currentCartItem.toString());
            }
        }

        return result.toString();
    }
}
