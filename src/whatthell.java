import java.util.Arrays;

public class whatthell {
    public static void main(String[] args) {
        int[] nums = {12,45,56,77,22};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void change(int[] arr) {
        arr[0]=99;
    }
}
