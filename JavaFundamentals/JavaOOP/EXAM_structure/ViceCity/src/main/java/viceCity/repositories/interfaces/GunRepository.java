package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GunRepository implements Repository {
    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection getModels() {
        return this.models.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Object model) {
        //TODO gives string??
        Gun gun = (Gun) model;
        if (!this.models.containsKey(gun.getName())) {
            this.models.put(gun.getName(), gun);
        }
    }

    @Override
    public boolean remove(Object model) {
        Gun gun = (Gun) model;
        return this.models.remove(gun.getName(), gun);
    }

    @Override
    public Object find(String name) {
        return this.models.get(name);
    }
}
