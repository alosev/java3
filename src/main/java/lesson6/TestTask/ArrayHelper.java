package lesson6.TestTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayHelper {

    public int[] splitArray(int... data){
        int targetNumber = 4;

        if(data.length < 1){
            throw new NegativeArraySizeException();
        }

        for (int i = data.length - 1; i >= 0; i--) {
            int number = data[i];
            if(number == targetNumber){
                return cutArray(data, i);
            }
        }

        throw new RuntimeException();
    }

    private int[] cutArray(int[] data, int index){
        int resIndex = 0;
        int startIndex = index + 1;
        int resLength = (data.length - 1) - index;
        int[] res = new int[resLength];

        for(int j = startIndex; j < data.length; j++){
            res[resIndex] = data[j];
            resIndex++;
        }

        return res;
    }

    public boolean checkComposition(int... data){
        HashSet<Integer> checkNumbers = new HashSet<>(Arrays.asList(1,4));

        for (int i = 0; i < data.length; i++) {
            if(checkNumbers.contains(data[i])){
                return true;
            }
        }

        return false;
    }
}
