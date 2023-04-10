package org.factorymethod.without;

import org.factorymethod.without.model.AbstractModel;
import org.factorymethod.without.model.JsonModel;
import org.factorymethod.without.model.TxtModel;
import org.factorymethod.without.model.XmlModel;
import org.factorymethod.without.model.YamlModel;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class Writer {
    private static final String OUT_DIR = "";
    private static final String FILENAME = "file";

    public AbstractModel write(Map<String, String> data, FileTypes types) throws IOException {
        AbstractModel model = null;

        if (types == FileTypes.JSON || types == null) {
            model = new JsonModel(data);
        } else if (types == FileTypes.YAML) {
            model = new YamlModel(data);
        } else if (types == FileTypes.TXT) {
            model = new TxtModel(data);
        } else if (types == FileTypes.XML) {
            model = new XmlModel(data);
        }

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
