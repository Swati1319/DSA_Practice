// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]
 

// Constraints:

// 1 <= numRows <= 30

class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        for(int i = 0; i < numRows; i++){
            vector<int> row;
            for(int j = 0; j <= i; j++){
                if(j == 0 or j  == i)
                    row.push_back(1);
                else if(i > 0 and j > 0)
                    row.push_back(ans[i-1][j-1] + ans[i-1][j]);
            }
            ans.push_back(row);
        }
        return ans;
    }
};