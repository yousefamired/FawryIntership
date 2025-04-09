import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
       Customer customer = new Customer(100000);
        Product tv = new Product("LG",10000, 10, 5000);
        Product cheese = new ExpirableProduct("Cheddar", 250, 10,1000, LocalDate.of(2026,6,1));
        Product biscuits = new ExpirableProduct("Oreo", 10, 10,200, LocalDate.of(2027,6,1));
        Product mobile = new Product("Samsung",5000, 10, 1200);
        Product scratchCard = new Product("Scratch Card",10, 10, 0);

        Cart cart = new Cart();

       cart.add(cheese,2);
        cart.add(tv,2);
        cart.add(scratchCard,1);
        cart.add(mobile,1);
        cart.add(biscuits,1);

        Checkout checkout = new Checkout();

     checkout.printReceipt(cart, customer);
     System.out.println(cart.subPrice);
     System.out.println(cart.totalPrice);


    }
}