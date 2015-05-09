package pl.msulima.training.tests.bestpractices;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.util.Collection;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.select;
import static java.util.stream.Collectors.toList;

public class ItemsRepository {
    private Session session;

    public ItemsRepository(Session session) {
        this.session = session;
    }

    public Collection<Item> findItems(User user) {
        ResultSet execute = session.execute(select().from("items").where(eq("user_id", user.getId())));
        return execute.all().stream().map(this::rowToObject).collect(toList());
    }

    private Item rowToObject(Row row) {
        return new Item(row.getInt("user_id"), row.getInt("item_id"), row.getInt("price"));
    }
}
