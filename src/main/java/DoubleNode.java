public class DoubleNode<T> extends Node<T> {
    private Node<T> previous;

    public DoubleNode(T element) {
        super(element);
        super.next = null;
        this.previous = null;
    }

    public DoubleNode(T element, Node previous, Node next) {
        super(element, next);
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
