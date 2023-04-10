package org.factorymethod.without.model;

import com.google.gson.Gson;

import java.util.Map;

public class JsonModel extends AbstractModel {

    public JsonModel(Map<String, String> data) {
        super(data);
    }

    @Override
    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    @Override
    public String extension() {
        return ".json";
    }
}
