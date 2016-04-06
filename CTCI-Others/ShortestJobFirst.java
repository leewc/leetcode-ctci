import java.util.*;

public class ShortestJobFirst {
    
    public static float SJFAverage(int[] requestTimes, int[] duration) {
        if(requestTimes == null || duration == null || requestTimes.length != duration.length)
            return -1.0f;
        
        int len = requestTimes.length; //same length for both duration
        int idx = 0;
        int totalWaitTime = 0;
        int currentTime = 0;
        
        PriorityQueue<Process> pq = new PriorityQueue<>(requestTimes.length,
                                                            new Comparator<Process>() {
                                                                    public int compare(Process a, Process b) {
                                                                        if(a.executeTime != b.executeTime)
                                                                            return a.executeTime - b.executeTime;
                                                                        return a.arrivalTime - b.arrivalTime;
                                                                        //if execute time are equal return the earlier one
                                                                    }
                                                                });
        while(!pq.isEmpty() || idx != len) {
            if(!pq.isEmpty()) {
                Process current = pq.poll();
 
                totalWaitTime += currentTime - current.arrivalTime;
                currentTime += current.executeTime;
 
                while(idx < len && requestTimes[idx] <= currentTime) {
                    pq.offer(new Process(requestTimes[idx], duration[idx]));
                    idx++;
                }
            }
            else {
                //nothing in queue, put a process in.
                pq.offer(new Process(requestTimes[idx], duration[idx]) );
                //update current time
                currentTime = requestTimes[idx];
                idx++;
            }
        }
        return (float) totalWaitTime / len;
    }
    
    public static void main(String[] args) {
        int[] arrival2 = {0, 1, 3, 9}; 
        int[] run2 = {2, 1, 7, 5}; 
        int q2 = 2; 
        
        System.out.println("Average Waiting Time SHortestJobFirst: " + SJFAverage(arrival2, run2)); 
    }
}

class Process {
    int arrivalTime;
    int executeTime;
    
    public Process(int arrivalTime, int executeTime) {
        this.arrivalTime = arrivalTime;
        this.executeTime = executeTime;
    }
}