public class fcfs {

    public static void print_output(int n, int process[], int burst_time[], int wait_time[], int tat[]) {
        System.out.println("\nProcess\t\t Burst Time\t Wait Time\t Turn Around Time");
        double avg_wt = 0, avg_tat = 0, deci = 100.0;
        for (int i = 0; i < n; i++) {
            avg_wt += wait_time[i];
            avg_tat += tat[i];
            System.out.print(
                    process[i] + "\t\t     " + burst_time[i] + "\t\t     " + wait_time[i] + "\t\t     " + tat[i]);
            System.out.println("\n");
        }
        System.out.println("Average Wait Time: " + Math.round((avg_wt / n) * deci) / deci);
        System.out.println("Average Turn Around Time: " + Math.round((avg_tat / n) * deci) / deci + "\n");
    }

    public static int[] calc_tat(int n, int burst_time[], int wait_time[]) {
        int tat[] = new int[n];

        for (int i = 0; i < n; i++)
            tat[i] = burst_time[i] + wait_time[i];

        return tat;
    }

    public static int[] calc_wait_time(int n, int burst_time[]) {
        int wait_time[] = new int[n];

        wait_time[0] = 0;
        for (int i = 1; i < n; i++)
            wait_time[i] = wait_time[i - 1] + burst_time[i - 1];

        return wait_time;
    }

    public static void main(String args[]) {
        int process[] = { 1, 2, 3 };
        int n = process.length;
        int burst_time[] = { 10, 5, 8 };

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(process[j]<process[i]){
                    int temp = process[j];
                    process[j] = process[i];
                    process[i] = temp;
                    temp = burst_time[j];
                    burst_time[j] = burst_time[i];
                    burst_time[i] = temp;
                }
            }
        }

        int wait_time[] = calc_wait_time(n, burst_time);
        int tat[] = calc_tat(n, burst_time, wait_time);

        print_output(n, process, burst_time, wait_time, tat);
    }
}
