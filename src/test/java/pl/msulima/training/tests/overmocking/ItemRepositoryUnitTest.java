package pl.msulima.training.tests.overmocking;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.msulima.training.tests.bestpractices.Item;
import pl.msulima.training.tests.bestpractices.ItemsRepository;
import pl.msulima.training.tests.bestpractices.UserBuilder;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemRepositoryUnitTest {

    @Mock
    private Session session;
    private ItemsRepository itemsRepository;

    @Before
    public void before() {
        itemsRepository = new ItemsRepository(session);
    }

    @Test
    public void shouldApplyDiscount() {
        // given
        ResultSet resultSet = mock(ResultSet.class);
        when(session.execute(any(Statement.class))).thenReturn(resultSet);
        Row row = mock(Row.class);
        when(resultSet.all()).thenReturn(newArrayList(row));
        when(row.getInt(anyString())).thenReturn(0, 123, 0);

        // when
        Collection<Item> items = itemsRepository.findItems(new UserBuilder().anUser().withId(1).build());

        // then
        assertThat(items).extracting("id").containsExactly(123);
    }
}
