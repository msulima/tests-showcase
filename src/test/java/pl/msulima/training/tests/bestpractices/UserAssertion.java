package pl.msulima.training.tests.bestpractices;

import static org.assertj.core.api.Assertions.assertThat;

public class UserAssertion {

    private User user;

    public UserAssertion(User user) {
        this.user = user;
    }

    public static UserAssertion assertUser(User user) {
        return new UserAssertion(user);
    }


    public UserAssertion hasId(int i) {
        assertThat(user.getId()).isEqualTo(i);
        return this;
    }

    public UserAssertion isEnabled() {
        assertThat(user.isEnabled()).isTrue();
        return this;
    }

    public UserAssertion hasFullName(String firstName, String lastName) {
        assertThat(user.getFirstName()).isEqualTo(firstName);
        assertThat(user.getLastName()).isEqualTo(lastName);
        return this;
    }
}
