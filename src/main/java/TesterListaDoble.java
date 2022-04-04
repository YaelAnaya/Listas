public class TesterListaDoble {
    public static void main(String[] args) {
        var listaDoble = new DoublyLinkedList<Integer>();

        listaDoble.addFirst(2);
        listaDoble.addLast(1);
        listaDoble.addLast(3);
        listaDoble.addFirst(0);

        System.out.println("\nElementos: " + listaDoble.showList() + "\t -> Nodos = " + listaDoble.getSize());

        System.out.println("\nElemento eliminado: " + listaDoble.removeFirst() + "\t -> Nodos = " + listaDoble.getSize());
        System.out.println("\nElemento eliminado: " + listaDoble.removeLast() + "\t -> Nodos = " + listaDoble.getSize());

        System.out.println("\nElementos: " + listaDoble.showListRecursive() + "\t -> Nodos = " + listaDoble.getSize());

        while(!listaDoble.isEmpty())
            listaDoble.removeFirst();

        System.out.println("\nElementos: " + listaDoble.showList() + "\t -> Nodos = " + listaDoble.getSize());
    }
}
