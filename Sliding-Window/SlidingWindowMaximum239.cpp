// You are given an array of integers nums, there is a sliding window of size k which
// is moving from the very left of the array to the very right. You can only see the 
// k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window. 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
// Example 3:

// Input: nums = [1,-1], k = 1
// Output: [1,-1]
// Example 4:

// Input: nums = [9,11], k = 2
// Output: [11]
// Example 5:

// Input: nums = [4,-2], k = 2
// Output: [4]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length


// METHOD 1
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        deque<int> dq;
        int start = 0, end = 0, n = nums.size();
        for(end = 0; end < n; end++){
            while(end < n and !dq.empty() and dq.back() < nums[end])
                dq.pop_back();
            dq.push_back(nums[end]);
            if(end - start + 1 == k){
                ans.push_back(dq.front());
                if(dq.front() == nums[start])
                    dq.pop_front();
                start++;
            }
        }
        return ans;
    }
};



// METHOD 2 (Almost same)
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        deque<int> dq;
        int i=0, j=0;
       while(i<nums.size()){
           while(!dq.empty() and nums[i] > dq.back())
               dq.pop_back();
           dq.push_back(nums[i]);
           if(i-j+1 < k){
               i++;
           }
            else if(i-j+1 == k){
               ans.push_back(dq.front());
               if(nums[j] == dq.front())
                  dq.pop_front();
               i++; j++;               
            } 
         }     
        return ans;
    }
};
