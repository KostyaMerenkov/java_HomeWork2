package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Phonebook {
    private HashMap<String, List<String>> human;

    public Phonebook() {
        this.human = new HashMap<>();
    }

    public void add(String name, String phone){
        if (human.containsKey(name)) {
            List<String> nums = human.get(name);
            nums.add(phone);
        }
        else {
            human.put(name, new ArrayList<String>(Collections.singleton(phone)) {});
        }


    }
    public void get(String name){
        if (human.containsKey(name)) {

            System.out.println(name + " " + human.get(name));
        }
    }
}
