package org.fpm.di;

public class Main {
    public static class Class1 {
        float a;
    }

    public static class Class2 extends Class1 {
        int b;
        @Override
        public String toString() {
            return "Class3 [a=" + a + ", b=" + b + ']';
        }

    }

    public static class Class3 extends Class2 {
        int c;
        int d;

        @Override
        public String toString() {
            return "Class3 [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ']';
        }
    }

    public static class Class4 {
        int ab;

        @Override
        public String toString() {
            return "Class3 [ab =" + ab + ']';
        }
    }

    public static void main(String[] args) {
        //
        Container container = new MyEnvironment().configure(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class3.class);
        });

        Class1 result = container.getComponent(Class2.class);
        System.out.println(result.getClass());

        final Class1 class1Instance = new Class1();
        class1Instance.a = (float) 111.11;

        final Class2 class2Instance = new Class2();
        class2Instance.b = 10;


        final Class3 class3Instance = new Class3();
        class3Instance.c = 101;

        Container container2 = new MyEnvironment().configure(binder -> {
            binder.bind(Class1.class, Class2.class);
            binder.bind(Class2.class, Class3.class);
            binder.bind(Class2.class, class2Instance);
            binder.bind(Class3.class, class3Instance);
        });

        Class2 result2 = container2.getComponent(Class3.class);
        System.out.println(result2);

    }
    
}
