class Solution {
    int findMaxSum(int arr[], int n) {
        if (n == 0) return 0;

	    int value1 = arr[0];
	    if (n == 1) return value1;

	    int value2 = Math.max(arr[0], arr[1]);
	    if (n == 2) return value2;

	    // contains maximum sum at the end
	    int max_sum = 0;

	    // Fill remaining positions
	    for (int i = 2; i < n; i++) {
	        max_sum = Math.max(arr[i] + value1, value2);
	        value1 = value2;
	        value2 = max_sum;
	    }

	    return max_sum;
    }
}
