package assignment2;

public class HeapOfBinaryTries {
    private BinaryTrie[] A;
    private int heapsize;

    /*
     * left = 2i
     * right = 2i + 1
     * parent = i / 2
     */

    private void heapify(int i) {
        int size = A.length;
        int leftChild, rightChild, smallestIndex;

        while (true) {
            int start = 2 * i;
            leftChild = start;
            rightChild = start + 1;
            smallestIndex = i;

            // Use compare method to compare elements
            if (leftChild < size && A[leftChild].compare(A[smallestIndex])) {
                smallestIndex = leftChild;
            }

            if (rightChild < size && A[rightChild].compare(A[smallestIndex])) {
                smallestIndex = rightChild;
            }

            if (smallestIndex != i) {
                 // Swap A[i] with A[smallestIndex]
                BinaryTrie temp = A[i];
                A[i] = A[smallestIndex];
                A[smallestIndex] = temp;
    
                // Move down the tree
                i = smallestIndex;
            }
            break; // The heap property is satisfied

           
        }
    }

    public HeapOfBinaryTries(BinaryTrie[] A) {
        this.A = A;
        this.heapsize = A.length;
        for (int i = (heapsize / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public BinaryTrie extractMin()
    {
        // TASK 3.A.c
        
        if (heapsize == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        
        BinaryTrie min = A[0]; // Root value is the minimum
        A[0] = A[heapsize - 1]; // Swap the last element to root
        heapsize--; // Reduce heap size
        heapify(0); // Re-heapify the root
        return min;
    }

    public void insert(BinaryTrie x) {
        // Increment the size of the heap
        // Ensure there is enough space for the new element
        if (heapsize >= A.length) {
            // Expand the array if needed
            BinaryTrie[] newArray = new BinaryTrie[A.length * 2];
            System.arraycopy(A, 0, newArray, 0, A.length);
            A = newArray;
        }
        
        heapsize++; // Increment the size of the heap
        
        // Bubble up to maintain the heap property
        int i = heapsize - 1; // Start from the last index
        while (i > 0 && A[i].compare(A[(i - 1) / 2])) { // Check parent
            A[i] = A[(i - 1) / 2];
            // Move up in the tree
            i = (i - 1) / 2; // Move to parent
        }
        // Place the new element at the end of the heap
        A[i] = x;
    }

    public int size()
    {
        return heapsize;
    }
}
