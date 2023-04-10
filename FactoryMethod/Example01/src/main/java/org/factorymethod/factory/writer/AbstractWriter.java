package org.factorymethod.factory.writer;

import org.factorymethod.factory.model.AbstractModel;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public abstract class AbstractWriter {
    private static final String OUT_DIR = "";
    private static final String FILENAME = "file";

    protected abstract AbstractModel createModel(Map<String, String> data);

    public AbstractModel write(Map<String, String> data) throws IOException {
        AbstractModel model = createModel(data);
        model.setPath(constructPath(model));

        try (FileWriter writer = new FileWriter(model.getPath().toString())) {
            writer.write(model.serialize());
        }

        return model;
    }

    private String constructPath(AbstractModel model) {
        return Path.of(OUT_DIR, FILENAME + model.extension()).toString();
    }
}
