package F.com.anup.algorithms.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Given a list of numbers, the task is to insert these numbers into a stream and find the median of
 *  the stream after each insertion. If the median is a non-integer, consider it’s floor value.

The median of a sorted array is defined as the middle element when the number of elements is odd 
and the mean of the middle two elements when the number of elements is even.

Example
{
"stream": [3, 8, 5, 2]
}
Output:

[3, 5, 5, 4]
Iteration	Stream	Sorted Stream	Median
1	[3]	[3]	3
2	[3, 8]	[3, 8]	(3 + 8) / 2 => 5
3	[3, 8, 5]	[3, 5, 8]	5
4	[3, 8, 5, 2]	[2, 3, 5, 8]	(3 + 5) / 2 => 4
Notes
Constraints:

1 <= length of stream <= 105
1 <= any value in the stream <= 105
The stream can contain duplicates.*/
public class OnlineMedian {

    static ArrayList<Integer> online_median(ArrayList<Integer> stream) {
        if (stream == null || stream.size() <= 1) return stream;
        ArrayList<Integer> result = new ArrayList<>(stream.size());

        //1. MIn Heap and MaxHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();// // To store the larger half of the input numbers.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());// // To store the smaller half of the input numbers.
        
        
        //2. balance the heap while adding num
        
        // Balancing heaps to make sure
        // - smaller half of input numbers are always in the max heap
        // - larger half of input numbers are always in the min heap
        for (int num : stream) {
            if (maxHeap.isEmpty()) {
                maxHeap.offer(num);
            } else if (maxHeap.peek() >= num) {//add num to top of maxHeap if num is smaller than top of maxHeap
            	   maxHeap.offer(num);
                if (maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());//add to minHeap if minHeap size is smaller
             
            } else {/////add num to top of minHeap if num is larger than top of maxHeap
                minHeap.offer(num);
                if (minHeap.size() > maxHeap.size() + 1) maxHeap.offer(minHeap.poll());// add to maxHeap if maxHeap size is smaller
            }
            
            
            //3. calculate the median
            if (minHeap.size() > maxHeap.size())
                result.add(minHeap.peek());//add the larger size one
            
            else if (maxHeap.size() > minHeap.size())
                result.add(maxHeap.peek());//add the larger size one
            
            else   // If number of elements in the stream is even.
                result.add((minHeap.peek() + maxHeap.peek())/2);
        }        
        
        return result;
    }
}


/*
 * The median of an array can be computed only when the array is sorted. To add
 * an element from the stream, we need to maintain a sorted array, and adding an
 * element in the sorted array requires O(size_of_sorted_array) time. As we need
 * only the middle element/s, this complexity can be improved by using a
 * min-heap and a max-heap.
 * 
 * The min-heap will store the larger half of the stream and the max-heap will
 * store the lower half of the sorted stream.
 * 
 * For every element that is added from the stream, we keep the sizes of the
 * heaps the same or they differ maximum by 1. Without the loss of generality,we
 * will have the extra element in max-heap whenever required.
 * 
 * This way, if the total size of the stream is odd, the element on top of the
 * max-heap is our median, else the floor of the average of the elements on the
 * top of the min-heap and the max-heap is our required value.
 */

