package com.company;

import java.util.Map;


public class Main {

    public static void main(String[] args) {

        //Map<Character, Integer> oneMap = HuffmanFileWrapper.WrapFile("C:\\Users\\Davydov\\Documents\\file with frequenciesUTF8.txt");
        //Map<Character, Integer> oneMap = HuffmanFileWrapper.WrapFile("C:\\Users\\Davydov\\Documents\\file with frequenciesASCII.txt");
        //Map<Character, Integer> oneMap = HuffmanFileWrapper.WrapFile("C:\\Users\\Davydov\\Documents\\The Hunger Games.txt");
        Map<Character, Integer> oneMap = HuffmanFileWrapper.WrapFile("C:\\Users\\Davydov\\Documents\\testwithutf8.txt");

        for (Map.Entry entry : oneMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
