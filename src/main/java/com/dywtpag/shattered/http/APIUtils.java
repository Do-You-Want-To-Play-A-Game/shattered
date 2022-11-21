package com.dywtpag.shattered.http;

import java.io.InputStream;
import java.net.URI;
import java.net.http.*;

public class APIUtils {

    private final HttpClient client;
    private final String source;

    public APIUtils(String source) {
        this.client = HttpClient.newHttpClient();
        this.source = source;
    }

    public HttpResponse<InputStream> sendRequest(String... headers) throws Exception {
        HttpRequest req = HttpRequest.newBuilder(new URI(this.source)).headers(headers).build();
        return client.send(req, HttpResponse.BodyHandlers.ofInputStream());
    }
}
