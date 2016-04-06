public class Solution {
    public String getHint(String secret, String guess) {
        //count of characters
        Map<Character, Integer> map = new HashMap<>();
        int bull = 0;
        int cow = 0;
            
        for(int i = 0; i < secret.length(); i++)
        {
            Character cur = secret.charAt(i);
            if(map.get(cur) == null)
                map.put(cur, 1);
            else
                map.put(cur, map.get(cur) + 1);
        }
        
        for(int i = 0; i < guess.length(); i++)
        {
            Character cur = guess.charAt(i);
            Integer entry = map.get(cur);
            
            if(entry == null) entry = 0;
            
            if(cur == secret.charAt(i))
            {
                bull++; //count bulls
                if(entry <= 0)
                    cow--;
            }
            else if(entry > 0)
            {
                cow++;
            }
            //no action for else.
            
            if(map.get(cur) != null) //decrement count
                map.put(cur, map.get(cur) - 1);
                
        }
        
        // return String.format("%dA%dB", bull, cow); //somehow this takes 8ms
        return bull + "A" + cow + "B";
    }
}