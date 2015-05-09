package pl.msulima.training.tests.bestpractices;

public class UserBuilder {
    private User user = new User();

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder enabled() {
        user.setEnabled(true);
        return this;
    }

    public UserBuilder withId(int id) {
        user.setId(id);
        return this;
    }

    public UserBuilder withFirstName(String name) {
        user.setFirstName(name);
        return this;
    }

    public UserBuilder withLastName(String name) {
        user.setLastName(name);
        return this;
    }

    public UserBuilder livesIn(Address address) {
        user.setAddress(address);
        return this;
    }

    public User build() {
        return user;
    }
}
