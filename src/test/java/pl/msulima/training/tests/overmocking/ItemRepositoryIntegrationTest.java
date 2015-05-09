package pl.msulima.training.tests.overmocking;

import org.junit.Test;
import pl.msulima.training.tests.bestpractices.Item;
import pl.msulima.training.tests.bestpractices.ItemsRepository;
import pl.msulima.training.tests.bestpractices.UserBuilder;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemRepositoryIntegrationTest extends CassandraTestBase {

    private ItemsRepository itemsRepository = new ItemsRepository(session);

    @Test
    public void shouldApplyDiscount() {
        // given
        session.execute("insert into items(user_id, item_id, price) values (1, 123, 0)");
        session.execute("insert into items(user_id, item_id, price) values (1, 124, 0)");
        session.execute("insert into items(user_id, item_id, price) values (2, 777, 0)");

        // when
        Collection<Item> items = itemsRepository.findItems(UserBuilder.anUser().withId(1).build());

        // then
        assertThat(items).extracting("id").containsExactly(123, 124);
    }
}
