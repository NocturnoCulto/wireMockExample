package pl.umk.allegroworkshop.wireMockIntroduction.outgoing.judoPersonName;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class JudoPersonNameConfiguration {
    private final String url;
    private final String path;
    private final Long connectTimeout;
    private final Long readTimeout;

    public JudoPersonNameConfiguration(@Value("${judoNamePerson.url}") String url,
                                       @Value("${judoNamePerson.path}") String path,
                                       @Value("${judoNamePerson.connect_timeout}") Long connectTimeout,
                                       @Value("${judoNamePerson.read_timeout}") Long readTimeout) {
        this.url = url;
        this.path = path;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }


    @Bean
    public RestTemplate judoPersonNameRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(connectTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }

    public String getUrl() {
        return url;
    }

    public String getPath() {
        return path;
    }

    public Long getConnectTimeout() {
        return connectTimeout;
    }

    public Long getReadTimeout() {
        return readTimeout;
    }
}
