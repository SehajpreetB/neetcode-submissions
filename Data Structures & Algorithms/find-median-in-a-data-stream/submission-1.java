class MedianFinder {
    PriorityQueue<Integer> right=new PriorityQueue<>();
    PriorityQueue<Integer> left=
        new PriorityQueue<>((a,b)->(b-a));
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());

        if (right.size() > left.size() + 1) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if((left.size()+right.size())%2==1){
            return (double) right.peek();
        }
        else return (double)(left.peek()+right.peek())/2;
    }
}
