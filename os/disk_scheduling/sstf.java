package os.disk_scheduling;

import java.util.*;

import java.util.Arrays;

public class sstf {
    public static void main(String args[]){
        int[] queue = {98,183,37,122,14,124,65,67};
        int header = 53, l=queue.length;
        Arrays.sort(queue);
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for(int i=0;i<l;i++) ll.add(queue[i]);
        int sst=0, temp=Integer.MAX_VALUE, index=0, next=0, diff=0;
        boolean flag=false;
        for(int i=0;i<l;i++){
            diff = Math.abs(ll.get(i)-header);
            if(diff<=temp) {
                temp = diff;
                flag=true;
                index=i;
            }
            else{
                if(flag) break;
            }
        }
        sst+=temp;
        int val = ll.get(index);
        ll.remove(index);
        int i=0, j=0;
        System.out.print(sst+" ");
        while(i<ll.size()){
            temp=Integer.MAX_VALUE;
            j=0;
            while(j<ll.size()){
                diff = Math.abs(val-ll.get(j));
                if(diff<=temp){
                    temp=diff;
                    index=j;
                    flag=true;
                }else{
                    if(flag) break;
                }
                System.out.print(temp+" ");
                sst+=temp;
                val=ll.get(index);
                ll.remove(index);
                j+=1;
            }
            i+=1;
        }
        System.out.println();
        System.out.println(sst);
    }
}
