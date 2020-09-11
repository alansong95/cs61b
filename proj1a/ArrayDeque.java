public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.nextFirst = this.items.length / 2 - 1;
        this.nextLast = this.items.length / 2;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // resize needed
    public void addFirst(T item) {
        if (this.size == this.items.length) {
            sizeUp();
        }

        this.items[nextFirst] = item;
        this.nextFirst--;
        this.size++;
        if (this.nextFirst < 0) {
            this.nextFirst = this.items.length - 1;
        }
    }

    private void sizeUp() {
        T[] temp = (T[]) new Object[this.items.length * 2];
        int startIndex = temp.length / 4;
        for (int i = nextLast; i < this.items.length; i++) {
            temp[startIndex] = this.items[i];
            startIndex++;
        }

        for (int i = 0; i < nextLast; i++) {
            temp[startIndex] = this.items[i];
            startIndex++;
        }

        this.items = temp;
        this.nextFirst = temp.length / 4 - 1;
        this.nextLast = temp.length / 4 * 3;
    }

    private void sizeDown() {
        T[] temp = (T[]) new Object[this.items.length / 2];
        int startIndex = temp.length / 4;

        if (nextFirst < nextLast) {
            for (int i = nextFirst + 1; i < nextLast; i++ ){
                temp[startIndex] = this.items[i];
                startIndex++;
            }
        } else{
            for (int i = nextFirst + 1; i < this.items.length; i++) {
                temp[startIndex] = this.items[i];
                startIndex++;
            }

            for (int i = 0; i < nextLast; i++) {
                temp[startIndex] = this.items[i];
                startIndex++;
            }
        }
        this.items = temp;
        this.nextFirst = temp.length / 4 - 1;
        this.nextLast = temp.length / 4 * 3;
    }

    public void addLast(T item) {
        if (this.size == this.items.length) {
            sizeUp();
        }

        this.items[nextLast] = item;
        this.nextLast++;
        this.size++;
        if (this.nextLast >= this.items.length) {
            this.nextLast = 0;
        }
    }

    public void printDeque() {
        if (nextFirst < nextLast) {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                System.out.print(this.items[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = nextFirst + 1; i < items.length; i++) {
                System.out.print(this.items[i] + " ");
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.print(this.items[i] + " ");
            }
            System.out.println();
        }
    }

    public T removeFirst() {
        this.nextFirst++;
        T toReturn = this.items[this.nextFirst];
        this.size--;

        if ((double) this.size / this.items.length < 0.25) {
            sizeDown();
        }
        return toReturn;
    }

    public T removeLast() {
        this.nextLast--;
        T toReturn = this.items[this.nextLast];
        size--;

        if ((double) this.size / this.items.length < 0.25) {
            sizeDown();
        }
        return toReturn;
    }

    public T get(int index) {
        if (nextFirst < nextLast) {
            return this.items[nextFirst + 1 + index];
        } else {
            int temp = nextFirst + 1 + index - this.items.length;
            return this.items[temp];
        }
    }
}
