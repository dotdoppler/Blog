package doppler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by doppler on 2016/5/17.
 */
@Configuration
public class FaviconConfiguration {
    @Bean
public SimpleUrlHandlerMapping faviconHandlerMapping() {
    SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
    mapping.setOrder(Integer.MIN_VALUE);
    mapping.setUrlMap(Collections.singletonMap("favicon.ico",
            faviconRequestHandler()));
    return mapping;
}

        @Bean
        protected ResourceHttpRequestHandler faviconRequestHandler() {
            ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
            requestHandler.setLocations(Arrays
                    .<Resource> asList(new ClassPathResource("/")));
            return requestHandler;
        }
}
