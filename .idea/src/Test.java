public class Test{
    public static void main(String[] args) {
//        Node<String> first = new Node<>("obtuse");
//
//        Node<String> next = new Node<>("rubber goose");
//        first.setNextNode(next);
//        next.setPrevNode(first);
//
//        Node<String> after = new Node<>("guava juice", next);
//        next.setNextNode(after);
//        System.out.println(after.getPrevNode().getValue()); // "rubber goose"
//
//        Node<String> last = new Node<>("giant snake");
//        System.out.println(next.equals(last)); //false

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1000);
        list.add(10);
        System.out.println(list.toString()); // [10]
        list.add(20);
        System.out.println(list.toString()); // [20, 10]
        list.add(30);
        System.out.println(list.toString()); // [30, 20, 10]

        list.add(2, 40);
        System.out.println(list.toString()); // [30, 20, 40, 10]
        list.add(0, 5);
        System.out.println(list.toString()); // [5, 30, 20, 40, 10]
        list.set(0, 50);
        System.out.println(list.toString()); // [50, 30, 20, 40, 10]

        System.out.println(list.remove(4)); // 10
        System.out.println(list.remove(2)); // 30
        System.out.println(list.size()); // 3
        System.out.println(list.toString()); // [5, 10, 40]
    }
}
