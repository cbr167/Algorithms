package com.example.bhagy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private int[] theArray = new int[50];
    private int arrySize = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Runner runner = new Runner();
        runner.start();
        Runner2 runner2 = new Runner2();
        runner2.start();*/
        generateRandomArray();
        Log.d("theArray", Arrays.toString(theArray));
        Log.d("theArray Index value: ", String.valueOf(getValueAtIndex(3)));
        Log.d("theArray boolean: ", String.valueOf(doesArrayContainThisVal(993)));
        deleteIndex(8);
        insertValue(21);
        Log.d("theArray delete: ", Arrays.toString(theArray));
        Log.d("theArray insert: ", Arrays.toString(theArray));
        Log.d("theArray linearSearch: ", linearSearch(2));
        //recursive practice
        /*printNumb(5);
        System.out.println("catEyes" + catEyes(5));*/


    }

    //Alogorithms
    public void generateRandomArray() {
        for (int i = 0; i < arrySize; i++) {
            theArray[i] = (int) (Math.random() * 10) + 10;
        }

    }

    public int getValueAtIndex(int index) {

        if (index < arrySize) {
            return theArray[index];
        } else {
            return 0;
        }
    }
/*
* Linear Search
* */
    public String linearSearch(int value) {
        boolean isValueInArra = false;
        String indexWithVal = "";
        for (int i = 0; i < arrySize; i++) {
            if (theArray[i] == value) {
                isValueInArra = true;
                indexWithVal = i + " ";
            }
        }
        if (!isValueInArra) {
            indexWithVal = "None";
        }
        return indexWithVal;
    }

    public boolean doesArrayContainThisVal(int value) {
        boolean valInArr = false;
        for (int i : theArray) {
            valInArr = i == value;
        }
        return valInArr;
    }

    public void deleteIndex(int index) {
        if (index < arrySize) {
            for (int i = index; i < (arrySize - 1); i++) {
                theArray[i] = theArray[i + 1];
            }
            arrySize--;
        }
    }

    public void insertValue(int value) {
        if (arrySize < theArray.length) {
            theArray[arrySize] = value;
            arrySize++;
        }
    }

    public static void printNumb(int num) {

        if (num == 0) {
            return;
        } else {
            Log.d("hi", String.valueOf(num));
            printNumb(num - 1);
        }
    }

    public static int catEyes(int cats) {
        if (cats == 0) {
            return 0;

        } else {
            return 2 + catEyes(cats - 1);
        }
    }


    class Runner extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d("Hello1 ", String.valueOf(i));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    class Runner2 extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d("Hello2 ", String.valueOf(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
