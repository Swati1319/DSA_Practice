class Reverse
{
    //function to reverse a string
    public static String reverseWord(String str)
    {
        String rev = "";
        //iterating from the end of the string
        for(int i = str.length()-1; i >= 0; i--)
            //appending each character to the reverse string
            rev += str.charAt(i);
            
        //returning the reverse string
        return rev;
    }
}
