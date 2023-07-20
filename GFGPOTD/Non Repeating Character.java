
class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
            int h[] = new int[26];
            Arrays.fill(h, 0);
    	    
        //using hash table to store count of each character.
        for(int i = 0;i<S.length();i++){
            h[S.charAt(i)-'a']++;
        }
    
        
        StringBuilder st = new StringBuilder("");
        
        //iterating over the string.
        for(int i = 0;i<S.length();i++)
        {
            //if count of current character is 1, we return it. 
            if(h[S.charAt(i)-'a'] == 1){
                return(S.charAt(i));
                
            }
        }
        //if there is no non-repeating character then we return '$'.
        return '$';
    }
}
