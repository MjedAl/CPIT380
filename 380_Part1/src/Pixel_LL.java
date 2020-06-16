
import java.io.PrintWriter;
import java.util.Scanner;

// This class will help us in Histograms, it will keep the location of all pixels location at each intensity level
public class Pixel_LL {
    
    private PixelLinkedList_node head;
    private PixelLinkedList_node tail;
    private int total;
    
    public Pixel_LL() {
        head = null;
        total = 0;
    }
    
    public Pixel_LL(Scanner input,int total) {
        importHistogram(input,total);
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
    
    public PixelLinkedList_node getHead() {
        return head;
    }
    
    public int getTotal() {
        return total;
    }
 
    public void exportHistogram(PrintWriter pen) {
        pen.println(total);
        PixelLinkedList_node helpPtr = head;
        while (helpPtr != null) {
            pen.println(helpPtr);
            helpPtr = helpPtr.getNext();
        }
        pen.flush();
    }
    
    public void importHistogram(Scanner input,int total) {
        for (int i = 0; i < total; i++) {
            addPixel(new PixelLinkedList_node(input.nextInt(), input.nextInt()));
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
        return x + " " + y;
    }
    
}
