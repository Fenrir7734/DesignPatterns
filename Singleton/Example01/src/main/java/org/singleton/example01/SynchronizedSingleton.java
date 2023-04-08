package org.singleton.example01;

public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    // Some fields

    private SynchronizedSingleton() { }

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }

    // Some logic
}

