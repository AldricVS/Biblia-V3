package fr.avs.bibliav3;

import fr.avs.bibliav3.javafx.SplashScreenPreloader;
import fr.avs.bibliav3.javafx.SpringJavaFxAbstractApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import java.net.URL;

/**
 * @author Aldric Vitali Silvestre
 */
@ComponentScan("fr.avs.bibliav3")
@SpringBootApplication
@ConfigurationPropertiesScan("fr.avs.bibliav3.config.properties")
public class BibliaApplication extends SpringJavaFxAbstractApp {

    @Value("${ui.title:BibliaV3}")
    private String windowTitle;

    @Override
    public void start(Stage stage) throws Exception {
        URL mainFxmlUrl = new ClassPathResource(FileResources.Fxmls.HELLO).getURL();
        FXMLLoader fxmlLoader = new FXMLLoader(mainFxmlUrl);
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // This will launch the splash screen before initializing anything
        System.setProperty("javafx.preloader", SplashScreenPreloader.class.getCanonicalName());
        launchApp(BibliaApplication.class, args);
    }
}
