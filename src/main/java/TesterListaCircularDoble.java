public class TesterListaCircularDoble {
    public static void main(String[] args) {
        var circularDoublyList = new CircularDoublyLinkedList<Integer>();
        circularDoublyList.addFirst(1);
        circularDoublyList.addLast(20);
        circularDoublyList.add(2, 25);
        circularDoublyList.add(3, 7);
        circularDoublyList.addLast(8);

        System.out.println(circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

        System.out.println("Buscar el index del elemento con valor 7: " + circularDoublyList.search(7) + "\n");
        System.out.println("Buscar el index del elemento con valor 6: " + circularDoublyList.search(6) + "\n");

        System.out.println("Remove = " +circularDoublyList.removeAt(2) + "\n");
        System.out.println(circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

        circularDoublyList.sort();
        System.out.println("Sorted: " + circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

        System.out.println("Remove First = " +circularDoublyList.removeFirst() + "\n");
        System.out.println("Remove Last = " +circularDoublyList.removeLast() + "\n");

        System.out.println(circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");



        System.out.println(circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

        System.out.println("Remove = " +circularDoublyList.remove(2) + "\n");

        circularDoublyList.addLast(3);
        System.out.println(circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

        System.out.println("Remove = " +circularDoublyList.remove(8) + "\n");

        System.out.println(circularDoublyList.showListRecursive() +
                "\n- Número de elementos: " + circularDoublyList.getSize() + "\n");

    }
}
