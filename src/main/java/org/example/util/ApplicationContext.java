package org.example.util;

public class ApplicationContext {
    private static final ApplicationContext applicationContext = new ApplicationContext();

    public ApplicationContext() {
    }
    public static ApplicationContext getInstance() {
        return applicationContext;
    }

}
