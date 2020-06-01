import java.util.Arrays;

public class Weekly_5424 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return  (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}
