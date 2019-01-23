
package heap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


class BinaryHeap {

    /**
     * The number of children each node has *
     */
    private static final int d = 2;
    public int size;
    public int[] heap;
    String name;
    static HashMap<String, BinaryHeap> bhList = new HashMap<>();

    /**
     * Constructor *
     */
    public BinaryHeap(int capacity, String name) {
        this.name = name;
        size = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
        bhList.put(this.name, this);
    }

    public String getName() {
        return name;
    }

    public void sort(int times) {
        Main.writer.println("***Sort " + this.name + "***");
        for (int i = 0; i < times; i++) {
            if(i < 2) {
            Main.writer.print(deleteTop() + ", ");
            }else {
            Main.writer.print(deleteTop());
                    }
        }
        Main.writer.println();
    }

    /**
     * Function to check if heap is empty *
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if heap is full *
     */
    public boolean isFull() {
        return size == heap.length;
    }

    /**
     * Clear heap
     */
    public void makeEmpty() {
        size = 0;
    }

    /* get index parent of i **/
    private int parent(int i) {
        return (i - 1) / d;
    }

    /* get index of k th child of i */
    private int kthChild(int i, int k) {
        return d * i + k;
    }

    /* Function to insert element */
    public void insert(int x) {
        if (isFull()) {
            Main.writer.println("Heap is full!");
        }
        /**
         * Percolate up *
         */
        heap[size++] = x;
        heapifyUp(size - 1);
    }

    /**
     * Function to find least element *
     */
    public int findTop() {
        if (isEmpty()) {
            Main.writer.println("Heap is eampty!");
        }
        return heap[0];
    }

    /**
     * Function to delete min element *
     */
    public int deleteTop() {
        int keyItem = heap[0];
        delete(0);
        return keyItem;
    }

    /**
     * Function to delete element at an index *
     */
    public int delete(int ind) {
        if (isEmpty()) {
            Main.writer.println("Heap is empty!");
        }
        int keyItem = heap[ind];
        for (int i = heap.length - 1; i > 0; i--) {
            if (heap[i] != -1) {
                heap[ind] = heap[i];
                size--;
                heapifyDown(ind);
                break;
            } 
        }
        return keyItem;
    }

    /**
     * Function heapifyUp * Has min and max scenarios
     */
    public void heapifyUp(int childInd) {
        if ("min".equals(Main.cmd.get(1))) {
            int tmp = heap[childInd];
            while (childInd > 0 && tmp < heap[parent(childInd)]) {
                heap[childInd] = heap[parent(childInd)];      //swap parent and child
                childInd = parent(childInd);
            }
            heap[childInd] = tmp;
        } else {
            int tmp = heap[childInd];
            while (childInd < 0 && tmp > heap[parent(childInd)]) {
                heap[childInd] = heap[parent(childInd)];  //swap parent and child
                childInd = parent(childInd);
            }
            heap[childInd] = tmp;
        }
    }

    /**
     * Function heapifyDown * has min and max scenarios
     */
    private void heapifyDown(int ind) {
        int child;
        int tmp = heap[ind];
        if ("min".equals(Main.cmd.get(1))) {

            while (kthChild(ind, 1) < size) {
                child = minChild(ind);
                if (heap[child] < tmp) {
                    heap[ind] = heap[child];
                } else {
                    break;
                }
                ind = child;
            }
            heap[ind] = tmp;

        } else {
            while (kthChild(ind, 1) > size) {
                child = maxChild(ind);
                if (heap[child] > tmp) {
                    heap[ind] = heap[child];
                } else {
                    break;
                }
                ind = child;
            }
            heap[ind] = tmp;
        }
    }

    /**
     * Function to get smallest child *
     */
    private int minChild(int ind) {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < size)) {
            if (heap[pos] < heap[bestChild]) {
                bestChild = pos;
            }
            pos = kthChild(ind, k++);
        }

        return bestChild;
    }

    private int maxChild(int ind) {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k >= d) && (pos > size)) {
            if (heap[pos] > heap[bestChild]) {
                bestChild = pos;
            }
            pos = kthChild(ind, k++);
        }

        return bestChild;
    }

    public void printHeap() {
        /**
         * manipulated the printing of a heap's array so that the last integer
         * didn't have a comma after it
         */
        if (isEmpty()) {
            Main.writer.println("Heap " + this.name + " is empty!");
        } else {
            Main.writer.println("Heap " + getName());
            for (int s = 0; s < heap.length; s++) {

                if (heap[s] != -1) {
                    if (heap[s + 1] == -1) {
                        Main.writer.println(heap[s]);
                        break;
                    }
                    Main.writer.print(heap[s] + ", ");

                }

            }
            Main.writer.println();

        }
    }

    public int[] getHeap() {
        return heap;
    }

    public static BinaryHeap merge(BinaryHeap A, BinaryHeap B, BinaryHeap C) {
        BinaryHeap Z = A;
        if (B != null) {
            for (int i = 0; i < B.heap.length; i++) {
                if (B.heap[i] != -1) {
                    Z.insert(B.heap[i]);
                }
            }
        }
        if (C != null) {
            for (int i = 0; i < B.heap.length; i++) {
                if (C.heap[i] != -1) {
                    Z.insert(C.heap[i]);
                }
            }
        }
        return Z;
    }
}
