public class LinkedListDriver{
    // This was just to test linked lists
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList();
        for(int i = 0; i < 11; i++){
            list.addAt(i,i);
        }
        System.out.println("now printing:");

        list.addAt(111, 2);
        list.removeAt(5);
        for(int i = 0; i < list.getSize() - 1; i++){
            System.out.println(i + ": " + list.findAt(i));
        }
    }
}