package demo01;

import java.util.Random;

public class GenerateNumber {
    
    private Random random;
    
    public void setRandom(Random random) {
        this.random = random;
    }
    
    public int get() {
        return random.nextInt(10);
    }

}
