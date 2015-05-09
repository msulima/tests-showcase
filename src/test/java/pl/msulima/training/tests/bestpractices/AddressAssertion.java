package pl.msulima.training.tests.bestpractices;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressAssertion {

    private Address address;

    public AddressAssertion(Address address) {
        this.address = address;
    }

    public static AddressAssertion assertAddress(Address address) {
        return new AddressAssertion(address);
    }


    public AddressAssertion hasCity(String i) {
        assertThat(address.getCity()).isEqualTo(i);
        return this;
    }

    public AddressAssertion hasStreet(String i) {
        assertThat(address.getStreet()).isEqualTo(i);
        return this;
    }

    public AddressAssertion hasNumber(int number) {
        assertThat(address.getNumber()).isEqualTo(number);
        return this;
    }
}
