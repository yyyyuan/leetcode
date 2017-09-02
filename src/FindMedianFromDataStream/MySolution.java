class MedianFinder {

    PriorityQueue<Integer> minHeap, maxHeap;
    int sizeMin, sizeMax;
    int firstMid, secondMid;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        sizeMin = 0;
        sizeMax = 0;
    }
    
    public void addNum(int num) {
        if (sizeMin == 0) {
            minHeap.offer(num);
            sizeMin++;
            return;
        }
        
        if (sizeMin == sizeMax) {
            firstMid = maxHeap.peek(); 
            if (num >= firstMid) {
                minHeap.offer(num);
                sizeMin++;
            }
            else {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
                sizeMin++;
            }
        }
        else {
            secondMid = minHeap.peek();
            if (num >= secondMid) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
                sizeMax++;
            }
            else {
                maxHeap.offer(num);
                sizeMax++;
            }
        }
    }
    
    public double findMedian() {
        if (sizeMin == sizeMax) {
            firstMid = maxHeap.peek();
            secondMid = minHeap.peek();
            return ((double)firstMid + (double)secondMid) / 2;
        }
        else return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
