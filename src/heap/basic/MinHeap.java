package heap.basic;

public class MinHeap {

    int[] harr;
    int capacity;
    int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    //Function to extract minimum value in heap and then to store
    //next minimum value at first index.
    int extractMin()
    {
        // Your code here.
        if (heap_size==0) return -1;
        if (heap_size==1) {
            heap_size--;
            return harr[0];
        }
        heap_size--;
        int temp = harr[heap_size];
        harr[heap_size] = harr[0];
        harr[0] = temp;
        MinHeapify(0);
        return harr[heap_size];
    }

    //Function to insert a value in Heap.
    void insertKey(int k)
    {
        // insert at end to maintain complete heap prop
        heap_size+=1;
        harr[heap_size-1]  = k;
        int i = heap_size-1;
        while(harr[parent(i)] > harr[i] && i>0){
            int parenti = parent(i);
            int temp = harr[i];
            harr[i] = harr[parenti];
            harr[parenti] = temp;
            i = parenti;
        }

    }

    //Function to delete a key at ith index.
    void deleteKey(int i)
    {
        // Your code here.
        if (i>heap_size-1) return;
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val)
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;
        if(left<heap_size && harr[left] < harr[smallest]) smallest = left;
        if(right<heap_size && harr[right] < harr[smallest]) smallest = right;
        if(smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
