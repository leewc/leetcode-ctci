public class DayChangeCellGrowth {
    
    // e.g. Cell is inactive (0) is both left and right of cell has same value, else active
    // changes on the same day do not affect the rest of the array
    // cells: [1, 0, 0, 0, 0, 1, 0, 0]
    // days: 1
    // output: [0, 1, 0, 0, 1, 0, 1, 0]

    public static int[] dayChange(int[] cells, int days) {
        int currentDay = 0;
        int len = cells.length;
        
        if(len <= 1 || days < 0) return cells; 
        
        while(currentDay != days) {
            int[] changes = new int[len];
            //O(n) for each day
            // if left and right are both same values it's 0 (inactive), else it's 1 (active)
            // for edges (index 0 and len - 1) the out of bound value is assumed to be 0.
            for(int i = 0; i < len; i++) {
                if(i == 0)
                    changes[i] = (cells [i+1] == 1) ? 1 : 0;
                else if(i + 1 == len)
                    changes[i] = (cells [i-1] == 1) ? 1 : 0;
                else 
                    changes[i] = (cells [i-1] == cells[i+1]) ? 0 : 1;
            }
            cells = changes;
            // System.out.println("Changed: " + java.util.Arrays.toString(cells));
            currentDay++;
        }
        return cells;
    }
    
    
    public static void main(String[] args) {
        
        int[] cells = {1, 0, 0, 0, 0, 1, 0, 0};
        
        System.out.println("State of Cells: " + java.util.Arrays.toString(cells));
        System.out.println("Cells after changes: " + java.util.Arrays.toString(dayChange(cells, 5)));
        
        // Also notice how I if I just called dayChange and then print the cells the cells array retains it's original value
        // This is because of pass-by-value, where the memory address is passed, then the function inside 
        // created a new array and performed changes, then only assigning cells = changes, which changes what 
        // the cells variable points to, but since it is only pass by value the cells variable in main()
        // still points to the original memory reference.
    }
}