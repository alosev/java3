import lesson6.TestTask.ArrayHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayCompositionTest {
    @Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,4,5,7}, true},
                {new int[]{5,2,8,34,91}, false},
                {new int[]{12,15,6,2,3,8,0}, false},
                {new int[]{1}, true},
                {new int[]{4}, true},
                {new int[]{}, false},
                {new int[]{8}, false},
                {new int[]{5,6,2,234,4,234,56}, true},
                {new int[]{5,6,2,234,234,56,1}, true},
        });
    }

    private ArrayHelper arrayHelper;
    private int[] input;
    private boolean result;

    public ArrayCompositionTest(int[] input, boolean result) {
        this.input = input;
        this.result = result;
    }

    @Before
    public void init(){
        arrayHelper = new ArrayHelper();
    }

    @Test
    public void testResult(){
        Assert.assertEquals(result, arrayHelper.checkComposition(input));
    }
}
