package net.geofflittle.congress4j.client;

import lombok.NonNull;

import javax.inject.Inject;
import java.util.function.Function;

public class ProPublicaApiFactory {

    private final ProPublicaClient proPublicaClient;

    @Inject
    public ProPublicaApiFactory(ProPublicaClient proPublicaClient) {
        this.proPublicaClient = proPublicaClient;
    }

    public <Request, Response> Function<Request, Response> get(@NonNull Function<Request, String> pathFormatter,
            @NonNull Class<Response> responseClass) {
        return request -> proPublicaClient.call(pathFormatter.apply(request), responseClass);
    }

}
