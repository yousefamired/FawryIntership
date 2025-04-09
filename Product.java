public class Product {

    private String name;
    private double price;
    private int quantity;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    Product(String name, double price , int quantity, int weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }
}
