package com.ahmetsudeys.javalearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Arrays {
    public static void main(String[] args) {
        //Arrays
        String[] myStringArray = new String[3]; //1. dizi tanımlama şekli
        myStringArray[0] = "James";
        myStringArray[1] = "Lars";
        myStringArray[2] = "Kirk";

        int[] myNumberArray = {1, 2, 3, 4, 5}; //2. dizi tanımlama şekli

        //Lists
        ArrayList<String> myMusicians = new ArrayList<>();
        myMusicians.add("kolpa");
        myMusicians.add(0, "zakkum");
        System.out.println(myMusicians.get(0));
        System.out.println(myMusicians.get(1));

        //HashSet
        HashSet<String> myHashSet = new HashSet<>();
        myHashSet.add("James");
        myHashSet.add("James");
        System.out.println(myHashSet.size()); // görüldüğü üzere dizi boyutu 1 olarak gösterildi. Bu HashSet özelliğidir.

        //HashMap (bu çok kullanacağımız bir şey)
        HashMap<String, String> myHashMap = new HashMap<>();
        myHashMap.put("name", "Ali");
        myHashMap.put("instrument", "guitar");
        System.out.println(myHashMap.get("name"));
        System.out.println(myHashMap.get("instrument"));
        /* yani HashMap ile put komutu sayesinde biz birinci elementi ikinci elemente eşleme yapabiliyoruz
        bu sayede de biz ilk element ismi ile ikinci elemente ulaşabiliyoruz
         */

        HashMap<String, Integer> mySeccondHashMap = new HashMap<>();
        mySeccondHashMap.put("run", 100);
        mySeccondHashMap.put("basketball", 200);
        System.out.println(mySeccondHashMap.get("run"));
        System.out.println(mySeccondHashMap.get("basketball")); //örneğin bir fitness uygulamasında koşu kaç kalori sorusuna cevap


    }
}
