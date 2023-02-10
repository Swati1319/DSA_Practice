class Solution {
    public int maxInstance(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        return Math.min(Math.min(freq['o' - 'a'] / 2, freq['l' - 'a'] / 2),
                        Math.min(Math.min(freq['b' - 'a'], freq['a' - 'a']),
                                 freq['n' - 'a']));
    }
}
