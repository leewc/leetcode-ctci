public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0)
        {
            n--; //decrement n first so instead of 1 -> 'A' 0 -> 'A'
            sb.insert( 0, (char) ('A' + n % 26));
            n = n / 26;
        }
        // same run time as using sb.append((char) ('A' + n % 26)) then sb.reverse().toString()
        return sb.toString();
    }
}