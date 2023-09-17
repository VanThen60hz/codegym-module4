package com.codegym.service;

import java.util.HashMap;
import java.util.Map;

public class DictionaryService {
    static Map<String, String> dictionary = new HashMap<>();


    static {
        dictionary.put("apple", "trái táo");
        dictionary.put("banana", "trái chuối");
        dictionary.put("car", "xe ô tô");
        dictionary.put("duck", "con vịt");
    }

    public String search(String value) {
        return dictionary.get(value);
    }
}
