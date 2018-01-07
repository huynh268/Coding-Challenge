package HeapStackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tien on 1/7/2018.
 *
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue),
 as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackusingQueues225 {

    class MyStack1 {

        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack1() {
            this.queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            for(int i = 0; i < queue.size()-1; i++) {
                queue.add(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    class MyStack2 {

        private Queue<Integer> q1, q2;
        /** Initialize your data structure here. */
        public MyStack2() {
            this.q1 = new LinkedList<>();
            this.q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if(q2.isEmpty()) {
                q2.add(x);
                while (!q1.isEmpty())
                    q2.add(q1.poll());
            } else {
                q1.add(x);
                while (!q2.isEmpty())
                    q1.add(q2.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if(q1.isEmpty())
                return q2.poll();
            else
                return q1.poll();
        }

        /** Get the top element. */
        public int top() {
            if(q1.isEmpty())
                return q2.peek();
            else
                return q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
