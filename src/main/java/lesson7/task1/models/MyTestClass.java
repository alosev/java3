package lesson7.task1.models;

public class MyTestClass {

    @BeforeSuite
    public void before(){
        System.out.println("before");
    }

    @AfterSuite
    public void after(){
        System.out.println("after");
    }

    @Test(priority = 10)
    public void test1(){
        System.out.println("run test 1");
    }

    @Test()
    public void test2(){
        System.out.println("run test 2");
    }

    @Test(priority = 5)
    public void test3(){
        System.out.println("run test 3");
    }

    @Test(priority = 2)
    public void test4(){
        System.out.println("run test 4");
    }

    @Test(priority = 1)
    public void test5(){
        System.out.println("run test 5");
    }

}
