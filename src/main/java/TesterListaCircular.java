public class TesterListaCircular {
    public static void main(String[] args) {
        var circularList = new CircularSinglyLinkedList<Integer>();
        circularList.addFirst(6);
        circularList.addLast(50);
        circularList.addLast(8);
        circularList.addFirst(3);
        circularList.addLast(9);

        System.out.println("\n" + circularList.showListRecursive() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

        System.out.println(circularList.showCircularity() + "\n");

        System.out.println("Remove First = " +circularList.removeFirst() + "\n");
        System.out.println("Remove Last = " +circularList.removeLast() + "\n");

        System.out.println(circularList.showCircularity() + "\n");

        circularList.addLast(10);
        System.out.println(circularList.showList() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

        circularList.addFirst(1);
        System.out.println(circularList.showListRecursive() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

        System.out.println(circularList.showCircularity());
    }
}
