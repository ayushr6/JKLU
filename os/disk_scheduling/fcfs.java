package os.disk_scheduling;

public class fcfs {
    public static void main(String args[]) {
        // {98,183,37,122,14,124,65,67} head=53, ans=640
        // {3,6,10,7} head=2, ans=17
        int request_q[] = { 3, 6, 1, 0, 7 };
        int head_start = 2;
        int tsd = Math.abs(head_start - request_q[0]);
        for (int i = 1; i < request_q.length; i++)
            tsd += Math.abs(request_q[i] - request_q[i - 1]);
        System.out.println("Total Seek Distance: " + tsd);
    }
}
