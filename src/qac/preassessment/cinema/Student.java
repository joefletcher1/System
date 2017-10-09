package qac.preassessment.cinema;

public class Student extends Ticket {

    private String type =  "Student";
    private int price = 6;

    Student() {
        setType(this.type);
        setPrice(this.price);
    }
}
