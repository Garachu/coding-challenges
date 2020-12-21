package educative.two_heaps;


import java.util.PriorityQueue;

/**
 * Problem Statement #
 * Design a class to calculate the median of a number stream. The class should have the following two methods:
 * 1. insertNum(int num): stores the number in the class
 * 2. findMedian(): returns the median of all numbers inserted in the class
 * If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
 * <p>
 * Solution
 */
public class MedianOfAStream {

    // for max heap items are ordered in descending order
    PriorityQueue<Integer> maxHeap;

    // for min heap items are ordered in ascending order
    PriorityQueue<Integer> minHeap;

    public MedianOfAStream() {
        // for max heap items are ordered in descending order
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        // for min heap items are ordered in ascending order
        minHeap = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void insertNum(int num) {

        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size() + 1) {
            return maxHeap.peek();
        }

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() / 2.0) + (minHeap.peek() / 2.0);
        }
        return -1;
    }

    /**
     * The time complexity of the insertNum() will be O(logN) due to the insertion in the heap.
     * The time complexity of the findMedian() will be O(1) as we can find the median from the top elements of the heaps.
     * The space complexity will be O(N) because, as at any time, we will be storing all the numbers.
     */
    public static void main(String args[]) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);

        // output: 2
        System.out.println("The median is: " + medianOfAStream.findMedian());
        System.out.println(medianOfAStream.maxHeap.peek());
        System.out.println(medianOfAStream.minHeap.peek());

        medianOfAStream.insertNum(5);

        // output: 3
        System.out.println("The median is: " + medianOfAStream.findMedian());
        System.out.println(medianOfAStream.maxHeap);
        System.out.println(medianOfAStream.minHeap);

        medianOfAStream.insertNum(4);

        // output: 3.5
        System.out.println("The median is: " + medianOfAStream.findMedian());
        System.out.println(medianOfAStream.maxHeap);
        System.out.println(medianOfAStream.minHeap);
    }
}
