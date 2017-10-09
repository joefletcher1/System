package qac.preassessment.cinema;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Ticket> quote;
    private boolean complete;
    private CDate bookingDate;

    public Booking(CDate date){
        this.quote = new ArrayList<>();
        this.complete = false;
        this.bookingDate = date;
    }

    public void addToBooking(Ticket ticket) {
        quote.add(ticket);
    }

    public void printBooking(){
        int subCost;
        int subTotal = 0;
        int i = 1;

        System.out.println();
        System.out.println("Summary of booking:");
        System.out.format("%5s%15s%6s", "Item", "Type", "Cost");
        System.out.println();

        for (Ticket t : quote){
            subCost = t.getPrice();

            if (bookingDate.getDayName() == "Wednesday"){
                subCost = subCost - 2;
            }

            subTotal += subCost;

            System.out.format("%5s%15s%6d", "(" + (i) + ")", t.getType(), subCost);
            System.out.println();
            i++;
        }
        System.out.println();
        System.out.println("The total for your order is £" + subTotal);
    }

    public Ticket setNewTicket(){
        String s = InputHelper.getInput("Please choose the ticket you require by entering the appropriate number: ");
        Ticket ticket;
        switch (s) {
            case "1":
                ticket = new Standard();
                break;
            case "2":
                ticket = new OAP();
                break;
            case "3":
                ticket = new Student();
                break;
            case "4":
                ticket = new Child();
                break;
            default: {
                ticket = null;
                System.out.println("Sorry, the number you entered did not match. Please try again.");
            }
        }
        return ticket;
    }

    public String getDate() {
        return bookingDate.getDayName() + " " +
                Integer.toString(bookingDate.getDay()) + "/" +
                Integer.toString(bookingDate.getMonth()) + "/" +
                Integer.toString(bookingDate.getYear());
    }

    public boolean getComplete(){
        return complete;
    }

    public void setComplete(boolean b){
        complete = b;
    }
}
