package pl.msulima.training.tests.bestpractices;

public class User {
    private int id;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private Address address;

    public User() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public User(int id, boolean enabled, String firstName, String lastName, Address address) {
        this.id = id;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getId() {
        return id;
    }
}
