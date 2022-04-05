public class TesterListaDoble {
    public static void main(String[] args) {
        var doublyList = new DoublyLinkedList<Integer>();
        doublyList.addFirst(1);
        doublyList.addLast(30);
        doublyList.add(2, 25);
        doublyList.add(3, 7);
        doublyList.addLast(8);

        System.out.println(doublyList.showListRecursive() +
                "\n- Número de elementos: " + doublyList.getSize() + "\n");

        System.out.println("Buscar el index del elemento con valor 7: " + doublyList.search(7) + "\n");
        System.out.println("Buscar el index del elemento con valor 6: " + doublyList.search(6) + "\n");

        System.out.println("Remove = " +doublyList.removeAt(2) + "\n");
        System.out.println(doublyList.showListRecursive() +
                "\n- Número de elementos: " + doublyList.getSize() + "\n");

        doublyList.sort();
        System.out.println("Sorted: " + doublyList.showListRecursive() +
                "\n- Número de elementos: " + doublyList.getSize() + "\n");

        System.out.println("Remove First = " +doublyList.removeFirst() + "\n");
        System.out.println("Remove Last = " +doublyList.removeLast() + "\n");

        System.out.println(doublyList.showListRecursive() +
                "\n- Número de elementos: " + doublyList.getSize() + "\n");

        System.out.println("Remove = " +doublyList.remove(2) + "\n");

        doublyList.addLast(3);
        System.out.println(doublyList.showListRecursive() +
                "\n- Número de elementos: " + doublyList.getSize() + "\n");

        System.out.println("Remove = " +doublyList.remove(8) + "\n");

        System.out.println(doublyList.showListRecursive() +
                "\n- Número de elementos: " + doublyList.getSize() + "\n");

    }
}
