public class TesterListaCircularDoble {
    public static void main(String[] args) {
        var circularDoublyList = new CircularDoublyLinkedList<Integer>();
        circularDoublyList.addFirst(1);
        circularDoublyList.addLast(20);
        circularDoublyList.addLast(8);
        circularDoublyList.addFirst(9);
        circularDoublyList.addLast(10);

        System.out.println("\n" + circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

        System.out.println(circularDoublyList.showCircularity() + "\n");

        System.out.println("Remove First = " +circularDoublyList.removeFirst() + "\n");
        System.out.println("Remove Last = " +circularDoublyList.removeLast() + "\n");

        System.out.println(circularDoublyList.showCircularity() + "\n");

        circularDoublyList.addLast(10);
        System.out.println(circularDoublyList.showList() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

        circularDoublyList.addFirst(1);
        System.out.println(circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

        System.out.println(circularDoublyList.showCircularity());

    }
}
