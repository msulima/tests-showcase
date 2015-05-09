package pl.msulima.training.tests.bestpractices;

public class Item {
    private final int userId;
    private final int id;
    private final int price;

    public Item(int userId, int id, int price) {
        this.userId = userId;
        this.id = id;
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
