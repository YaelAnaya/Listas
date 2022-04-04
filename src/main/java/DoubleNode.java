public class DoubleNode<T> {
    private DoubleNode<T> previous;
    private DoubleNode<T> next;
    private T element;

    public DoubleNode(T element) {
        this.previous = null;
        this.next = null;
        this.element = element;
    }

    public DoubleNode(T element, DoubleNode<T> previous, DoubleNode<T> next) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public DoubleNode<T> getPrevious() {
        return this.previous;
    }

    public DoubleNode<T> getNext() {
        return this.next;
    }

    public T getElement() {
        return this.element;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public void setElement(T element) {
        this.element = element;
    }
}

