package fr.avs.bibliav3.javafx;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Base class to inherit in order to properly launch a Spring Boot application
 * that handles a JavaFX application.
 * <p>
 * Implementations should use the {@link SpringJavaFxAbstractApp#launchApp(Class, String[])}
 * method in order to launch the application properly.
 *
 * @author Aldric Vitali Silvestre
 */
public abstract class SpringJavaFxAbstractApp extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringJavaFxAbstractApp.class);

    private static String[] savedArgs;
    protected ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(getClass());
        builder.application().setWebApplicationType(WebApplicationType.NONE);
        applicationContext = builder.run(savedArgs);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        LOGGER.info("Stop Spring application context");
        applicationContext.stop();
    }

    protected static void launchApp(Class<? extends SpringJavaFxAbstractApp> applicationClass, String[] args) {
        SpringJavaFxAbstractApp.savedArgs = args;
        Application.launch(applicationClass, args);
    }
}