package pl.msulima.training.tests.overmocking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RestUnitTest {

    @Mock
    private Client clientMock;

    private NotifyService notifyService;

    @Before
    public void before() {
        notifyService = new NotifyService(clientMock);
    }

    @Test
    public void badTest() {
        // given
        WebTarget webTargetMock = mock(WebTarget.class);
        Invocation.Builder builderMock = mock(Invocation.Builder.class);
        Invocation invocationMock = mock(Invocation.class);
        when(clientMock.target("http://localhost:28080/items/1/price"))
                .thenReturn(webTargetMock);
        when(webTargetMock.request()).thenReturn(builderMock);
        when(builderMock.accept(MediaType.TEXT_PLAIN)).thenReturn(builderMock);
        when(builderMock.buildPost(any(Entity.class))).thenReturn(invocationMock);

        // when
        notifyService.updatePrice(1, 50);

        // then
        verify(invocationMock).submit();
    }
}
