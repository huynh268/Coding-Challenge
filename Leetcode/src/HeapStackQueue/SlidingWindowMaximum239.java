package HeapStackQueue;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

 Example:

 Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 Output: [3,3,5,5,6,7]
 Explanation:

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Note:
 You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?
 */

public class SlidingWindowMaximum239 {

    /**
     * Priority Queue
     *
     * Time complexity: O(nlogk) -  add element to prioriy queue(max heap) take O(logk), there are n nums
     * Space complexity: O(n-k+1) = O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(k == 1 || nums.length < 2) return nums;
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int i = 0; i < k; i++) priorityQueue.add(nums[i]);
        ans[0] = priorityQueue.peek();

        int j = 1;
        for(int i = k; i < nums.length; i++) {
            priorityQueue.remove(nums[i-k]);
            priorityQueue.add(nums[i]);
            ans[j++] = priorityQueue.peek();
        }

        return ans;
    }

    /**
     * Monotonic queue
     *
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(k == 1 || nums.length < 2) return nums;
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new Deque<>();

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            // Remove elements not in the current window
            while(!deque.isEmpty() && deque.peek() <= i - k) deque.poll();

            // Remove useless elements which cannot be the max
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();

            deque.offer(i);

            if(i >= k-1) {
                ans[j++] = nums[deque.peek()];
            }
        }

        return ans;
    }
}
