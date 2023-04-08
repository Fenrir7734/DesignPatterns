package org.singleton.example01;

public class EagerInitSingleton {
    private static final EagerInitSingleton INSTANCE = new EagerInitSingleton();

    // Some fields

    private EagerInitSingleton() { }

    public static EagerInitSingleton getInstance() {
        return INSTANCE;
    }

    // Some logic
}

