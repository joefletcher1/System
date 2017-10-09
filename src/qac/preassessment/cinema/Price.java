package qac.preassessment.cinema;

import java.util.HashMap;

public class Price {
    private String[] categories = {"Standard","OAP","Student","Child"};
    private HashMap<String, Integer> priceList = new HashMap<>();

    Price(){
        priceList.put(categories[0], 8);
        priceList.put(categories[1], 6);
        priceList.put(categories[2], 6);
        priceList.put(categories[3], 4);
    }

    public void displayPrices(String day) {

        System.out.println();
        System.out.println("Here is a summary of our prices for " + day + "s :");
        System.out.println();

        if (day.equals("Wednesday")) {
            for (int i = 0; i < categories.length; i++) {
                String key = categories[i];
                int value = Integer.parseInt(priceList.get(key).toString()) - 2;
                System.out.println("[" + (i + 1) + "] " + key + " " + value);
            }
        } else {
            for (int i = 0; i < categories.length; i++) {
                String key = categories[i];
                String value = priceList.get(key).toString();
                System.out.println("[" + (i + 1) + "] " + key + " " + value);
            }
        }
        System.out.println();
    }

}
