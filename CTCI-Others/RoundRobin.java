
import java.util.*;

public class RoundRobin {
    /* Parameters:
       Arrival is an int[] of arrival times
       Run is an int[] of run times
       Q is quantum for the round robin scheduler
       Return: Total average wait time
    */
    public static float waitingTimeRobin(int[] arrival, int[] run, int quantum) {
        
        if(arrival == null || run == null || arrival.length != run.length || quantum == 0) 
            return 0.0f; //edge cases
        
        int waitTime = 0;       //total wait time
        int currentTime = 0;    //current time taken from process arrival
        int idx = 0; //idx within the arrival array
        Queue<Process> q = new LinkedList<>();
        
        while(!q.isEmpty() || idx < arrival.length) {
            if(!q.isEmpty()) {
                //obtain process from the q
                Process cur = q.poll();
                //waitTime = time to start process - arrival time of process
                waitTime += currentTime - cur.arrivalTime;
                
                //advance currentTime by quantum or execute time, whichever lesser
                currentTime += Math.min(cur.executeTime, quantum);
                
                System.out.println("WAIT TIME: " + waitTime + " CURR TIME: " + currentTime);

                while(idx < arrival.length && arrival[idx] <= currentTime) {
                    q.offer(new Process(arrival[idx], run[idx]));
                    idx++;
                }

                //put cur process to the end of the queue if not done
                if(cur.executeTime  > quantum) {
                    cur.executeTime -= quantum;
                    cur.arrivalTime = currentTime; //since it has a new arrival time in the q
                    q.offer(cur);
                }
            }
            else {
                //put a process into the q and update the current time
                Process p = new Process(arrival[idx], run[idx]);
                q.offer(p);
                currentTime = arrival[idx]; //this is where I had the bug as currentTime = run[idx]
                idx++;
                
            }
        }
        return (float) waitTime / arrival.length;
    }

    public static void main(String[] args) { 
        int[] arrival1 = {0, 1, 4}; 
        int[] run1 = {5, 2, 3}; 
        
        int q1 = 3; 
        int[] arrival2 = {0, 1, 3, 9}; 
        
        int[] run2 = {2, 1, 7, 5}; 
        int q2 = 2; 
        
        System.out.println("Average Waiting Time RoundRobin: " + waitingTimeRobin(arrival2, run2, q2)); 
    }
}

//Class that holds the arrival time and running time/execute/burst time
class Process {
    int arrivalTime;
    int executeTime;
    
    public Process(int arrivalTime, int executeTime) {
        this.arrivalTime = arrivalTime;
        this.executeTime = executeTime;
    }
}