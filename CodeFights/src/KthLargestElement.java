import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by Tien on 11/15/2017.
 */
public class KthLargestElement {
    /**
     * Find the kth largest element in an unsorted array. This will be the kth largest element in sorted order, not the kth distinct element.

     Example

     For nums = [7, 6, 5, 4, 3, 2, 1] and k = 2, the output should be
     kthLargestElement(nums, k) = 6;
     For nums = [99, 99] and k = 1, the output should be
     kthLargestElement(nums, k) = 99.
     * @param nums
     * @param k
     * @return
     */
    public static int kthLargestElement(int[] nums, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            //System.out.println("add: "+nums[i]);
            priorityQueue.offer(nums[i]);
            if(priorityQueue.size() > k)
               priorityQueue.poll();
        }
        /*
        Iterator i = priorityQueue.iterator();
        System.out.print("queue: ");
        while(i.hasNext()){
            System.out.print(i.next() + " ");
        }
        System.out.println();
        */
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 6, 5, 4, 3, 2, 1},
                nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};

        System.out.println(kthLargestElement(nums1,2));
        System.out.println(kthLargestElement(nums2,5));
    }
}
