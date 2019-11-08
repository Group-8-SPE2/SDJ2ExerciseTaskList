package collection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListADTTest {
    private ListADT list;

    @Before
    public void setList() {
        list = new ArrayList();
    }

    @Test
    public void addList() {
        list.add("hahaha");
        list.add(1);
//        list.size();
//        System.out.println(list.size());
//        System.out.println(list.get(1));
        for (int i = 0; i < 101; i++) {
            list.add(2);
        }
        for (int i = 0; i < 101; i++) {
            list.add("hello");
        }
        assertEquals("hahaha",list.get(0));
        assertEquals("hello",list.get(103));

    }

    @Test//(expected = IndexOutOfBoundsException.class)
    public void set() {
        list.add("nihao");
        list.set(0, "hello");
        assertEquals("hello",list.get(0));

    }

    @Test//(expected = IllegalStateException.class)
    public void get() {
        list.add(0, "SEP12!");
        assertEquals("SEP12!",list.get(0));
    }

    @Test //(expected = IllegalStateException.class)
    public void remove1() {

        list.add("hello1");
        assertEquals("hello1", list.remove(0));

        list.add("hello2");
        assertEquals("hello2", list.remove(0));
        list.add("hello3");
        list.add("hello4");
        list.add("hello5");
        assertEquals("hello4",list.remove(1));

    }
@Test
    public void remove2(){
        list.add("hello1");
        list.add("hello2");
        list.add("hello3");
        list.remove("hello1");
        assertEquals("hello2",list.get(0));
    }
    @Test
    public void indexOf(){
        list.add("hello1");
        list.add("hello2");
        list.add("hello3");
        assertEquals(1,list.indexOf("hello2"));
    }
@Test
    public void contains(){
        assertFalse(list.contains("SEP = 0"));
        assertFalse(list.contains("SDJ = -3"));
        list.add("SDJ = 12");
        assertTrue(list.contains("SDJ = 12"));
    }

    @Test
    public void isEmpty(){
        assertTrue(list.isEmpty());
        list.add("wdnmd");
        assertFalse(list.isEmpty());
    }
    @Test
    public void size(){
        for (int i = 0; i < 100; i++) {
            list.add("test");
        }
        assertEquals(100,list.size());
    }


}