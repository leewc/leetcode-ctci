public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        Map<Character, Integer> mmap = new HashMap<Character, Integer>();
        
        int length = s.length();
        for(Integer i = 0; i < length; i++)
        {
            Character cs = s.charAt(i);
            Character ts = t.charAt(i);
            
            if(smap.put(cs, i) != mmap.put(ts, i))
                return false;
        }
        
        return true;
    }
}

