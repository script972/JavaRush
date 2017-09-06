package com.javarush.task.task22.task2212;

import java.util.HashMap;
import java.util.Map;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        String tel = telNumber.replaceAll (" ", "");
        if (!tel.matches ("\\+?[0-9]*\\(?[0-9]{3}\\)?[0-9]+-?[0-9]+-?[0-9]+")) return false;
        if ((tel.contains ("(") || tel.contains (")")) && !tel.matches (".*\\(.*\\).*")) return false;
        int n = tel.replaceAll ("\\D", "").length ( );
        if (n != 10 && !(tel.charAt (0) == '+' && n == 12)) return false;
        return true;
    }

    public static void main(String[] args) {
       /* //System.out.println(checkTelNumber("+380501234567"));

        HashMap<String, Boolean> phones = new HashMap<>();
        phones.put("+380501234567", true);
        phones.put("+380501234567", true);
        phones.put("+38(050)1234567", true);
        phones.put("+38050123-45-67", true);
        phones.put("050123-4567", false);
        phones.put("+38)050(1234567", false);
        phones.put("+38(050)1-23-45-6-7", false);
        phones.put("050ххх4567", false);
        phones.put("050123456", false);
        phones.put("(0)501234567", false);

        for (Map.Entry<String, Boolean> pair : phones.entrySet()) {
            if (checkTelNumber(pair.getKey()) != pair.getValue())
                System.out.println("ERROR:Should be:" + pair.getValue() + " checkTelNumber:" + checkTelNumber(pair.getKey()) + " " + pair.getKey());
        }*/

    }
}
