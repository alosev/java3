package lesson7.task1;

import lesson7.task1.models.AfterSuite;
import lesson7.task1.models.BeforeSuite;
import lesson7.task1.models.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProcessTestClass {
    private Method beforeMethod = null;
    private Method afterMethod = null;
    private List<Method> tests = null;
    private Class testClass = null;
    private Comparator<? super Method> sorted;

    public ProcessTestClass(Comparator<? super Method> sorted) {
        this.sorted = sorted;
    }

    public void setSorted(Comparator<? super Method> sorted) {
        this.sorted = sorted;
    }

    public void start(Class testClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        beforeMethod = null;
        afterMethod = null;
        tests = new ArrayList<>();
        this.testClass = testClass;

        prepareMethods();

        invokeMethods();
    }

    private void prepareMethods(){
        for (Method method: testClass.getDeclaredMethods()) {
            processMethod(method);
        }

        tests.sort(sorted);
    }

    private void processMethod(Method method){
        if(method.getAnnotation(BeforeSuite.class) != null){
            if(beforeMethod != null){
                throw new RuntimeException();
            }
            beforeMethod = method;
        }

        if(method.getAnnotation(AfterSuite.class) != null){
            if(afterMethod != null){
                throw new RuntimeException();
            }
            afterMethod = method;
        }

        if(method.getAnnotation(Test.class) != null){
            tests.add(method);
        }
    }

    private void invokeMethods() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object obj = testClass.newInstance();

        if(beforeMethod != null){
            beforeMethod.invoke(obj);
        }

        for (Method test: tests) {
            test.invoke(obj);
        }

        if(afterMethod != null){
            afterMethod.invoke(obj);
        }
    }
}
