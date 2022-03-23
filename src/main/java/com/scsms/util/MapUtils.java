package com.scsms.util;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MapUtils {

    public static boolean hasNullVal(Map<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getValue() == null || entry.getValue().equals("")) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> getNullKey(Map<String, String> map) {
        ArrayList<String> list = new ArrayList<>();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getValue() == null || entry.getValue().equals("")) {
                list.add(entry.getKey());
            }
        }

        return list;
    }

}
