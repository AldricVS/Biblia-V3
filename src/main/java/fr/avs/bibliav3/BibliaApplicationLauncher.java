package fr.avs.bibliav3;

/**
 * Entrypoint for the application. This is needed because else
 * a "could not load Runtime" error type will appear
 *
 * @author Aldric Vitali Silvestre
 */
public class BibliaApplicationLauncher {


    // TODO this should be better ?
    // https://github.com/thomasdarimont/spring-labs/blob/master/spring-boot-javafx/src/main/java/demo/App.java
    public static void main(String[] args) {
        BibliaApplication.main(args);
    }
}
