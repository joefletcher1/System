package qac.preassessment.cinema;

public abstract class Ticket {
    private String type;
    private int price;

    public Ticket() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
