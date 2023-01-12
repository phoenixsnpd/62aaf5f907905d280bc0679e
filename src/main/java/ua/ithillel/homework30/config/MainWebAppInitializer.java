package ua.ithillel.homework30.config;

import jakarta.servlet.ServletContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
        var rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);

        container.addListener(new ContextLoaderListener(rootContext));

        var dispatcher = container.addServlet("MyFirstDispatcherServlet", new DispatcherServlet(rootContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
