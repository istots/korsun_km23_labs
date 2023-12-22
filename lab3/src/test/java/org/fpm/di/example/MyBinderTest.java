package org.fpm.di.example;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;


import org.fpm.di.MyBinder;
import org.fpm.di.MyContainer;
import org.junit.Test;

public class MyBinderTest {
    public static class Class1 {
    }

    public static class Class2 extends Class1 {
    }

    public static class Class3 extends Class2 {
    }

    public static class Class4 {
    }
     @Test
    public void bindClass() {
        MyContainer container = new MyContainer();
        MyBinder binder = new MyBinder(container);

        binder.bind(Class1.class);

        Class1 result = container.getComponent(Class1.class);

        assertNotNull(result);
    }

    @Test
    public void bindClassWithImplementation() {
        MyContainer container = new MyContainer();
        MyBinder binder = new MyBinder(container);

        binder.bind(Class1.class, Class2.class);

        Class1 result = container.getComponent(Class1.class);

        assertEquals(Class2.class, result.getClass());
    }

    @Test
    public void bindClassWithInstance() {
        MyContainer container = new MyContainer();
        MyBinder binder = new MyBinder(container);

        final Class3 class3Instance = new Class3();
        binder.bind(Class3.class, class3Instance);

        Class3 result = container.getComponent(Class3.class);

        assertSame(class3Instance, result);
    }
}
