

public class Sort
{
    private static boolean p = false;

    public static int[] mySort(int[] nums, boolean descending)
    {
        if (nums.length < 2) return nums;
        // step 1: find min and max of array O(n)
        int min = nums[0], max = min;
        for (int num: nums)
        {
            if (min > num) min = num;
            if (max < num) max = num;
        }
        // step 2: create an array of differnces with min, size of max-min+1
        int[] frequency = new int[max - min + 1];
        for (int num : nums)
            frequency[descending? max-num : num-min]++;
        //Step 3: sort
        int[] sorted = new int[nums.length];
        int index = 0;
        for (int i=0; i<frequency.length; i++)
        {        // Adjust value based on sort direction
            int value = descending ? max - i : min + i;
            while (frequency[i] > 0)
            {
                sorted[index++] = value;
                frequency[i]--;
            }
        }
        return sorted;
    }
    public static int[] mySortWithPrinting(int[] nums, boolean descending) // with modifications for clarity and bravity from chatGPT
    {
        if (nums.length < 2) return nums;
        // step 1: find min and max of array O(n)
        int min = nums[0];
        int max = min;
        for (int num: nums)
        {
            if (min > num) min = num;
            if (max < num) max = num;
        }
        if (p) Print.p(min, max);
        // step 2: create an array of differnces with min, size of max-min+1
        int[] frequency = new int[max - min + 1];
        for (int num : nums)
            frequency[descending? max-num : num-min]++;
        if (p) Print.p(frequency);
        //Step 3: sort
        int[] sorted = new int[nums.length];
        int index = 0;
        for (int i=0; i<frequency.length; i++)
        {
            int value = descending ? max - i : min + i; // Adjust value based on sort direction
            while (frequency[i] > 0)
            {
                sorted[index++] = value;
                frequency[i]--;
            }
        }
        return sorted;
    }

}
