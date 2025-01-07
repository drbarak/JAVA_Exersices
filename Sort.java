

public class Sort
{
    private static boolean p = false;
    private static int count;
    
    // selection sort using recursion
    public static void selectioSort(int[]a)
    {
        if (a.length > 0) selectioSort(a, 0);
        return;
    }
    private static int selectioSort(int[]a, int i)
    {
        int n = a.length;
        if (i == n - 1) return a[i];
            // find the minimum from the partial array starting from position i
        int minIndex = selectioSort(a, i + 1, i);
        if (p) Print.p(i, minIndex, a[minIndex], a[i]);
        if (a[minIndex] < a[i])
            MyLibrary.swap(a, i, minIndex);
        if (p) Print.p(a);
        return selectioSort(a, i + 1);
    }
    private static int selectioSort(int[]a, int i, int minIndex)
    {
        int n = a.length;
        if (i >= n) return minIndex;
            // find the minimum from the partial array starting from position i
        if (p) Print.p(i, minIndex, a[minIndex], a[i]);
        if (a[minIndex] > a[i])
            minIndex = i;
        return selectioSort(a, i + 1, minIndex);
    }
    // Main method to sort an array using Radix Sort - chatGPT
    public static void radixSort(int[] arr) {
        // Find the maximum number to know the number of digits
        int max = getMax(arr);

        // Perform counting sort for each digit, starting from least significant digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
    // Function to get the maximum value in the array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr)
            if (num > max) max = num;
        return max;
    }
    // Counting Sort subroutine used for sorting based on a specific digit
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array to store sorted values
        int[] count = new int[10]; // Base 10 for digits (0-9)

        // Count occurrences of digits
        int digit;
        for (int i = 0; i < n; i++) {
            digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Update count array to store cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        // Copy the sorted elements back into the original array
        System.arraycopy(output, 0, arr, 0, n);
    }
    
    public static void quickSort(int[] nums, boolean descending)
    {
        count = 0;
        p=true;
        int n = nums.length;
        int low=0, high=n-1;
        /*
            // Mimic a stack - size is max n, because we are spliting the array
            //      n/2 times
            // The stack is used to store low and high indices for subarrays
        int[] stack = new int[n];
        int top = -1;
            // Push the initial range of the array to the stack
        stack[++top] = low;
        stack[++top] = high;
        quickSortOK(nums, descending, top, stack);
        */
        quickSort(nums, descending, low, high);
        Print.p("count = "+count);
    }
    public static void quickSort(int[] nums, boolean descending, int low, int high)
    {
        if (low < high) 
        {
            int mid = partition(nums, low, high, descending, low-1);
            if (p) Print.p(low,high, mid);
            if (low < mid - 1)
                quickSort(nums, descending, low, mid - 1);
            if (mid + 1 < high)
                quickSort(nums, descending, mid + 1, high);
        }
        return;
    }
    public static void quickSortOK(int[] nums, boolean descending, int top, int[] stack)
    {
        if (top >= 0) 
        {
            //count++;
            // Pop the range of the array from the stack
            int high = stack[top--];
            int low = stack[top--];
            int mid = partition(nums, low, high, descending, low-1);
            if (p) Print.p(low,high, mid);
            // Push the 2 partitions to the stack
            if (mid - 1 > low)
            {
                stack[++top] = low;
                stack[++top] = mid - 1;
            }
            if (mid + 1 < high)
            {
                stack[++top] = mid + 1;
                stack[++top] = high;
            }
            quickSortOK(nums, descending, top, stack);
        }
        return;
    }
    private static int partition(int[] nums, int j, int high, boolean descending, int index)
    {
        p=false;
        if (j == high)
        {
            MyLibrary.swap(nums, index+1, high); // place the pivot in the right position
            return index+1;    // return the pivot index
        }
        count++;
        if (p) Print.p(index,j, nums[j], nums[high]);
        if (p) Print.p(count,j,high);
        if ((!descending && nums[j] <= nums[high]) ||
                    (descending && nums[j] >= nums[high]))
        {
            index++;
            if (index != j)
                MyLibrary.swap(nums, index, j);
        }
        if (p) Print.p(nums);
        index = partition(nums, j + 1, high, descending, index);
        return index;
    }
    
