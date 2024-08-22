package com.ahmetsudeys.methodsandclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("on create called");

        testMethod();
        System.out.println(math(7, 3));
        System.out.println(newMethod("Sudeys"));
        username = "ahmet";

        makeMusicians();
        makeSimpsons();

    }

    public void makeMusicians() {
        Musicians muhammet = new Musicians("Mammy", "Guitar", 27);
        System.out.println(muhammet.age);
    }

    public void makeSimpsons() {
        Simpsons homer = new Simpsons("Homer", 50, "Nuclear");
        //homer.age=51; (bu kullanım olamaz çünkü private kullanılmış)
        System.out.println(homer.getName()); // get ve set kullanımı ile yapabiliriz
        homer.setName("Homer Simpson");
        System.out.println(homer.getName());
    }

    public void testMethod() {
        int x = 4 + 4;
        System.out.println("value of x: " + x);
        username = "muhammet";
    }

    public int math(int a, int b) {
        return a + b;
    }

    public String newMethod(String string) {
        return string + " new Method";
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("on pause called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("on start called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("on stop called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("on resume called");
    }
}