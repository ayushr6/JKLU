import java.util.*;

public class rr {

    public static Queue update_q(int n, int time_q, int arrival[], int burst_time[], int time_s, int process, Queue q){
        int i=process+1;
        while(i!=process){
            if(burst_time[i]<=time_s) q.add(i);
            i+=1;
            if(i==n) i=0;
        }
        return q;
    }

    public static int[] calc_wait_time(int n, int time_q, int arrival[], int burst_time[]){
        Queue<Integer> q = new LinkedList<>();
        int wait_time[] = new int[n];
        wait_time[0] = arrival[0];

        return wait_time;
    }


    public static void main(String args[]){
        int arrival[] = { 1, 2, 3 };
        int n = arrival.length;
        int burst_time[] = { 10, 5, 8 };
        int time_q = 2;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arrival[j]<arrival[i]){
                    int temp = arrival[j];
                    arrival[j] = arrival[i];
                    arrival[i] = temp;
                    temp = burst_time[j];
                    burst_time[j] = burst_time[i];
                    burst_time[i] = temp;
                }
            }
        }


    }
}
