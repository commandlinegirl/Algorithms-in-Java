import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TestBinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        List<Integer> list = Arrays.asList(new Integer[] {1, 2, 2, 3, 4, 5, 10, 18});
        int result = bs.binarySearch(list, 3);
        System.out.println(result);
    }
}
