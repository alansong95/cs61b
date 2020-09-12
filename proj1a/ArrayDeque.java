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
        if (this.size > 0) {
            this.nextFirst++;
            if (this.nextFirst >= this.items.length) {
                this.nextFirst = 0;
            }
            T toReturn = this.items[this.nextFirst];
            this.size--;

            if (this.items.length >= 16 && ((double) this.size / this.items.length < 0.25)) {
                sizeDown();
            }
            return toReturn;
        }
        return null;
    }

    public T removeLast() {
        if (this.size > 0) {
            this.nextLast--;
            if (this.nextLast < 0) {
                this.nextLast = this.items.length - 1;
            }
            T toReturn = this.items[this.nextLast];
            size--;

            if (this.items.length >= 16 && (double) this.size / this.items.length < 0.25) {
                sizeDown();
            }
            return toReturn;
        }
        return null;
    }

    public T get(int index) {
        if (nextFirst < nextLast && this.size != this.items.length) {
            return this.items[nextFirst + 1 + index];
        } else {
            if (nextFirst + 1 + index >= this.items.length) {
                int temp = index - (this.items.length  - (nextFirst + 1));
                return this.items[temp];
            } else {
                return this.items[nextFirst + 1 + index];
            }
        }
    }

//    public T getRecursive(int index) {
//        return get(index);
//    }
}
