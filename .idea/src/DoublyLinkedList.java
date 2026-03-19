import java.util.HashMap;

public class DoublyLinkedList<E> implements List{
    private Node<E> header = null;
    private int capacity = 0;
    private int s = 0;
    private HashMap<Node<E>, E> hashMap = null;
    public DoublyLinkedList(int cap){
        capacity = cap;
        header = null;
        hashMap = new HashMap<>();
    }

    public DoublyLinkedList(E elment, int cap){
        capacity = cap;
        header = new Node<E>(elment);
        s++;
        hashMap = new HashMap<>();
        hashMap.put(header, elment);
    }

    @Override
    public void add(Object element) {
        s++;
        Node<E> prev = null;
        if(header == null){
            header = new Node<E>((E) element);
            hashMap.put(header, (E) element);
            return;
        }
        if (s+1 <= capacity) {
            prev = new Node<E>((E) element);
            prev.setNextNode(header);
            header.setPrevNode(prev);
            header = prev;
            hashMap.put(header, (E) element);
        }
        else {
            Node<E> next = header;
            for (int i = 0; i < s-1; i++){
                next = next.getNextNode();
            }
            hashMap.remove(next.getNextNode());
            next.setNextNode(null);
            s--;
            prev = new Node<E>((E) element);
            prev.setNextNode(header);
            header.setPrevNode(prev);
            header = prev;
            hashMap.put(header, (E) element);
        }
    }

    @Override
    public void add(int i, Object element) throws IndexOutOfBoundsException {
        if (i > s || i < 0)
            throw new IndexOutOfBoundsException();
        s++;
        Node<E> after = null;
        if (header == null){
            header = new Node<E>((E) element);
            hashMap.put(header, (E) element);
            return;
        }
        Node<E> next = header;
        if (i == 0) {
            after = new Node<E>((E) element);
            next.setPrevNode(after);
            after.setNextNode(next);
            header = next.getPrevNode();
            hashMap.put(header, (E) element);
            return;
        }
        while(i != 0 && next.getNextNode() != null){
            next = next.getNextNode();
            i--;
        }
        after = new Node<E>((E)element, next.getPrevNode());
        if (next.getPrevNode() !=  null)
            after.getPrevNode().setNextNode(after);
        after.setNextNode(next);
        next.setPrevNode(after);
        hashMap.put(after, (E)element);
    }

    @Override
    public Object remove() {
        s--;
        Node<E> next = header;
        while (next.getNextNode() != null) {
            next = next.getNextNode();
        }
        Object val = next.getValue();
        hashMap.remove(next);
        next.setPrevNode(null);
        return (val);

    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        if (i > s-1)
            throw new IndexOutOfBoundsException();
        s--;
        Object val;
        Node<E> next = header;
        if (s == 0){
            val = header.getValue();
            header = null;
            return val;
        }
        while (i > 0){
            next = next.getNextNode();
            i--;
        }
        if (next.getNextNode() == null) {
            val = next.getValue();
            next.getPrevNode().setNextNode(null);
            return val;
        }
        if (next.getPrevNode() == null){
            val = header.getValue();
            header.setValue(null);
            header = header.getNextNode();
            return val;
        }
        val = next.getValue();
        hashMap.remove(next);
        next.getPrevNode().setNextNode(next.getNextNode());
        next.getNextNode().setPrevNode(next.getPrevNode());
        return val;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        Node<E> next = header;
        while (i > 0 && next.getNextNode() != null){
            next = next.getNextNode();
        }
        return (hashMap.get(next));
    }

    @Override
    public void set(int i, Object element) throws IndexOutOfBoundsException {
        Node<E> next = header;
        int j = i;
        while (i > 0 && next.getNextNode() != null){
            next = next.getNextNode();
            i--;
        }
        next.setValue((E)element);
        hashMap.put(next, (E)element);
        remove(j);
        add(j, element);
    }

    @Override
    public int size() {
        return s;
    }

    @Override
    public boolean isEmpty() {
        if (s == 0)
            return true;
        return false;
    }
    public String toString(){
        Node<E> next = header;
        String string = "[";
        while (next.getNextNode() != null){
            string += next.getValue() + ", ";
            next = next.getNextNode();
        }
        string += next.getValue() + "]";
        return (string);
    }
}