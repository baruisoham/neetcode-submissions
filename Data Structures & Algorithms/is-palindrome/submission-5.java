class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        int i=0, j=s.length()-1;
        while(i<=j){
            while(i<=j && !isAlphanumeric(s.charAt(i))) ++i;
            while(i<=j && !isAlphanumeric(s.charAt(j)) && i<=j) --j;
            if(i>j) break;
            if(Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) return false; 
            i++;
            j--;
        }

        return true;
    }

    public boolean isAlphanumeric(char ch){
        int ascii = (int) ch;
//SOHAM -- important -- if alphanumeric -- then use condition, between 0-9, A-Z, a-z.
        return ( ('0'<=ch && ch <='9') || ((int) 'A' <= ch && (int) 'Z'>= ch) || ((int) 'a' <= ch && (int) 'z'>= ch) );
    }
}
