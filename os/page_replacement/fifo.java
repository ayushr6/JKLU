package os.page_replacement;

import java.util.*;

public class fifo {

    public static void fifo_page_replace(int page_order[], int page_frame) {
        Queue<Integer> fifo_q = new LinkedList<Integer>();
        double hits = 0, miss = 0, deci = 100.0;
        int n = page_order.length;
        System.out.println("---------------------------");
        for (int i = 0; i < n; i++) {
            int ele = page_order[i];
            System.out.println("Element: " + ele);
            if (fifo_q.contains(ele)) {
                System.out.println("Hit: " + ele);
                hits += 1;
            } else if (fifo_q.isEmpty() || fifo_q.size() < page_frame) {
                fifo_q.add(ele);
                System.out.println("Element added: " + ele);
            } else {
                System.out.println("Element removed: " + fifo_q.remove());
                fifo_q.add(ele);
                System.out.println("Element added: " + ele);
            }
            System.out.println("Queue: " + fifo_q);
            System.out.println("---------------------------");
        }
        miss = n - hits;
        System.out.println("\nHit Ratio: " + (int) hits + "/" + n + " = " + Math.round((hits / n) * deci) / deci);
        System.out.println("Miss Ratio: " + (int) miss + "/" + n + " = " + Math.round((miss / n) * deci) / deci);
        System.out.println("\n---------------------------");
    }

    public static void main(String args[]) {
        int page_order[] = { 1, 3, 0, 3, 5, 6, 3 };
        int page_frame = 3;
        fifo_page_replace(page_order, page_frame);
    }
}
