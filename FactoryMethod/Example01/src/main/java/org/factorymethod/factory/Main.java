package org.factorymethod.factory;

import org.factorymethod.factory.model.AbstractModel;
import org.factorymethod.factory.writer.AbstractWriter;
import org.factorymethod.factory.writer.JsonWriter;
import org.factorymethod.factory.writer.YmlWriter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        final Map<String, String> values = Map.of("field1", "value1", "field2", "value2");

        AbstractWriter jsonWriter = new JsonWriter();
        AbstractModel jsonModel = jsonWriter.write(values);
        System.out.println(jsonModel.getPath());

        AbstractWriter yamlWriter = new YmlWriter();
        AbstractModel yamlModel = yamlWriter.write(values);
        System.out.println(yamlModel.getPath());

        Calendar.getInstance();
    }
}
