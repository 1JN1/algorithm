package day_131;

/**
 * @author 王文涛
 * @date 2025/5/8
 * @description
 **/
public class Problem01 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

        int[] ans = {-1, -1};

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + indexDifference; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }

    public int[] findIndices2(int[] nums, int indexDifference, int valueDifference) {

        int n = nums.length;
        int minIdx = 0, maxIdx = 0;

        for (int j = indexDifference; j < n; j++) {

            int i = j - indexDifference;
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }

            if (nums[j] - nums[minIdx] >= valueDifference) {
                return new int[]{minIdx, j};
            }

            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }

            if (nums[maxIdx] - nums[j] >= valueDifference) {
                return new int[]{maxIdx, j};
            }

        }

        return new int[]{-1, -1};
    }

}
