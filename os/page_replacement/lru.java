package os.page_replacement;

import java.util.*;

public class lru {

    public static void lru_page_replace(int page_order[], int page_frame) {
        LinkedList<Integer> lru_list = new LinkedList<Integer>();
        double hits = 0, miss = 0, deci = 100.0;
        int n = page_order.length;
        System.out.println("---------------------------");
        for (int i = 0; i < n; i++) {
            int ele = page_order[i];
            int index = lru_list.indexOf(ele);
            System.out.println("Element: " + ele);
            if (lru_list.isEmpty() || lru_list.size() < page_frame) {
                lru_list.add(0, ele);
                System.out.println("Element added: " + ele);
            } else if (index != -1) {
                lru_list.remove(index);
                lru_list.add(0, ele);
                System.out.println("Hit: " + ele);
                hits += 1;
            } else {
                System.out.println("Element removed: " + lru_list.remove(lru_list.size() - 1));
                lru_list.add(0, ele);
                System.out.println("Element added: " + ele);
            }
            System.out.println("Queue: " + lru_list);
            System.out.println("---------------------------");
        }
        miss = n - hits;
        System.out.println("\nHit Ratio: " + (int) hits + "/" + n + " = " + Math.round((hits / n) * deci) / deci);
        System.out.println("Miss Ratio: " + (int) miss + "/" + n + " = " + Math.round((miss / n) * deci) / deci);
        System.out.println("\n---------------------------");
    }

    public static void main(String args[]) {
        int page_order[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 3 };
        int page_frame = 4;
        lru_page_replace(page_order, page_frame);
    }
}
