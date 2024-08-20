package fr.avs.bibliav3.javafx.pages.hello;

import fr.avs.bibliav3.config.properties.TestProperties;
import fr.avs.bibliav3.javafx.annotations.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class HelloController {

    @Autowired
    private TestProperties testProperties;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(testProperties.helloMessage());
    }
}