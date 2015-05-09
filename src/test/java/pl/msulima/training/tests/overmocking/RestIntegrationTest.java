package pl.msulima.training.tests.overmocking;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.HttpHeaders;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RestIntegrationTest {

    private Client client = ClientBuilder.newClient();

    private NotifyService notifyService = new NotifyService(client);

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(28080);

    @Test
    public void goodTest() {
        // when
        notifyService.updatePrice(1, 50);

        // then
        verify(postRequestedFor(urlEqualTo("/items/1/price"))
                .withRequestBody(equalToJson("{\"price\": 50}"))
                .withHeader(HttpHeaders.ACCEPT, equalTo("text/plain")));
    }
}
