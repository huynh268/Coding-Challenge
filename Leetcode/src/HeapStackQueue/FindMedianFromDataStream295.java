package HeapStackQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Tien on 9/9/2018.
 *
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 For example,
 [2,3,4], the median is 3
 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.


 Example:
 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2


 Follow up:
 If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

 */
public class FindMedianFromDataStream295 {

    public class MedianFinder {

        private PriorityQueue<Integer> minHeap; //Holds larger elements of stream
        private PriorityQueue<Integer> maxHeap; //Holds smaller elements of stream

        public MedianFinder() {
            this.minHeap = new PriorityQueue(Collections.reverseOrder());
            this.maxHeap = new PriorityQueue();
        }

        /**
         * Time complexity: O(5*logn) = O(logn), the worst case: 3 insertions and 2 deletions each takes O(logn)
         * Space complexity: O(n)
         * @param num
         */
        public void addNum(int num) {
            maxHeap.offer(num); //O(logn)
            minHeap.offer((maxHeap.poll()));//O(logn) + O(logn)

            //Keep size of maxHeap larger or equal minHeap
            if(maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());//O(logn) + O(logn)
            }
        }

        /**
         * Time complexity: O(1)
         * Space complexity: O(1)
         * @return
         */
        public double findMedian() {
            //If maxHeap's size > minHeap's size, the median is the peek of maxHeap
            //Else both heaps have the same number of elements, the median is the average of peeks
            return minHeap.size() < maxHeap.size() ? maxHeap.peek() : (minHeap.peek() + maxHeap.peek()) * 0.5;
        }
    }
}
