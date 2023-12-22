package org.fpm.di.example;

import static org.junit.Assert.assertEquals;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.MyBinder;
import org.fpm.di.MyContainer;
import org.fpm.di.MyEnvironment;
import org.fpm.di.example.MyContainerTest.Dep;
import org.junit.Test;

public class MyEnvironmentTest {
    public static class Class1 {
    }

    public static class Class2 extends Class1 {
    }

    public static class Class3 extends Class2 {
    }

    public static class Class4 {
    }
    
    @Test
    public void configureEnvironment() {
        MyContainer container = new MyContainer();
        MyBinder binder = new MyBinder(container);
        MyEnvironment environment = new MyEnvironment();

        Configuration configuration = new Configuration() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Class1.class, Class2.class);
                binder.bind(Class2.class, Class3.class);
                binder.bind(Class3.class);
                binder.bind(Class4.class);
                binder.bind(Dep.class);
            }
        };

        environment.configure(configuration);

        Dep dep = container.getComponent(Dep.class);

        assertEquals(Class3.class, dep.class1.getClass());
        assertEquals(Class4.class, dep.class4.getClass());
    }
}
