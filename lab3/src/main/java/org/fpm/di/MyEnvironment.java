package org.fpm.di;

public class MyEnvironment implements Environment {
    @Override
    public Container configure(Configuration configuration) {
        var container = new MyContainer();
        var binder = new MyBinder(container);
        configuration.configure(binder);

        return container;
    }
}
