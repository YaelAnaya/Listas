public class TesterListaCircular {
    public static void main(String[] args) {
        var circularList = new CircularSinglyLinkedList<Integer>();
        circularList.addFirst(6);
        circularList.addLast(50);
        circularList.add(2, 275);
        circularList.add(1, 76);
        circularList.addLast(8);

//        System.out.println(circularList.showCircular());
        System.out.println(circularList.showListRecursive() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

        System.out.println("Buscar el index del elemento con valor 7: " + circularList.search(7) + "\n");
        System.out.println("Buscar el index del elemento con valor 6: " + circularList.search(6) + "\n");

        System.out.println("Remove = " +circularList.removeAt(2) + "\n");
        System.out.println(circularList.showListRecursive() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

        circularList.sort();
        System.out.println("Sorted: " + circularList.showListRecursive() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

        System.out.println("Remove First = " +circularList.removeFirst() + "\n");
        System.out.println("Remove Last = " +circularList.removeLast() + "\n");

        System.out.println(circularList.showListRecursive() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

        System.out.println("Remove = " +circularList.remove(2) + "\n");

        circularList.addLast(3);
        System.out.println(circularList.showListRecursive() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

        System.out.println("Remove = " +circularList.remove(8) + "\n");

        System.out.println(circularList.showListRecursive() +
                "\n- Número de elementos: " + circularList.getSize() + "\n");

    }
}
