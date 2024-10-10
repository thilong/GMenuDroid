package com.aidootk.model;

import com.google.gson.Gson;

public class ModelContext {
    private static volatile ModelContext instance;

    public static ModelContext shared() {
        if (instance == null) {
            synchronized (ModelContext.class) {
                if (instance == null) {
                    instance = new ModelContext();
                }
            }
        }
        return instance;
    }

    private final Gson gsonInstance = new Gson();

    public static String toString(Object obj) {
        return shared().gsonInstance.toJson(obj);
    }

    public static <T> T fromString(String json, Class<T> clazz) {
        return shared().gsonInstance.fromJson(json, clazz);
    }
}
