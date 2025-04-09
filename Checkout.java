public class Checkout {

    public void printReceipt(Cart cart,Customer customer) throws Exception {
        try {
            System.out.println("** Checkout receipt **");
            for (Product item : cart.products) {
                System.out.println( item.getName() + " " + (int) item.getPrice());
            }
            System.out.println("----------------------");
            System.out.println("Subtotal " + cart.subPrice);
            System.out.println("Shipping " + cart.totalShipping);
            System.out.println("Amount " + cart.totalPrice);


            if (customer.balance > cart.totalPrice){
                System.out.println("Remaining balance is " + (customer.balance - cart.totalPrice));
            }
            else {
                throw new Exception("Insufficient balance!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}