package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tien on 11/14/2017.
 */
public class ComposeRanges {

    //O(n) Time complexity
    public static String[] composeRanges1(int[] nums) {
        List<String> l = new ArrayList<>();
        int start;

        for(int i = 0; i < nums.length; i++) {
            start = i;
            while(i < nums.length-1 && nums[i+1] - nums[i] == 1) {
                i++;
            }

            if (start == i)
                l.add(nums[i] +"");
            else
                l.add(nums[start] + "->"+nums[i]);
        }

        return l.toArray(new String[0]);
    }

    //Using Stack - Messy solution but it works LOL
    public static String[] composeRanges2(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        List<String> l = new ArrayList<>();

        int i = 0;
        int count = 0;
        while(i < nums.length) {
            if(stack.isEmpty()) {
                if(i == nums.length-1){
                    l.add(nums[i++] + "");
                }else {
                    stack.push(nums[i++]);
                    count++;
                }
            } else {
                if(i == nums.length - 1){
                    if(nums[i] - stack.peek() == 1) {

                        int end = nums[i++];

                        while (count > 1) {
                            stack.pop();
                            count--;
                        }

                        int start = stack.pop();
                        if (start != end) {
                            l.add(start + "->" + end);
                        } else {
                            l.add(start + "");
                        }
                    } else {
                        int end = stack.peek();

                        while (count > 1) {
                            stack.pop();
                            count--;
                        }
                        int start = stack.pop();
                        if (start != end) {
                            l.add(start + "->" + end);
                        } else {
                            l.add(start + "");
                        }

                        l.add(nums[i++] + "");
                    }
                } else {
                    if (nums[i] - stack.peek() == 1) {
                        stack.push(nums[i++]);
                        count++;
                    } else {
                        int start;
                        int end = stack.peek();

                        while (count > 1) {
                            stack.pop();
                            count--;
                        }
                        start = stack.pop();
                        count--;

                        if (start != end) {
                            l.add(start + "->" + end);
                        } else {
                            l.add(start + "");
                        }
                    }
                }
            }
        }
        return l.toArray(new String[0]);
    }

    //Using List
    public static String[] composeRanges3(int[] nums) {
        List<String> l = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();


        for(int i = 0 ; i < nums.length; i++){
            if(integerList.isEmpty()) {
                if(i == nums.length-1)
                    l.add(nums[i]+"");
                else
                    integerList.add(nums[i]);
            } else {
                if (i == nums.length-1){
                    if(nums[i] - integerList.get(integerList.size()-1) == 1)
                        l.add(integerList.get(0) + "->" + nums[i]);
                    else {
                        if(integerList.size() == 1) {
                            l.add(integerList.get(0) + "");
                            l.add(nums[i] + "");
                        } else {
                            l.add(integerList.get(0) + "->"+ integerList.get(integerList.size()-1));
                            l.add(nums[i] + "");
                        }
                    }
                    integerList.clear();
                } else if(nums[i] - integerList.get(integerList.size()-1) == 1){
                    integerList.add(nums[i]);
                } else {
                    if (integerList.size() == 1)
                        l.add(integerList.get(0) +"");
                    else
                        l.add(integerList.get(0) + "->"+ integerList.get(integerList.size()-1));
                    integerList.clear();
                    integerList.add(nums[i]);
                }
            }
        }

        return l.toArray(new String[0]);
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, 5, 6, 7, 9, 10,11,12,13,14, 20, 23, 24, 25, 26, 30, 32,33,34};
        int[] nums2 = {0,3,4,5};
        int[] nums3 = {1,2,3,4,5};
        int[] nums4 = {1,4};
        int[] nums5 = {-1,0,1,2,6,7,9};
        int[] nums6 = {1,2};
        System.out.println("nums1: "+ Arrays.toString(nums1));
        System.out.println("nums2: "+ Arrays.toString(nums2));
        System.out.println("nums3: "+ Arrays.toString(nums3));
        System.out.println("nums4: "+ Arrays.toString(nums4));

        System.out.println();
        long startTime1 = System.currentTimeMillis();
        System.out.println("ComposeRanges1 "+Arrays.toString(composeRanges1(nums1)));
        long endTime1  = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;

        System.out.println();
        long startTime2 = System.currentTimeMillis();
        System.out.println("ComposeRanges2 "+Arrays.toString(composeRanges2(nums1)));
        long endTime2  = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;

        System.out.println("runtime1: "+totalTime1+", runtime2: "+ totalTime2);

        System.out.println();
        System.out.println("ComposeRanges1 "+Arrays.toString(composeRanges1(nums2)));
        System.out.println("ComposeRanges1 "+Arrays.toString(composeRanges1(nums3)));
        System.out.println("ComposeRanges1 "+Arrays.toString(composeRanges1(nums4)));

        System.out.println("ComposeRanges2 "+Arrays.toString(composeRanges2(nums2)));
        System.out.println("ComposeRanges2 "+Arrays.toString(composeRanges2(nums3)));
        System.out.println("ComposeRanges2 "+Arrays.toString(composeRanges2(nums4)));

        System.out.println();
        System.out.println("ComposeRanges3 "+Arrays.toString(composeRanges3(nums5)));
    }
}