    public static void quickSortLoop(int[] nums, boolean descending)
    {
        count = 0;
        int n = nums.length;
        int low=0, high=n-1;
            // Mimic a stack - size is max n, because we are spliting the array
            //      n/2 times
            // The stack is used to store low and high indices for subarrays
        int[] stack = new int[n];
        int top = -1;
            // Push the initial range of the array to the stack
        stack[++top] = low;
        stack[++top] = high;
        while (top >= 0)
        {
            // Pop the range of the array from the stack
            high = stack[top--];
            low = stack[top--];
            int mid = partition(nums, low, high, descending);
            if (p) Print.p(low,high, mid);
            // Push the 2 partitions to the stack
            if (mid - 1 > low)
            {
                stack[++top] = low;
                stack[++top] = mid - 1;
            }
            if (mid + 1 < high)
            {
                stack[++top] = mid + 1;
                stack[++top] = high;
            }
        }
        Print.p("count = "+count);
        return;
    }
    private static int partition(int[] nums, int low, int high, boolean descending)
    {
        int i = low-1;              // Index of smaller element
        for (int j=low;j<high;j++)
        {
            count++;
            if (p) Print.p(i,j);
            if ((!descending && nums[j] <= nums[high]) ||
                    (descending && nums[j] >= nums[high]))
            {
                i++;
                if (i != j)
                    MyLibrary.swap(nums, i, j);
            }
            if (p) Print.p(nums);
        }
        MyLibrary.swap(nums, i+1, high); // place the pivot inthe right position
        return i+1;    // return the pivot index
    }
    /**
     * במסגרת הקורס, לפתרון ממ"נים השתמשתי באלגוריתם שנקרא מערך נוכחות (presence array
     * ) ולאחר מכן הגעתי למסקנה שניתן להשתמש באותה שיטה כדי למיין מערך של מספרים שלמים.
כתבתי את השיטה והיא בסיבוכיות של max-min + 1 + n, כאשר n הוא אורך המערך המקורי, 
ו-max  הוא המספר המקסימלי במערך, ו-min הוא הגודל המינימלי.
סיבוכיות זו קבועה במקרה הטוב ביותר, הממוצע, והגרוע ביותר, לעומת מיון מהיר שהוא n^2 במקרה הגרוע ביותר.
למקרים שבהם max-min אינו גדול מדי, כמו כל הדוגמאות בממ"נים שלנו, 
או במקרה שצריך למיין ציונים של קבןצת סטודנטים, המיון הזה יעיל יותר.
לאחר שכתבתי את השיטה התייעצתי עם chatGPT והוא אמר לי
שהמיון שפיתחתי דומה למיון בשם Counting Sort ואכן העקרון שם הוא כמעט זהה לשלי.
אבל האלגוריתם שלי טוב יותר במספר נקודות:
1. המיון שלי אינו מוגבל למספרים חיוביים בלבד.
2. המיון שלי מאפשר מיון בסדר עולה ובסדר יורד.
3. סיבוכיות המקום והזמן של המיון שלי, במקרה של מספרים חיוביים בלבד, טובה יותר
 כי אני משתמש במערך עזר בגודל max-min+1 לעומת max+1 של המיון Counting.
השיטה היא די קצרה ופשוטה.

תיקון: הסיבוכיות של המיון שלי היא 2n+max-min+1 ושל מיון מהיר היא 1/2n*(n+1) במקרה הגרוע, 
כך שלמערכים לא גדולים מיון מהיר עדיין יהיה יותר טוב - בדקתי עבור מערך בן 11 מספרים, 
שהם בסדר יורד ובחירת pivot המספר הקטן ביותר בכל תת-מערך, כאשר ההפרש בין 
הגדול לקטן הוא 11 - מיון מהיר לקח 55 פעולות ושלי 44. הפרש לא משמעותי. 
עבור אותו מערך, שמסודר רנדומלי, מיון מהיר ירד ל-38 ושלי נשאר ב-44
     */
    public static int[] mySort(int[] nums, boolean descending)
    {
        count = 0;
        if (nums.length < 2) return nums;
        // step 1: find min and max of array O(n)
        int min = nums[0], max = min;
        for (int num: nums)
        {
            count++;
            if (min > num) min = num;
            if (max < num) max = num;
        }
        // step 2: create an array of differnces with min, size of max-min+1
        int[] frequency = new int[max - min + 1];
        if (p) Print.p(max-min+1);
        for (int num : nums)
        {
            count++;
            frequency[descending? max-num : num-min]++;
        }
        //Step 3: sort
        int[] sorted = new int[nums.length];
        int index = 0;
        for (int i=0; i<frequency.length; i++)
        {
            while (frequency[i] > 0)
            {
                count++;
                        // Adjust value based on sort direction
                sorted[index++] = descending ? max - i : min + i;
                frequency[i]--;
            }
        }
        Print.p("count = "+count);
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
} // Sort