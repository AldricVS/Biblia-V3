package fr.avs.bibliav3.javafx;

import fr.avs.bibliav3.FileResources;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Objects;

/**
 * The preloader class that will set up the splash screen
 * that will be displayed while the application starts up.
 *
 * @author Aldric Vitali Silvestre
 */
public class SplashScreenPreloader extends Preloader {

    private final StackPane root = new StackPane();

    private Stage preloaderStage;

    @Override
    public void init() throws Exception {
        // Create a simple view with one centered image
        Image splashImage = loadSplashImage();

        ImageView imageView = new ImageView(splashImage);

        imageView.setPreserveRatio(true);
        imageView.setFitWidth(computeImageWidth());

        root.getChildren().add(imageView);
    }

    @Override
    public void start(Stage stage) throws Exception {
        preloaderStage = stage;

        Scene scene = new Scene(root, Color.TRANSPARENT);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        stage.setMaximized(true);

        stage.show();
    }

    /**
     * When we got the state "the application has finished initialization",
     * this splash screen can be closed
     */
    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        boolean isApplicationLoadFinished = info.getType().equals(StateChangeNotification.Type.BEFORE_START);
        if (isApplicationLoadFinished) {
            preloaderStage.close();
        }
    }

    private Image loadSplashImage() {
        // Cannot use Spring here, do the old-fashioned way
        URL splashImageURL = getClass().getClassLoader().getResource(FileResources.Images.SPLASH_IMAGE);
        Objects.requireNonNull(splashImageURL, "Could not find splash art file from resources");
        return new Image(splashImageURL.toString());
    }

    private int computeImageWidth() {
        // We will try to do it from the size of the screen
        // Check only for the primary screen, we don't want to over-engineer this
        int screenWidth = Double.valueOf(
            Screen.getPrimary().getVisualBounds().getWidth()
        ).intValue();
        return Math.ceilDiv(screenWidth, 3);
    }
}
