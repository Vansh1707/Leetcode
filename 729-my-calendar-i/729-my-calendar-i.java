class MyCalendar {
    List<int[]> booking;

    public MyCalendar() {
        booking = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for (int[] prevbook: booking) {
            if (prevbook[0] < end && start < prevbook[1]) {
                return false;
            }
        }
        booking.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */