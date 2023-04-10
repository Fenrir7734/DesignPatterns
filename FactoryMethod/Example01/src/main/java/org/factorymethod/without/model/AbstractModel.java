package org.factorymethod.without.model;

import java.nio.file.Path;
import java.util.Map;

public abstract class AbstractModel {
    protected final Map<String, String> data;
    private String path;

    public AbstractModel(Map<String, String> data) {
        this.data = data;
    }

    public abstract String serialize();
    public abstract String extension();

    public void setPath(String path) {
        this.path = path;
    }

    public Path getPath() {
        return Path.of(path).toAbsolutePath();
    }
}
