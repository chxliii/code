class Mydequeue {
    private int capacity;

    private int[] ele;

    private int front;

    private int rear;

    public Mydequeue(int k) {
        //多留一个位置
        capacity = k + 1;

        ele = new int[capacity];

        front = 0;

        rear = 0;
    }


    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        //从头步插入的时候front要 --， 同时需要取模
        front = (front - 1 + capacity) % capacity;

        ele[front] =  value;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        ele[rear] = value;

        rear = (rear + 1) % capacity;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;

        return true;

    }

    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }

        rear = (rear - 1 + capacity) % capacity;

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return ele[front];
    }

    public int getLast() {
        if (isEmpty()) {
            return -1;
        }

        return ele[(rear - 1 + capacity) % capacity];
    }

    public boolean isFull() {
        if((rear + 1) % capacity == front) {
            return true;
        }

        return false;
    }


    public boolean isEmpty() {
        return front == rear;
    }
}

public class design_circular_deque  {

    public static void main(String[] args) {

        Mydequeue dq = new Mydequeue(8);

        dq.insertLast(1);

        dq.insertLast(2);

        dq.insertLast(3);

        dq.insertFront(7);

        System.out.println(dq.getFront());

        dq.deleteLast();

        dq.insertLast(-1);

        System.out.println(dq.getLast());

        dq.insertFront(5);

        System.out.println(dq.getFront());

        dq.deleteFront();

        System.out.println(dq.getFront());
    }

}
