package org.fpm.di.example;

import org.fpm.di.Configuration;
import org.fpm.di.Container;
import org.fpm.di.MyEnvironment;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class MyContainerTest {
    public static class Class1 {
    }

    public static class Class2 extends Class1 {
    }

    public static class Class3 extends Class2 {
    }

    public static class Class4 {
    }

    public static class Dep {
        public Class1 class1;
        public Class4 class4;

        @Inject
        public Dep(Class1 class1, Class4 class4) {
            this.class1 = class1;
            this.class4 = class4;
        }
    }

    public Container createContainer(Configuration conf) {
        return new MyEnvironment().configure(conf);
    }

    @Test
    public void injectClass3ThroughClass1() {
        Container container = createContainer(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class3.class);
        });

        Class1 result = container.getComponent(Class1.class);
        assertEquals(Class3.class, result.getClass());
    }

    @Test
    public void injectClassThroughClassWithGivenInstance() {
        final Class3 class3Instance = new Class3();
        Container container = createContainer(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class3.class, class3Instance);
        });

        Class2 result = container.getComponent(Class2.class);
        assertSame(result, class3Instance);
    }

    @Test
    public void createDepTest() {
        Container container = createContainer(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class3.class);
            binder.bind(Class4.class);
            binder.bind(Dep.class);
        });

        Dep actual  = container.getComponent(Dep.class);
        assertEquals(Class3.class, actual.class1.getClass());
        assertEquals(Class4.class, actual.class4.getClass());
    }

    @Test
    public void injectSingletonClassThroughClass1() {
        Container container = createContainer(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class3.class);
        });

        Class1 result1 = container.getComponent(Class1.class);
        Class1 result2 = container.getComponent(Class1.class);

        assertSame(result1, result2);
    }

    @Test
    public void injectSingletonClassThroughClassWithGivenInstance() {
        final Class3 class3Instance = new Class3();
        Container container = createContainer(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class3.class, class3Instance);
        });

        Class2 result1 = container.getComponent(Class2.class);
        Class2 result2 = container.getComponent(Class2.class);

        assertSame(result1, class3Instance);
        assertSame(result1, result2);
    }
    
    @Test
    public void injectSingletonClassThroughDependency() {
        Container container = createContainer(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class3.class);
            binder.bind(Class4.class);
            binder.bind(Dep.class);
        });

        Dep dep1 = container.getComponent(Dep.class);
        Dep dep2 = container.getComponent(Dep.class);

        assertSame(dep1.class1, dep2.class1);
        assertSame(dep1.class4, dep2.class4);
    }

    @Test
    public void injectDependencyWithConstructorInjection() {
        Container container = createContainer(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class3.class);
            binder.bind(Class4.class);
            binder.bind(DepWithConstructorInjection.class);
        });

        DepWithConstructorInjection dep = container.getComponent(DepWithConstructorInjection.class);

        assertEquals(Class3.class, dep.class1.getClass());
        assertEquals(Class4.class, dep.class4.getClass());
    }

    public static class DepWithConstructorInjection {
        public Class1 class1;
        public Class4 class4;

        @Inject
        public DepWithConstructorInjection(Class1 class1, Class4 class4) {
            this.class1 = class1;
            this.class4 = class4;
        }
    }
}
