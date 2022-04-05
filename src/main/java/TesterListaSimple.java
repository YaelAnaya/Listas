public class TesterListaSimple {
    public static void main(String[] args) {


        var linkedList = new SinglyLinkedList<Integer>();
        linkedList.addFirst(1);
        linkedList.addLast(20);
        linkedList.add(2, 25);
        linkedList.add(3, 7);
        linkedList.addLast(8);

        System.out.println(linkedList.showListRecursive() +
                           "\n- Número de elementos: " + linkedList.getSize() + "\n");

        System.out.println("Buscar el index del elemento con valor 7: " + linkedList.search(7) + "\n");
        System.out.println("Buscar el index del elemento con valor 6: " + linkedList.search(6) + "\n");

        linkedList.sort();
        System.out.println("Sorted: " + linkedList.showListRecursive() +
                "\n- Número de elementos: " + linkedList.getSize() + "\n");

        System.out.println("Remove First = " +linkedList.removeFirst() + "\n");
        System.out.println("Remove Last = " +linkedList.removeLast() + "\n");

        System.out.println(linkedList.showListRecursive() +
                            "\n- Número de elementos: " + linkedList.getSize() + "\n");

        System.out.println("Remove = " +linkedList.removeAt(2) + "\n");

        System.out.println(linkedList.showListRecursive() +
                            "\n- Número de elementos: " + linkedList.getSize() + "\n");

        System.out.println("Remove = " +linkedList.remove(2) + "\n");

        linkedList.addLast(3);
        System.out.println(linkedList.showListRecursive() +
                "\n- Número de elementos: " + linkedList.getSize() + "\n");

        System.out.println("Remove = " +linkedList.remove(8) + "\n");

        System.out.println(linkedList.showListRecursive() +
                "\n- Número de elementos: " + linkedList.getSize() + "\n");

    }
}
