import lesson6.TestTask.ArrayHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayHelperTestParams {
    @Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,4,5,7}, new int[]{5,7}, true},
                {new int[]{45,34,12,57,4}, new int[]{}, true},
                {new int[]{45,34,12,57,4,56,12,34}, new int[]{56,12,34}, true},
                {new int[]{45,4,12,57,4,22,34,123}, new int[]{12,57,4,22}, false},
                {new int[]{4,34,12,57,48}, new int[]{34,12,57,48}, true},
                {new int[]{56,4,56,1,4,56,123,4,57,12}, new int[]{56,123,4,57,12}, false},
                {new int[]{4}, new int[]{}, true},
        });
    }

    private ArrayHelper arrayHelper;
    private int[] input, result;
    private boolean eq;

    public ArrayHelperTestParams(int[] input, int[] result, boolean eq) {
        this.input = input;
        this.result = result;
        this.eq = eq;
    }

    @Before
    public void init(){
        arrayHelper = new ArrayHelper();
    }

    @Test
    public void testResult(){
        if(eq){
            Assert.assertArrayEquals(result, arrayHelper.splitArray(input));
        }
        else{
            Assert.assertNotEquals(result, arrayHelper.splitArray(input));
        }
    }
}
