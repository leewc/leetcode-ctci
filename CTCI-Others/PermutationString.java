public class PermutationString {
    private static void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
    
    private static String Permutate(char[] s, int l, int r) {
        if(l == r)
            return new String(s);
        else {
            String s2 = "";
            for(int i = l; i <= r; i++) {
                swap(s, l, i);
                s2 += Permutate(s, l + 1, r) + " ";
                swap(s, l, i);
            }
            return s2;
        }
    }
    
    public static String Permutate (String s) {
        return Permutate(s.toCharArray(), 0, s.length() - 1);
        // return new String(Permutate(s.toCharArray(), 0, s.length() - 1));
    }
    
    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(Permutate(s));
    }
}