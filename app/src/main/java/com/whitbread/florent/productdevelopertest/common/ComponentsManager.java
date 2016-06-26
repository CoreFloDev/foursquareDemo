package com.whitbread.florent.productdevelopertest.common;

import com.whitbread.florent.productdevelopertest.common.dagger.ApplicationComponent;
import com.whitbread.florent.productdevelopertest.common.dagger.BaseComponent;

import java.util.HashMap;
import java.util.Map;

public final class ComponentsManager {

    private static final String KEY_APP = "app";

    private final Map<String, ? super BaseComponent> baseComponents;

    private ComponentsManager() {
        baseComponents = new HashMap<>();
    }

    public static ComponentsManager get() {
        return LazyHolder.INSTANCE;
    }

    public <C extends BaseComponent> void removeBaseComponent(String componentKey) {
        baseComponents.remove(componentKey);
    }

    public <C extends BaseComponent> C getBaseComponent(String componentKey) {
        return (C) baseComponents.get(componentKey);
    }

    public <C extends BaseComponent> void putBaseComponent(String componentKey, C component) {
        baseComponents.put(componentKey, component);
    }

    public void removeBaseComponents() {
        baseComponents.clear();
    }

    public ApplicationComponent getAppComponent() {
        return getBaseComponent(KEY_APP);
    }

    public void setAppComponent(ApplicationComponent component) {
        baseComponents.put(KEY_APP, component);
    }

    public boolean containsComponent(String key) {
        return baseComponents.containsKey(key);
    }

    private static class LazyHolder {

        private static final ComponentsManager INSTANCE = new ComponentsManager();
    }
}
