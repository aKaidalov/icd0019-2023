package generics.cart;

import java.util.Objects;

public class CurrentCartItem<T extends CartItem> {

    private String identifier;
    private Double price;
    private Integer quantity = 1;

    public CurrentCartItem(T cartItem) {
        this.identifier = cartItem.getId();
        this.price = cartItem.getPrice();
    }

    public String getCurrentIdentifier() {
        return identifier;
    }

    public Double getCurrentPrice() {
        return price;
    }

    public Integer getCurrentQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    @Override
    public String toString() {
        return String.format("(%s, %1.1f, %d)", this.getCurrentIdentifier(),
                this.getCurrentPrice(), this.getCurrentQuantity());
    }
}
