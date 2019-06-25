import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    private Integer[] arr;
    private Integer[] sortedArr;

    @Before
    public void initializeDatabase() {
        this.arr = new Integer[] {3, 8, 1, 6, 9, 2, 0, 7, 5, 4};
        this.sortedArr = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    public void testIfBubbleSortWorks() {
        BubbleSort.bubbleSort(arr);
        for (int i = 0; i < sortedArr.length; i++) {
            Assert.assertEquals(sortedArr[i], arr[i]);
        }
    }

    @Test
    public void testIfBubbleSortWorksWithSimilarElements() {
        Integer[] similar = new Integer[] {1, 1, 1, 1, 2, 1, 1};
        Integer[] sortedSimilar = new Integer[] {1, 1, 1, 1, 1, 1, 2};

        BubbleSort.bubbleSort(similar);
        for (int i = 0; i < similar.length; i++) {
            Assert.assertEquals(sortedSimilar[i], similar[i]);
        }
    }
}
