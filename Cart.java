
import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<Product> products = new ArrayList();

    List<Integer> quantities = new ArrayList();

    public double totalShipping = 0;
    double subPrice = 0;
    double totalPrice = 0;
    public int itemQuantity;

    public void shippingRate() throws Exception {
        try {
            totalShipping = 0;
            for (Product p : products) {
                if (p.getWeight() > 0) {
                    totalShipping += 10;
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void subTotal(Product product, int quantity) throws Exception {
        try {

            subPrice = 0;
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                int qty = quantities.get(i);
                subPrice += p.getPrice() * qty;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void totalAmount() throws Exception {
        try {
            totalPrice = subPrice + totalShipping;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void add(Product product, int quantity) throws Exception {
        try {
            if (quantity > product.getQuantity()) {
                throw new Exception("Error! " + product.getName() + " out of Stock by " + (quantity - product.getQuantity()));
            }

            if (product instanceof ExpirableProduct) {
                if (((ExpirableProduct) product).isExpired()) {
                    throw new Exception("Item " + product.getName() + " is expired!");
                }
            }


            int existingIndex = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).equals(product)) {
                    existingIndex = i;
                    break;
                }
            }

            if (existingIndex == -1) {
                products.add(product);
                quantities.add(quantity);
            } else {

                int currentQty = quantities.get(existingIndex);
                quantities.set(existingIndex, currentQty + quantity);
            }

            this.itemQuantity = quantity;
            product.setQuantity(product.getQuantity() - quantity);

            this.subTotal(product, quantity);
            shippingRate();
            totalAmount();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public int getQuantityOf(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)) {
                return quantities.get(i);
            }
        }
        return 0;
    }


    public int getTotalItems() {
        int total = 0;
        for (Integer qty : quantities) {
            total += qty;
        }
        return total;
    }
}