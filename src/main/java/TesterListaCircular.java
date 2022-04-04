public class TesterListaCircular {
    public static void main(String[] args) {
        var listaCircular = new CircularSinglyLinkedList<Integer>();
        listaCircular.addFirst(2);
        listaCircular.addLast(3);
        listaCircular.addFirst(7);
        listaCircular.removeFirst();

        System.out.println(listaCircular.showList());
        System.out.println(listaCircular.showListRecursive());
    }
}
