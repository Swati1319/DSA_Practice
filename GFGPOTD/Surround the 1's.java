class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(matrix[i][j]==1){
        			int cnt = 0;
        			if(i - 1 >= 0)
        				cnt += matrix[i-1][j] == 0?1:0;
        			if(i + 1 < n)
        				cnt += matrix[i+1][j] == 0?1:0;
        			if(j - 1 >= 0)
        				cnt += matrix[i][j-1] == 0?1:0;
        			if(j + 1 < m)
        				cnt += matrix[i][j+1] == 0?1:0;
        			if(i - 1 >= 0 && j - 1 >= 0)
        				cnt += matrix[i-1][j-1] == 0?1:0;
        			if(i - 1 >= 0 && j + 1 < m)
        				cnt += matrix[i-1][j+1] == 0?1:0;
        			if(i + 1 < n && j - 1 >= 0)
        				cnt += matrix[i+1][j-1] == 0?1:0;
        			if(i + 1 < n && j + 1 < m)
        				cnt += matrix[i+1][j+1] == 0?1:0;
        			if((cnt & 1)==0 && cnt!=0)
        				ans++;
        		}
        	}
        }
        return ans;
    }
}
