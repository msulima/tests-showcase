package pl.msulima.training.tests.bestpractices;

public class AddressBuilder {
    private Address address = new Address();

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public Address build() {
        return address;
    }

    public AddressBuilder withCity(String gliwice) {
        address.setCity(gliwice);
        return this;
    }

    public AddressBuilder withStreet(String gliwice) {
        address.setStreet(gliwice);
        return this;
    }

    public AddressBuilder withNumber(int gliwice) {
        address.setNumber(gliwice);
        return this;
    }
}
