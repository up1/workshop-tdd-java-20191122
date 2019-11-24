package demo01;

public class MyRange {

    private static final int ASCII_CODE_OF_ZERO = 48;
    private String input;

    public MyRange(String input) {
        this.input = input;
    }
    
    public void validate() {
        throw new InputFormatInvalidException();
    }
    
    public int getFirstNumber() {
        if(startWithInclude()) {
            return input.charAt(1) - ASCII_CODE_OF_ZERO;
        }
        return input.charAt(1) - (ASCII_CODE_OF_ZERO-1);
    }


    public boolean startWithInclude() {
        return this.input.startsWith("[");
    }

    public boolean endWithInclude() {
        return this.input.endsWith("]");
    }

    

    
}
