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
    //    bubbleSort();
        Log.d("theArray bubbleSort: ", Arrays.toString(theArray));
        binarySearch(3);
       // selectionSort();
        Log.d("theArray selectinSort: ", Arrays.toString(theArray));
        insertionSort();
        Log.d("theArray insertonSort: ", Arrays.toString(theArray));
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

    public void bubbleSort() {
        for (int i = arrySize - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (theArray[j] > theArray[j + 1]) {
                    int index1 = theArray[j];
                    int index2 = theArray[j + 1];
                    theArray[j] = index2;
                    theArray[j + 1] = index1;
                }
            }
        }
    }

    public void binarySearch(int value) {
        int lowIndex = 0;
        int hignIndex = arrySize;
        while (lowIndex <= hignIndex) {
            int middleIndex = (lowIndex + hignIndex) / 2;
            if (theArray[middleIndex] < value) {
                   lowIndex = middleIndex + 1;
            } else if (theArray[middleIndex] > value) {
                hignIndex = middleIndex - 1;
            } else {
                Log.d("Found for the " + value + "at index" + middleIndex, "");
                //stops while looop
                lowIndex = hignIndex + 1;
            }
        }

    }

    public void selectionSort(){

        for(int i = 0;i<arrySize;i++){
            for(int j=i+1;j<arrySize;j++){
                if(theArray[j]<theArray[i]){
                    int index1 = theArray[i];
                    int index2 = theArray[j];
                    theArray[j] = index1;
                    theArray[i] = index2;
                }
            }
        }
    }
    public void insertionSort(){

        for (int i =0;i<arrySize;i++){
            int key = theArray[i];
            int j = i - 1;
            while (j>=0 && theArray[j] > key){
                theArray[j + 1] = theArray[j];
                j--;
            }
        }
    }
    public boolean doesArrayContainThisVal(int value) {
        boolean valInArr = false;

//        for(int i = 0;i<arrySize;i++){
//            if(theArray[i] == value){
//                valInArr = true;
//            }
//        }

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
