package com.company;

import java.util.Map;


public class Main {

    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");

        Map<Character, Integer> oneMap = HuffmanFileWrapper.WrapFile(currentDir+"\\The Hunger Games.txt");
        //Map<Character, Integer> oneMap = HuffmanFileWrapper.WrapFile(currentDir + "\\testwithutf8.txt");
        //Map<Character, Integer> oneMap = HuffmanFileWrapper.WrapFile(currentDir+"\\file with frequenciesASCII.txt");
        //Map<Character, Integer> oneMap = HuffmanFileWrapper.WrapFile(currentDir+"\\file with frequenciesUTF8.txt");

        for (Map.Entry entry : oneMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
