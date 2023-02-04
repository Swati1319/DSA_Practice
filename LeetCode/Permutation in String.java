class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();
        for (int left = 0, right = 0; right < s2.length(); right++) {
            char cRight = s2.charAt(right);
            if (map.containsKey(cRight)) {
                map.put(cRight, map.get(cRight) - 1);
                if (map.get(cRight) == 0) {
                    counter--;
                }
            }

            while (counter <= 0) {
                char cLeft = s2.charAt(left);
                if (map.containsKey(cLeft)) {
                    map.put(cLeft, map.get(cLeft) + 1);
                    if (map.get(cLeft) > 0) {
                        counter++;
                    }
                }
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                left++;
            }
        }
        return false;
    }
}
