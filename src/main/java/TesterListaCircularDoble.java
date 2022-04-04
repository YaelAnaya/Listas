public class TesterListaCircularDoble {
    public static void main(String[] args) {
        var circularList = new CircularDoublyLinkedList<Integer>();
        circularList.addFirst(1);
        circularList.addLast(4);
        circularList.addLast(5);

        circularList.removeFirst();
        circularList.removeLast();
    }
}
