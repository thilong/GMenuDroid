package com.aidootk.tktools;

public class Op {

    @SafeVarargs
    public static <T> T getNotNull(T... objs) {
        for (T obj : objs) {
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }


}
