package fr.avs.bibliav3.javafx.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used for marking Controllers for FXML. Useful for integration with Spring Boot.
 *
 * @author Aldric Vitali Silvestre
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface FXMLController {
}
