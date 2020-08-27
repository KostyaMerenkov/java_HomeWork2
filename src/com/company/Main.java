package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //1
        String words[] = new String[] {
                "Январь",
                "Май",
                "Январь",
                "Март",
                "Август",
                "Декабрь",
                "Январь",
                "Февраль",
                "Март",
                "Апрель",
                "Май",
                "Июнь",
                "Июль",
                "Август",
                "Сентябрь",
                "Октябрь",
                "Ноябрь",
                "Декабрь"
        };
        uniqWirds(words);
        System.out.println();
        //2
        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров", "+79241204826");
        phonebook.add("Иванов", "+79034328492");
        phonebook.add("Александров", "+79840239478");
        phonebook.add("Александров", "+79007654189");
        phonebook.add("Петров", "+79236453252");
        phonebook.add("Титов", "+7942643829");
        phonebook.add("Александров", "+7965248373");
        phonebook.get("Петров");
        phonebook.get("Иванов");
        phonebook.get("Александров");
        phonebook.get("Титов");


    }

    public static void uniqWirds(String arr[]) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer value = map.getOrDefault(arr[i],0);
            map.put(arr[i], value+1);
        }
        System.out.println(map);
    }
}
