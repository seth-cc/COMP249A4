public class MyLinkedList<T> {

    private class Node {
        private T data;
        private Node next = null;


        public Node( T newData, Node newNext) {
            this.data = newData;
            this.next =  newNext;
        }

    }

    private int size;
    private Node head = null;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int findIndex(T data) {
        int i = -1;
        Node n = head;
        while (n != null) {
            if(n.data == data){
                return i + 1;
            }
            else{
                i++;
                n = n.next;
            }
        }
        return i;
    }
    public T findAt(int index){
        if(size < index){
            System.out.println("Invalid index! Linked List size isn't that big!");
            return null;
        }
        else {
            if(index == 0){
                return head.data;
            }
            else{
                Node indexNode = head;
                for (int i = 0; i <=index; i++){
                    if(i == index){
                        return indexNode.data;
                    }
                    else{
                        indexNode = indexNode.next;
                    }
                }
                System.out.println("Something went wrong in FindAt! there is a logic bug here...");
                return null;
            }
        }
    }
    public boolean removeAt(int index){
        Node indexNode = head;
        if(size < index){
            System.out.println("Invalid index! Linked List size isn't that big!");
            return false;
        }
        else{
            if(index == 0){
                head = head.next;
                return true;
            }
            else {
                for (int i = 0; i < index; i++) {
                    if (i == index - 1){
                        indexNode.next = indexNode.next.next;
                        return true;
                    }
                    else{
                        indexNode = indexNode.next;
                    }
                }
                System.out.println("Something went wrong in RemoveAt! there is a logic bug here...");
                return false;
            }
        }

    }
    public boolean addAt(T data, int index) {

        Node n = new Node(data, null);
        Node indexNode = head;
        if(index == 0){
            head = new Node(data, head);
            size++;
            return true;
        }
        else{
            if(size < index){
                System.out.println("Invalid index! Linked List size isn't that big!");
                return false;
            }
            else{
                for (int i = 0; i < size; i++) {
                    if (i == index - 1) {
                        Node tmp = indexNode.next;
                        indexNode.next = n;
                        n.next = tmp;
                        size++;
                        return true;
                    } else {
                        indexNode = indexNode.next;
                    }
                }
                System.out.println("Something went wrong in AddAt! check your logic!");
                return false;
            }

        }
    }
    public int getSize(){
        return size;
    }
}
