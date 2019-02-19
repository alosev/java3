import lesson6.TestTask.ArrayHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ArrayHelperTest {

    private ArrayHelper arrayHelper;

    @Before
    public void init(){
        arrayHelper = new ArrayHelper();
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testEmptyInput(){
        arrayHelper.splitArray();
    }

    @Test(expected = RuntimeException.class)
    public void testNotNumber4(){
        arrayHelper.splitArray(1,2,5,14,8,19);
    }

    @Test
    public void testEqualsResult(){
        Assert.assertArrayEquals(new int[]{56,12,66}, arrayHelper.splitArray(67,43,23,4,545,12,4,56,12,66));
        Assert.assertArrayEquals(new int[]{43,23,32,545,12,44,56,12,66}, arrayHelper.splitArray(4,43,23,32,545,12,44,56,12,66));
        Assert.assertArrayEquals(new int[]{}, arrayHelper.splitArray(43,23,32,545,12,44,56,12,66,4));
        Assert.assertArrayEquals(new int[]{}, arrayHelper.splitArray(4,4,4,4,4,4,4,4,4,4,4,4,4,4));
    }

    @Test
    public void testNotEqualsResult(){
        Assert.assertNotEquals(new int[]{4,546,756,23,123,456,56}, arrayHelper.splitArray(783,234,123,334,56,23,12,4,123,123,5,675,123,4,546,756,23,123,456,56));
        Assert.assertNotEquals(new int[]{45,345,23,34,5345}, arrayHelper.splitArray(4,45,345,23,34,5345,4,234,234,11,56));
        Assert.assertNotEquals(new int[]{543,345,23,454,234}, arrayHelper.splitArray(543,345,23,454,234,123,4,123,123,123,4));
        Assert.assertNotEquals(new int[]{234,123,4,123,123}, arrayHelper.splitArray(543,345,23,454,234,123,4,123,123));
    }
}
