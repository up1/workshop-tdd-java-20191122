package demo01;

public class CircularBuffer {
    
    
    private String[] input;
    private int writePointer;
    private int readPointer;

    public void create(int size) {
        input = new String[size];
    }

    public boolean isEmpty() {
        return writePointer == readPointer;
    }

    public void write(String input) {
        this.input[writePointer++] = input;
    }

    public boolean isFull() {
        return input.length == writePointer;
    }

    public String remove() {
        return input[readPointer++];
    }

}
