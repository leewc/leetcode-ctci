public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] table = new boolean[n];
        
        //initialize table of values
        for(int i = 2; i < n; i++)
            table[i] = true;
        
        for(int i = 2; i * i < n; i++) // no need i < n since primes are up to sqrt(n)
        {
            if(table[i])
            {
                for(int j = i * i; j < n; j += i) //multiples of i
                    table[j] = false;
            }
        }
        
        //count all primes 
        for(int i = 2; i < n; i++)
            if(table[i]) count++;
        
        return count;

    }
    // public int countPrimesTooSlowTooMuchMemory(int n) {
    //     int count = 0; 
        
    //     //initialize hashmap with numbers
    //     Map<Integer, Boolean> map = new HashMap<>();
    //     for(int i = 2; i < n; i++) //1 is not a prime
    //         map.put(i, true);
        
    //     for(Integer key : map.keySet())
    //     {
    //         if(key * key < n)
    //         {
    //             if(map.get(key)) //if entry if true we have a prime and remove all multiples.
    //             {
    //                 for (int j = key * key; j < n; j += key)
    //                     map.put(j, false);
    //             }
    //         //else we skip the key since there's no need for it
    //         }
    //         else
    //             break;
    //     }
    //     for(Integer key : map.keySet())
    //         if(map.get(key)) count++;
    //     return count;
    // }
}