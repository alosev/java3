package lesson7.task1;

import lesson7.task1.models.*;

import java.lang.reflect.InvocationTargetException;

public class MainTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        run();
    }

    private static void run() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        ProcessTestClass processTestClass = new ProcessTestClass(CompareMethods::asc);
        processTestClass.start(MyTestClass.class);

        System.out.println("===============================");

        processTestClass.setSorted(CompareMethods::desc);
        processTestClass.start(MyTestClass.class);
    }
}

