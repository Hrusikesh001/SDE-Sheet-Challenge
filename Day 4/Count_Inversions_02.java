public class Count_Inversions_02 {
    public int numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    private int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {

                count += (mid - left + 1);

                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return count;
    }
    public static void main(String[] args) {
        Count_Inversions_02 solution = new Count_Inversions_02();
        int[] nums = {1, 20, 6, 4, 5};
        int inversions = solution.numberOfInversions(nums);
        System.out.println("Number of inversions: " + inversions);
    }
}
