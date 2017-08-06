package net.geofflittle.congress4j.client;

import com.google.gson.Gson;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.function.Function;

@Log4j2
public class ProPublicaClient {

    public static final String PROPUBLICA_API_KEY_PROPERTY_KEY = "propublica-api-key";

    private static final String X_API_KEY_HEADER_NAME = "X-API-Key";
    private static final String HTTPS_SCHEME = "https";
    private static final String PROPUBLICA_API_HOST = "api.propublica.org";

    private final String proPublicaApiKey;
    private final Gson gson;

    @Inject
    public ProPublicaClient(@Named(PROPUBLICA_API_KEY_PROPERTY_KEY) String proPublicaApiKey, Gson gson) {
        this.proPublicaApiKey = proPublicaApiKey;
        this.gson = gson;
    }

    public <Response> Response call(@NonNull String path, @NonNull Type typeOfResponse) {
        return call(path, reader -> gson.fromJson(reader, typeOfResponse));
    }

    public <Response> Response call(@NonNull String path, @NonNull Class<Response> classOfResponse) {
        return call(path, reader -> gson.fromJson(reader, classOfResponse));
    }

    @SneakyThrows
    private <Response> Response call(String path, Function<Reader, Response> fromJson) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = getRequest(path);
        httpGet.addHeader(X_API_KEY_HEADER_NAME, proPublicaApiKey);
        log.debug("Executing request {}", httpGet);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        InputStream inputStream = httpResponse.getEntity().getContent();
        return fromJson.apply(new InputStreamReader(inputStream));
    }

    private HttpGet getRequest(@NonNull String path) throws URISyntaxException {
        return new HttpGet(new URIBuilder()
                .setScheme(HTTPS_SCHEME)
                .setHost(PROPUBLICA_API_HOST)
                .setPath(path)
                .build());
    }

}
