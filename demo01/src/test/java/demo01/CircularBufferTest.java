package demo01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularBufferTest {
    
    @Test public void 
    หลังจากทำการสร้าง_buffer_เพิ่ม2และลบ2_แล้ว_buffer_จะว่าง() {
        CircularBuffer cb = new CircularBuffer();
        cb.create(2); 
        cb.write("B");
        cb.write("A");
        cb.remove();
        cb.remove();
        assertTrue(cb.isEmpty());
    }
    
    @Test public void 
    หลังจากทำการสร้าง_buffer_เพิ่ม2และลบ1() {
        CircularBuffer cb = new CircularBuffer();
        cb.create(2);
        cb.write("B");
        cb.write("A");
        assertEquals("B", cb.remove());
        assertEquals("A", cb.remove());
    }
    
    @Test public void 
    หลังจากทำการสร้าง_buffer_เพิ่มและลบ() {
        CircularBuffer cb = new CircularBuffer();
        cb.create(2);
        cb.write("A");
        assertEquals("A", cb.remove());
    }
    
    @Test public void 
    หลังจากทำการสร้าง_buffer_เพิ่มข้อมูลจนเต็ม_แล้ว_buffer_จะเต็ม() {
        CircularBuffer cb = new CircularBuffer();
        cb.create(2);
        cb.write("A");
        cb.write("B");
        boolean actualResult = cb.isFull();
        assertTrue(actualResult);
    }
    
    @Test public void 
    หลังจากทำการสร้าง_buffer_เพิ่มข้อมูล_แล้ว_buffer_จะไม่เต็ม() {
        CircularBuffer cb = new CircularBuffer();
        cb.create(2);
        cb.write("A");
        boolean actualResult = cb.isFull();
        assertFalse(actualResult);
    }
    
    @Test public void 
    หลังจากทำการสร้าง_buffer_เพิ่มข้อมูล_แล้ว_buffer_จะไม่ว่าง() {
        CircularBuffer cb = new CircularBuffer();
        cb.create(5);
        cb.write("A");
        boolean actualResult = cb.isEmpty();
        assertFalse(actualResult);
    }

	@Test public void 
	หลังจากทำการสร้าง_buffer_แล้ว_buffer_จะต้องว่าง() {
	    CircularBuffer cb = new CircularBuffer();
	    cb.create(5);
	    boolean actualResult = cb.isEmpty();
	    assertTrue(actualResult);
	}

}
