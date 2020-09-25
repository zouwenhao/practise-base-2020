package cn.zou.test;

import java.util.HashMap;
import java.util.WeakHashMap;

public class Map {
    WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<>();
    HashMap<String, Integer> hashMap = new HashMap<>();
}
