package App;

public class Calculations {

    public static int calcDiscount(double price) {
        int discount = 0;

        if (price > 0 && price <= 500) {
            discount = 5;

        } else if (price > 500 && price <= 1000) {
            discount = 10;

        } else if (price > 1000) {
            discount = 15;
        }
        return discount;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static double calcEndPrice(double price, int Discount) {

        return price - (price*Discount)/100;

    }
}
