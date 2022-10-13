// Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers
//  such that they add up to a specific target number.
// Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, 
// where 1 <= answer[0] < answer[1] <= numbers.length.
// The tests are generated such that there is exactly one solution. You may not use the same element twice.

// Example 1:

// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
// Example 2:

// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
// Example 3:

// Input: numbers = [-1,0], target = -1
// Output: [1,2]

// Constraints:
// 2 <= numbers.length <= 3 * 104
// -1000 <= numbers[i] <= 1000
// numbers is sorted in non-decreasing order.
// -1000 <= target <= 1000
// The tests are generated such that there is exactly one solution.

// BRUTE FORCE, GIVES TLE

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for(int i = 1; i < nums.size(); i++){
            for(int j = 0; j < i; j++){
                if(nums[i] + nums[j] == target)
                    return {j+1, i+1};
            }
        }
        return {0, 0};
    }
};

// BINARY SEARCH OPTIMISED

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int left = 0, right = nums.size()-1;
        while(left < right){
            int x = nums[left] + nums[right];
            if(x == target)
                return {left+1, right+1};
            else if(x < target)
                left++;
            else
                right--;
        }
        return{0, 0};
    }
};