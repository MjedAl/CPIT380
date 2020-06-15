// This class will help us in Histograms, it will keep the location of all pixels location at each intensity level

public class Pixel_LL {

    private PixelLinkedList_node head;
    private PixelLinkedList_node tail;
    private int total;

    public Pixel_LL() {
        head = null;
        total = 0;
    }

    public void addPixel(PixelLinkedList_node pixel) {
        if (head == null) {//list is empty
            head = pixel;
            tail = head;
        } else {
            tail.setNext(pixel);
            tail = pixel;
        }
        total++;
    }

    public PixelLinkedList_node getHead(){
        return head;
    }
    
    public int getTotal() {
        return total;
    }

    public void PrintAllNodesLocation() {
        System.out.println("Total Number of pixles: " + total);
        if (head != null) {
            int count = 0;
            PixelLinkedList_node helpPtr = head;
            while (helpPtr.getNext() != null) {
                System.out.println("Location of pixel #" + count + " is\t" + helpPtr);
                helpPtr = helpPtr.getNext();
                count++;
            }
        }
    }

    public void PrintFirst10AvailableLocations() {
        System.out.println("Total Number of pixles available: " + total);
        if (total > 10) {
            int count = 0;
            if (head != null) {
                PixelLinkedList_node helpPtr = head;
                while (helpPtr.getNext() != null) {
                    System.out.println("Location of pixel #" + count + " is\t" + helpPtr);
                    helpPtr = helpPtr.getNext();
                    count++;
                    if (count == 10) {
                        break;
                    }
                }
            }
        }
    }
}

class PixelLinkedList_node {

    private int x;
    private int y;
    
    private PixelLinkedList_node next;

    public PixelLinkedList_node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PixelLinkedList_node(PixelLinkedList_node node) {
        this(node, null);
    }

    public PixelLinkedList_node(PixelLinkedList_node node, PixelLinkedList_node next) {
        this.next = next;
    }

    public PixelLinkedList_node getNext() {
        return next;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setNext(PixelLinkedList_node next) {
        this.next = next;
    }

    public String toString() {
        return "X:" + x + "\tY: " + y;
    }

}
