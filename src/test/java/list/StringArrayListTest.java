package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayListTest {
    @Test
    public void shouldReturnTrueForIsEmptyForNewList() {
        StringArrayList list = new StringArrayList(5);
        boolean result = list.isEmpty();
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnFalseForIsEmptyForListWithItems() {
        StringArrayList list = new StringArrayList(5);
        list.add("TEST");
        boolean result = list.isEmpty();
        assertEquals(false, result);
    }

    @Test
    public void shouldReturnFalseForIsFullWhenNewList() {
        StringArrayList list = new StringArrayList(5);
        list.add("TEST");
        boolean result = list.isFull();
        assertEquals(false, result);
    }

    @Test
    public void shouldReturnTrueForIsFullWhenListIsFull() {
        StringArrayList list = new StringArrayList(2);
        list.add("TEST");
        list.add("TEST");
        boolean result = list.isFull();
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnValidListForAdd() {
        //GIVEN
        StringArrayList list = new StringArrayList(5);
        //WHEN
        boolean result = list.add("AAA", 2);
        //THEN
        assertEquals(false, result);
        //WHEN
        result = list.add("AAA", 0);
        //THEN
        assertEquals(true, result);
        assertEquals("AAA", list.get(0));
        //WHEN
        result = list.add("BBB", 0);
        //THEN
        assertEquals(true, result);
        assertEquals("BBB", list.get(0));
        assertEquals("AAA", list.get(1));

        //WHEN
        result = list.add("CCC", 2);
        result = list.add("DDD", 2);
        result = list.add("EEE", 4);
        result = list.add("FFF", 5);
        //THEN
        assertEquals(false, result);
        assertEquals(true, list.isFull());

        //GIVEN
        list = new StringArrayList(5);
        //WHEN
        list.add("B", 0);
        list.add("C", 1);
        list.add("A", 0);
        list.add("D", 3);
        list.add("E", 4);
        //THEN
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));
        assertEquals("E", list.get(4));
    }

    @Test
    public void shouldReturnValidSize() {
        StringArrayList list = new StringArrayList(3);
        assertEquals(0, list.size());
        list.add("AAA");
        assertEquals(1, list.size());
        list.add("BBB");
        assertEquals(2, list.size());
        list.add("CCC");
        assertEquals(3, list.size());
        list.add("DDD");
        assertEquals(3, list.size());
    }

    @Test
    public void shouldReturnValidListAfterRemove() {
        StringArrayList list = new StringArrayList(3);
        assertEquals(false, list.remove(0));
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        boolean result = list.remove(0);
        assertEquals(2, list.size());
        assertEquals(true, result);
        assertEquals("BBB", list.get(0));
        list.remove(1);
        list.remove(0);
        assertEquals(true, list.isEmpty());
        assertEquals(0, list.size());
    }
}