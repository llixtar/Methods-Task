package App;

import java.util.Scanner;

public class DisplayInfo {
    private static final String CURRENCY = "$";
    private static final int IPHONE = 1;
    private static final int MAC_BOOK = 2;
    private static final int AIR_PODS = 3;


    static String[] products = {"iPhone", "MacBook", "AirPods"};
    static String[] iPhones = {"iPhone SE", "iPhone 13", "iPhone 14", "iPhone 14 Plus", "iPhone 15",
            "iPhone 15 Plus", "iPhone 15 Pro", "iPhone 15 Pro Max"};
    static String[] macBooks = {"MacBook Air 13'", "MacBook Air 15'", "MacBook Pro 14'", "MacBook Pro 16'"};
    static String[] airPods = {"AirPods 2 gen.", "AirPods 3 gen.", "AirPods Pro 2 gen.", "AirPods Max"};

    static double[] iPhonePrices = {429, 599, 699, 799, 799, 899, 999, 1199};
    static double[] airPodsPrices = {129, 169, 249, 549};
    static double[] macBookPrices = {1099, 1299, 1599, 2499};
    static int numTypeProd;//

    static Scanner sc = new Scanner(System.in);

    //----------------------------------------------------------------------------------------------------------------------
    public static void outInfo() {

        showCategory();

        String dataIn = sc.nextLine().trim();
        numTypeProd = whatType(dataIn);

        switch (numTypeProd) {
            case IPHONE:
                showProducts(iPhonePrices, iPhones);
                showEndPrice(iPhonePrices, iPhones);
                break;
            case MAC_BOOK:
                showProducts(macBookPrices, macBooks);
                showEndPrice(macBookPrices, macBooks);
                break;
            case AIR_PODS:
                showProducts(airPodsPrices, airPods);
                showEndPrice(airPodsPrices, airPods);
                break;
            default:
                System.out.println("x_x");
                outInfo();
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    public static int whatType(String nameProd) {
        int num = 0;
        try {
            num = Integer.parseInt(nameProd);

        } catch (NumberFormatException e) {

            switch (nameProd) {
                case "iPhone":
                    num = IPHONE;
                    break;
                case "MacBook":
                    num = MAC_BOOK;
                    break;
                case "AirPods":
                    num = AIR_PODS;
                    break;

            }
        }
        return num;
    }

    //----------------------------------------------------------------------------------------------------------------------
    public static void showProducts(double[] prices, String[] names) {
        int cnt = names.length;
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%d)%s, Price: %.2f%s%n", i + 1, names[i], prices[i], CURRENCY);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void showEndPrice(double[] prices, String[] names) {
        System.out.println("\nChoose a model(Enter ONLY number):");

        String dataIn = sc.nextLine().trim();
        int num = Integer.parseInt(dataIn);

        if (num > 0 && num <= prices.length) {

            int disc = Calculations.calcDiscount(prices[num - 1]);
            double endPrice = Calculations.calcEndPrice(prices[num - 1], disc);

            System.out.printf("%n------------------------------%n" +
                            "%s:%nPrice: %.2f%s;%nDiscount: %d%%;%nEnd price: %.2f%s;" +
                            "%n------------------------------%n",
                    names[num - 1], prices[num - 1], CURRENCY, disc, endPrice, CURRENCY);
        } else
            System.out.println("x_x");

        outInfo();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void showCategory() {

        int cntProd;
        cntProd = products.length;
        for (int i = 0; i < cntProd; i++) {

            if (i == 0) {
                System.out.printf("%nProduct category:%n%d)%s", i + 1, products[i]);
            } else if (i < (cntProd - 1)) {
                System.out.printf("%n%d)%s", i + 1, products[i]);
            } else System.out.printf("%n%d)%s%n%nEnter the product name or number:", i + 1, products[i]);
        }

    }
}
