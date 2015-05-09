package pl.msulima.training.tests.bestpractices;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.msulima.training.tests.bestpractices.UserAssertion.assertUser;

public class BuilderTest {

    @Test
    public void badTest() {
        User user = new User(1, true, "Jan", "Kowalski", new Address("Gliwice", "Akademicka", 16));

        // when
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.isEnabled()).isTrue();
        assertThat(user.getFirstName()).isEqualTo("Jan");
        assertThat(user.getLastName()).isEqualTo("Kowalski");
        assertThat(user.getAddress().getCity()).isEqualTo("Gliwice");
        assertThat(user.getAddress().getStreet()).isEqualTo("Akademicka");
        assertThat(user.getAddress().getNumber()).isEqualTo(16);
    }

    @Test
    public void goodTest() {
        User user = UserBuilder.anUser()
                .withId(1)
                .enabled()
                .withFirstName("Jan")
                .withLastName("Kowalski")
                .livesIn(AddressBuilder.anAddress()
                                .withCity("Gliwice")
                                .withStreet("Akademicka")
                                .withNumber(16).build()
                ).build();

        // when
        assertUser(user)
                .hasId(1)
                .isEnabled()
                .hasFullName("Jan", "Kowalski");
        AddressAssertion.assertAddress(user.getAddress())
                .hasCity("Gliwice")
                .hasStreet("Akademicka")
                .hasNumber(16);
    }

    @Test
    public void badBuilderTest() {
        User user = new User();
        user.setId(1);
        user.setEnabled(true);
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        Address address = new Address();
        address.setCity("Gliwice");
        address.setStreet("Akademicka");
        address.setNumber(16);
        user.setAddress(address);

        // when
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.isEnabled()).isTrue();
        assertThat(user.getFirstName()).isEqualTo("Jan");
        assertThat(user.getLastName()).isEqualTo("Kowalski");
        assertThat(user.getAddress().getCity()).isEqualTo("Gliwice");
        assertThat(user.getAddress().getStreet()).isEqualTo("Akademicka");
        assertThat(user.getAddress().getNumber()).isEqualTo(16);
    }
}
