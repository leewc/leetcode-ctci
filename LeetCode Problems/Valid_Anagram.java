public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray())
        {
            if(map.get(c) == null)
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }
        
        for(Character c: t.toCharArray())
        {
            Integer entry = map.get(c);
            if(entry == null || entry == 0)
                return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}