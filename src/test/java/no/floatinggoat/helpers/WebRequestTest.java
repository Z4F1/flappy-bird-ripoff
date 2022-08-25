package no.floatinggoat.helpers;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import no.floatinggoat.game.helpers.WebRequest;

public class WebRequestTest {
    @Test
    public void getRequest() throws IOException, InterruptedException {
        String data = WebRequest.get("https://flappyapi.floatinggoat.no");
        assertEquals("true", data);
    }

    @Test
    public void postRequest() throws IOException, InterruptedException {
        String data = WebRequest.post("https://flappyapi.floatinggoat.no", "{\"test\": true}");
        assertEquals("true", data);
    }
}