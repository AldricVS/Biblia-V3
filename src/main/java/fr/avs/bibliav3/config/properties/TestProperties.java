package fr.avs.bibliav3.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Aldric Vitali Silvestre
 */
@ConfigurationProperties("test")
public record TestProperties(
    String helloMessage
) {
}
