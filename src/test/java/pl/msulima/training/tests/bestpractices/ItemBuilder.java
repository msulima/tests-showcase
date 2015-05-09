package pl.msulima.training.tests.bestpractices;

public class ItemBuilder {
    private int userId;
    private int price;
    private int id;

    public ItemBuilder soldByUser(User user) {
        this.userId = user.getId();
        return this;
    }

    public ItemBuilder withPrice(int i) {
        price = i;
        return this;
    }


    public Item build() {
        return new Item(id, userId, price);
    }

    public static ItemBuilder withId(int id) {
        ItemBuilder itemBuilder = new ItemBuilder();
        itemBuilder.id = id;
        return itemBuilder;
    }
}
