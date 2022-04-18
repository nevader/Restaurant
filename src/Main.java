import Costumer.PlaceOrder;

public class Main {

    public static void main(String[] args) {

        PlaceOrder placeOrder1 = new PlaceOrder(false, "cipka");
        PlaceOrder placeOrder2 = new PlaceOrder(false, "cipka");
        PlaceOrder placeOrder3 = new PlaceOrder(false, "cipka");
        PlaceOrder placeOrder4 = new PlaceOrder(false, "cipka");


        System.out.println(placeOrder1.getOrderID());
        System.out.println(placeOrder2.getOrderID());
        System.out.println(placeOrder3.getOrderID());
        System.out.println(placeOrder4.getOrderID());

        System.out.println(placeOrder1.getDate());
        System.out.println(placeOrder2.getDate());
        System.out.println(placeOrder3.getDate());
        System.out.println(placeOrder4.getDate());





    }

}
