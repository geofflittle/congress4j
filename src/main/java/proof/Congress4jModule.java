package proof;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class Congress4jModule extends AbstractModule {

    private static final String CONGRESS4J_PROPERTIES_FILE_NAME = "src/main/resources/congress4j.properties";

    @Override
    @SneakyThrows
    protected void configure() {
        Properties props = new Properties();
        props.load(new FileInputStream(CONGRESS4J_PROPERTIES_FILE_NAME));
        Names.bindProperties(binder(), props);
    }

    @Provides
    @Singleton
    public Gson gson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

}
