package org.factorymethod.without.model;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class YamlModel extends AbstractModel {

    public YamlModel(Map<String, String> data) {
        super(data);
    }

    @Override
    public String serialize() {
        Yaml yaml = new Yaml();
        return yaml.dumpAsMap(data);
    }

    @Override
    public String extension() {
        return ".yml";
    }
}
