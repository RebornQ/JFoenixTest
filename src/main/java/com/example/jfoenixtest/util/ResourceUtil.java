package com.example.jfoenixtest.util;

import java.util.Objects;

public class ResourceUtil {

    private ResourceUtil() {
    }

    public static String getResourceUrl(String path) {
        return Objects.requireNonNull(ResourceUtil.class.getResource(path)).toExternalForm();
    }
}
