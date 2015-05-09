package pl.msulima.training.tests.overmocking;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.BeforeClass;

public abstract class CassandraTestBase {

    protected Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9142).build();
    protected Session session = cluster.connect("test");

    @BeforeClass
    public static void startCassandra() throws Exception {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9142).build();
        Session session = cluster.connect();
        session.execute("CREATE KEYSPACE test WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor': 3}");
        session.execute("CREATE TABLE test.items (user_id INT, item_id INT, price DECIMAL, PRIMARY KEY(user_id))");
        session.close();
    }
}
