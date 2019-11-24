package demo01;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

class Random5 extends Random {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}

class SpyRandom extends Random {
    
    private int counter = 0;
    
    @Override
    public int nextInt(int bound) {
        counter++;
        return -100000;
    }
    
    public void verify(int target) {
        if(counter != target) {
            fail();
        }
    }
}

public class GenerateNumberTest {
    
    @Test
    public void test2() {
        // Dependency
        SpyRandom random = new SpyRandom();
        
        GenerateNumber g = new GenerateNumber();
        g.setRandom(random);
        g.get();
        
        random.verify(1);
    }

    @Test
    public void test() {
        // Dependency
        Random random = new Random5();
        
        // Constructor injection
        GenerateNumber g = new GenerateNumber();
        // Setter injection
        g.setRandom(random);
        // Method injection
        assertEquals(5, g.get());
    }

}
