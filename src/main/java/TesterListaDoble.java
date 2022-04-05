public class TesterListaDoble {
    public static void main(String[] args) {
        var listaDoble = new DoublyLinkedList<Integer>();

        listaDoble.addFirst(2);
        listaDoble.addLast(1);
        listaDoble.addLast(3);
        listaDoble.addFirst(0);

        System.out.println(listaDoble.showList());
        listaDoble.sort();

        System.out.println(listaDoble.showListRecursive());

    }
}
