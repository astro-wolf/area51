package problems.heap;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 29/09/20 23:38
 */
public class PairHeap {

    private PairHeapNode[] heap;
    int size;
    int count = 0;

    public PairHeap(int size) {
        this.size = size;
        heap = new PairHeapNode[size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * At this moment, there's no check for validity of index.
     * This also assumes that indices sent will be unique.
     * Weights can be equal.
     *
     * @param index index of node in vertices array in {@link problems.graph.Graph}
     * @param weight total weight of path from source vertex to this vertex
     * @return true if node was added, false otherwise
     */
    public boolean add(int index, int weight) {
        if (count == size)
            return false;
        PairHeapNode newNode = new PairHeapNode(index, weight);
        heap[count++] = newNode;
        percolateUp(count - 1);
        return true;
    }

    public PairHeapNode getMin() {
        if (count == -1)
            return null;
        PairHeapNode temp = heap[0];
        heap[0] = heap[--count];
        percolateDown(0);
        return temp;
    }

    public boolean update(int index, int weight) {
        int i = 0;
        boolean found = false;
        for (; i < count; i++) {
            if (heap[i].index == index) {
                found = true;
                break;
            }
        }
        if (!found)
            return false;
        heap[i].weight = weight;
        int parent = Math.max(0, (i / 2) - 1);
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;
        if (heap[i].weight < heap[parent].weight)
            percolateUp(i);
        else if ((validIndex(left) && heap[i].weight > heap[left].weight)
                || (validIndex(right) && heap[i].weight > heap[right].weight))
            percolateDown(i);
        return true;
    }

    private void percolateDown(int i) {
        if (i * 2 + 1 < count) {
            int minIdx = -1;
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (heap[left].weight < heap[i].weight)
                minIdx = left;
            if (right < count
                    && heap[right].weight < heap[left].weight)
                minIdx = right;
            if (minIdx != -1) {
                swap(i, minIdx);
                percolateDown(minIdx);
            }
        }
    }

    private boolean validIndex(int i) {
        return i >= 0 && i < count;
    }

    private void percolateUp(int i) {
        int parent = Math.max(0, i / 2 - 1);
        if (i > 0
                && parent >= 0
                && parent < count
                && heap[i].weight < heap[parent].weight) {
            swap(i, parent);
            percolateUp(parent);
        }
    }

    private void swap(int i, int otherI) {
        PairHeapNode temp = heap[i];
        heap[i] = heap[otherI];
        heap[otherI] = temp;
    }
}
