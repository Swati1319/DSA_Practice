class Solution {
    public long count(int coins[], int N, int sum) {
        long table[] = new long[sum + 1];
        for (int i = 0; i < sum + 1; i++) table[i] = 0;
        table[0] = 1;
        for (int i = 0; i < N; i++)
            for (int j = coins[i]; j <= sum; j++) table[j] += table[j - coins[i]];

        return table[sum];
    }
}
