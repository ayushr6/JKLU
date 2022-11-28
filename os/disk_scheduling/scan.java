package os.disk_scheduling;

import java.util.*;

public class scan {
    public static void main(String args[]){
        int[] queue = { 98, 183, 37, 122, 14, 124, 65, 67 };
        int header = 53, l = queue.length;
        int scan=0, index=1, temp=Integer.MAX_VALUE;
        Arrays.sort(queue);
        for(int k=0;k<l;k++) System.out.print(queue[k]+" ");
        System.out.println();
        int diff = 0;
        while(index<l && diff<=temp){
            temp = diff;
            diff = Math.abs(header-queue[index]);
            index+=1;
        }
        index-=1;
        scan+=Math.abs(header-queue[index]);
        int i=index;
        while(i>0){
            scan+=Math.abs(queue[i-1]-queue[i]);
            i-=1;
        }
        scan+=queue[0];
        index+=1;
        scan+=queue[index];

        while(index<l-1){
            scan+=Math.abs(queue[index]-queue[index+1]);
            index+=1;
        }
        System.out.println("scan: "+scan);
    }
}
