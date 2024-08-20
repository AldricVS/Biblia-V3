package fr.avs.bibliav3;

/**
 * Container class for containing multiple
 * string constants for accessing resources
 *
 * @author Aldric Vitali Silvestre
 */
public class FileResources {

    /**
     * All the images that can be accessed
     */
    public static class Images {

        public static final String ROOT = "images/";

        public static final String SPLASH_IMAGE = ROOT + "splash.png";
    }

    /**
     * All the FXML view files
     */
    public static class Fxmls {

        public static final String ROOT = "fxml/";

        public static final String HELLO = ROOT + "hello-view.fxml";
    }
}
