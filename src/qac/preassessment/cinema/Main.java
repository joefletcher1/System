package qac.preassessment.cinema;

public class Main {

    public static void main(String[] args) {

        CDate date = new CDate();
        Ticket ticket;

        System.out.println("Welcome to QA Cinemas new automated booking system");
        System.out.println();
        System.out.println("To use this system please type the appropriate characters followed by Enter.");
        System.out.println();
        System.out.println("***Wednesday discount of £2 per ticket available***");

        while(!date.chosen()) {
            while(!date.getFormat()) {
                date.enterDate(InputHelper.getInput("Please enter the date you wish to visit QA Cinemas (dd/mm/yyyy): "));
            }
            date.checkDateSelected();
        }

        Price p = new Price();
        p.displayPrices(date.getDayName());

        Booking newBooking = new Booking(date);

        while(!newBooking.getComplete()) {

            ticket = newBooking.setNewTicket();

            if (ticket != null) {
                System.out.println("You have selected: " + ticket.getType());
                System.out.println();

                newBooking.addToBooking(ticket);
            }

            String s = InputHelper.getInput("Enter N to add a new ticket, C to continue with selected tickets or any other key to exit booking: ");
            System.out.println();

            if (s.toUpperCase().equals("N")) {
                newBooking.setComplete(false);
            }
            else if (s.toUpperCase().equals("C")) {

                newBooking.printBooking();
                System.out.println();

                s = InputHelper.getInput("Enter B to book these tickets or any other key to start a new booking: ");

                if (s.toUpperCase().equals("B")) {
                    newBooking.setComplete(true);

                    System.out.println();
                    System.out.println("Thank you for using our new automated booking service. See you on " + newBooking.getDate() + ".");
                }
            }
            else {
                System.out.println("You have chosen to cancel the booking.");
                return;
            }
        }
    }
}
