package com.ahmetsudeys.javalearning;

public class Operators {
    public static void main(String[] args) {
        //diğer operatörler zaten bilindiği için aşağıya not düşülmemiştir

        //Switch
        int day = 1;
        String dayString;

        switch (day) {
            case 1:
                dayString = "Monday";
                break;
            case 2:
                dayString = "Tuesday";
                break;
            case 3:
                dayString = "Wednesday";
                break;
            default:
                dayString = "Sunday";
                break;
            /*
            switch ile önce bir değişken belirliyoruz ve bu değişkeni case- break yapısı ile kontrol edip
            en son ise default ile hiçbir şey olmazsa gerçekleşecek seneryoyu belirtmiş oluyoruz.
            */

        }
        System.out.println(dayString);
    }
}
