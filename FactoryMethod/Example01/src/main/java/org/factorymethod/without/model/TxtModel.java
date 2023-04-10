package org.factorymethod.without.model;

import java.util.Map;

public class TxtModel extends AbstractModel {
    public TxtModel(Map<String, String> data) {
        super(data);
    }

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public String extension() {
        return null;
    }
}
