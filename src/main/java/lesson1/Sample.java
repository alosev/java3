package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Sample<T>{

    public T[] swapArrayElements(T[] obj){
        if(obj.length > 1){
            T element = obj[0];
            obj[0] = obj[1];
            obj[1] = element;
        }
        return obj;
    }

    public ArrayList<T> convertToList(T[] obj){
        return new ArrayList<T>(Arrays.asList(obj));
    }
}
