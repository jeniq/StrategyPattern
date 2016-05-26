package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int[] arr0 = {1, 3, 2, 1};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr0);

        int[] arr1 = {21, 2, 10, 43, 1, 3, 2, 1};
        c.setStrategy(new InsertionSort());
        c.executeStrategy(arr1);
    }
}

// Context
class StrategyClient{
    Sorting strategy;
    public void setStrategy(Sorting strategy){
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}

// Strategy
interface Sorting{
    void sort(int[] arr);
}

// Bubble sorting strategy
class BubbleSort implements Sorting{
    public void sort(int[] arr){
        System.out.println("Bubble sort");
        System.out.println("Before:\t"+ Arrays.toString(arr));
        for (int barrier = arr.length - 1; barrier >= 0; barrier--){
            for (int i = 0; i < barrier; i++){
                if (arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}

class InsertionSort implements Sorting{
    public void sort(int[] arr){
        System.out.println("Insertion sort");
        System.out.println("Before:\t"+Arrays.toString(arr));
        for (int barrier = 1; barrier < arr.length; barrier++){
            int index = barrier;
            while (index - 1 >= 0 && arr[index] < arr[index-1]){
                int tmp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = tmp;
                index--;
            }
        }
        System.out.println("After:\t"+Arrays.toString(arr));
    }
}
