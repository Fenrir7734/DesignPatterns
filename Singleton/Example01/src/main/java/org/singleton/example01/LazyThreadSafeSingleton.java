package org.singleton.example01;

public class LazyThreadSafeSingleton {
    private LazyThreadSafeSingleton() { }

    public static LazyThreadSafeSingleton getInstance() {
        return LazyThreadSafeSingletonHolder.INSTANCE;
    }

    private static class LazyThreadSafeSingletonHolder {
        private static final LazyThreadSafeSingleton INSTANCE = new LazyThreadSafeSingleton();
    }
}

