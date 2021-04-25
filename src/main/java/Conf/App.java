package Conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;

public class App {
    @Configuration

    public static class App implements ConfigWeb {

        public void addController(ViewControllerRegistration registration){
            registration.addController("/login").setViewName("login");
            registration.addController("/news").setViewName("news");
         }

    }

}
