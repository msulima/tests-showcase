package pl.msulima.training.tests.overmocking;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class NotifyService {

    private Client client;

    public NotifyService(Client client) {
        this.client = client;
    }

    public void updatePrice(int itemId, int price) {
        WebTarget webTarget = client.target("http://localhost:28080/items/" + itemId + "/price");
        Invocation.Builder accept = webTarget.request().accept(MediaType.TEXT_PLAIN);
        Invocation invocation = accept
                .buildPost(Entity.entity("{\"price\": " + price + "}", MediaType.APPLICATION_JSON_TYPE));
        invocation.submit();
    }
}
