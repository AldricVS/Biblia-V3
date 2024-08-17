package fr.avs.bibliav3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.net.URL;

@ComponentScan("fr.avs.bibliav3")
@SpringBootApplication
@ConfigurationPropertiesScan("fr.avs.bibliav3.config.properties")
public class BibliaApplication extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BibliaApplication.class);
    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        // Init and launch as Spring boot application that before launching the JavaFX GUI
        LOGGER.info("Launch Spring Boot application before JavaFX");
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BibliaApplication.class);
        builder.application().setWebApplicationType(WebApplicationType.NONE);
        applicationContext = builder.run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) throws IOException {
        URL mainFxmlUrl = applicationContext.getResource("fxml/hello-view.fxml").getURL();
        FXMLLoader fxmlLoader = new FXMLLoader(mainFxmlUrl);
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Biblia V3");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}