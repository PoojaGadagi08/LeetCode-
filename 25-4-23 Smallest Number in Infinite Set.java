// You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

// Implement the SmallestInfiniteSet class:

// SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
// int popSmallest() Removes and returns the smallest integer contained in the infinite set.
// void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.





import java.util.*;

class SmallestInfiniteSet {
    private int minNum = 1;
    private PriorityQueue<Integer> heap = new PriorityQueue<>();

    public int popSmallest() {
        if (!heap.isEmpty()) {
            return heap.poll();
        }
        minNum++;
        return minNum - 1;
    }

    public void addBack(int num) {
        if (minNum > num && !heap.contains(num)) {
            heap.offer(num);
        }
    }
}

