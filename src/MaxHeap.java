import java.util.Arrays;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }


    // build a heap based on data
    // to be implemented in O(NlogN)
    public void MaxHeapNLogN(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            add(data[i]);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        //Transfer all the data into our heap
        //Call heap down for the nodes that have children.
        this.data = Arrays.copyOf(data, data.length);
        this.size = data.length;
        int lastParent = (size - 2) / 2;
        for (int i = lastParent; i >= 0; i--) {
            heapDown(i);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        if (size >= data.length) {
            return false;
        }
        data[size] = item;
        size++;
        heapUp(size - 1);

        return true;
    }


    // return the max item in the heap
    public Integer get() {
        if (size <= 0) {
            return null;
        }
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        if (size <= 0) {
            return null;
        }
        int max = data[0];
        data[0] = data[size - 1];
        heapDown(0);
        size--;
        return max;
    }

    private void heapUp(int n) {

        if (n == 0) return;
        Integer parent = (n - 1) / 2;
        if (data[n] > data[parent]) {          //This means the child node is larger than the parent
            //Swap
            Swap(n, parent);
            heapUp(parent);
        }

    }

    private void heapDown(int n) {

        if (n == size) return;

        Integer left = 2 * n + 1;
        Integer right = 2 * n + 2;
        if (right <= size - 1) {
            if (data[n] < data[left]) {                //Compare parent with left child
                if (data[left] >= data[right]) {            //Compare left and right child.
                    //Swap
                    Swap(n, left);
                    heapDown(left);

                } else {                              //Right is larger than left
                    //Swap
                    Swap(n, right);
                    heapDown(right);

                }
            } else if (data[n] < data[right]) {    //If node is less than just the right child.
                //Swap
                Swap(n, right);
                heapDown(right);

            }
        }
    }


    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str = str + data[i] + ", ";

        }
        return str;
    }

    public void Swap(Integer i, Integer j) {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public boolean Equals(Integer[] data) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] != data[i]) return false;
        }
        return true;
    }

    public boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
}

