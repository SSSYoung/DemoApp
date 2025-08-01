package com.example.demoapp;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author: qj
 * @date: 2023-4-23
 * @description GSon转换类
 */
public class GsonUtil {
    private static final Gson mGson = new Gson();

    public GsonUtil() {
    }

    public static String toJson(Object entity) {
        return mGson.toJson(entity);
    }

    public static <T> T fromJson(String jsonStr, Class<T> clz) {
        return mGson.fromJson(jsonStr, clz);
    }

    public static Type getListType(final Type type) {
        return TypeToken.getParameterized(List.class, type).getType();
    }

    public static <T> T fromJson(JsonElement jsonElement, Type typeOfT) {
        return mGson.fromJson(jsonElement, typeOfT);
    }


    public static <T> T fromJson(String jsonStr, Type typeOfT) {
        return mGson.fromJson(jsonStr, typeOfT);
    }

    public static <T> T fromStrJson(String jsonElement, Type typeOfT) {
        return mGson.fromJson(jsonElement, typeOfT);

    }
}
