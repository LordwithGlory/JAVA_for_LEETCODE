public class Leetcode125 {
    public boolean isPalindrome(String s) {
        s=s.strip().toLowerCase();
        int left=0;
        int right=s.length()-1;
        while (left<right){
            while (s.charAt(left)<'0'||s.charAt(left)>'z'||s.charAt(left)<'a'&&s.charAt(left)>'9'){
                left++;
                if (left>right)
                    return true;
            }
            while (s.charAt(right)<'0'||s.charAt(right)>'z'||s.charAt(right)<'a'&&s.charAt(right)>'9'){
                right--;
                if (left>right)
                    return true;
            }
            if (s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
