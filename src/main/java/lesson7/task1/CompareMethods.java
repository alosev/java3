package lesson7.task1;

import lesson7.task1.models.Test;

import java.lang.reflect.Method;

public class CompareMethods {
    public static int asc(Method m1, Method m2){
        int p1 = m1.getAnnotation(Test.class).priority();
        int p2 = m2.getAnnotation(Test.class).priority();

        if(p1 > p2){
            return 1;
        }

        return -1;
    }

    public static int desc(Method m1, Method m2){
        int p1 = m1.getAnnotation(Test.class).priority();
        int p2 = m2.getAnnotation(Test.class).priority();

        if(p1 > p2){
            return -1;
        }

        return 1;
    }
}
