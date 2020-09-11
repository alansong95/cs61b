public class LinkedListDeque<T> {
    private class Node {
        public Node prev;
        public Node next;
        public T item;

        public Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }

    private Node sentinel;
    private Node last;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new Node(null);
        this.last = this.sentinel;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node firstNode = this.sentinel.next;
        Node newNode = new Node(item);

        this.sentinel.next = newNode;
        newNode.prev = this.sentinel;

        newNode.next = firstNode;
        if (firstNode != null) {
            firstNode.prev = newNode;
        } else {
            newNode.next = this.sentinel;
            this.last = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item);
        this.last.next = newNode;
        newNode.prev = this.last;
        this.last = newNode;
        newNode.next = this.sentinel;

        size++;
    }

    public void printDeque() {
        Node ptr = this.sentinel;
        while(ptr.next != this.sentinel) {
            ptr = ptr.next;
            System.out.print(ptr.item + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        Node first = this.sentinel.next;
        if (first != null) {

            if (first.next != this.sentinel) {
                this.sentinel.next = first.next;
                first.next.prev = this.sentinel;
            } else {
                this.sentinel.next = null;
                this.last = this.sentinel;
            }
            size--;
            return first.item;
        } else {
            return null;
        }
    }

    public T removeLast() {
        Node last = this.last;
        if (last != null) {
            if (last.prev == this.sentinel) {
                this.last = this.sentinel;
                this.sentinel.next = null;
            } else {
                last.prev.next = this.sentinel;
                this.last = last.prev;
            }
            size--;
            return last.item;
        } else {
            return null;
        }
    }

    public T get(int index) {
        Node ptr = this.sentinel;

        int i = 0;
        while (ptr.next != null) {
            ptr = ptr.next;
            if (i == index) {
                return ptr.item;
            }
            i++;
        }
        return null;
    }

    public T getRecursive(int index) {
        return get(index);
    }
}
