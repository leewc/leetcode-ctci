public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        
        if(words.length != pattern.length())
            return false;
            
        for(int i = 0; i < words.length; i++)
        {
            
            Character current = pattern.charAt(i);
            if(map.containsKey(current))
            {
                if(!map.get(current).equals(words[i]))
                    return false;
            }
            else 
            {
                if(map.containsValue(words[i]))
                    return false;
                map.put(current, words[i]);
            }
        }
        return true;
    }
}