public class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strings[i] = Integer.toString(nums[i]);
        //convert to strings for lexicographic sorting
        Comparator<String> comparator = new Comparator<String>() {
                                            public int compare(String a, String b) {
                                                String one = a + b;
                                                String two = b + a;
                                                return one.compareTo(two);
                                            }
                                        };
        Arrays.sort(strings, comparator);
        
        if(strings[strings.length - 1].equals("0")) return "0"; //edge case
        
        StringBuilder sb = new StringBuilder();
        //alternatively do two.compareTo(one) and then sb.append(s)
        for(String s : strings)
            sb.insert(0, s);
        return sb.toString();
    }
}