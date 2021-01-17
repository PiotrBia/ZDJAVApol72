package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringLinkedListTest {
    @Test
    public void shouldReturnTrueForIsEmptyForNewList(){
        StringLinkedList list = new StringLinkedList();
        boolean result = list.isEmpty();
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnFalseForIsEmptyForListWithItems(){
        StringLinkedList list = new StringLinkedList();
        list.add("TEST");
        boolean result = list.isEmpty();
        assertFalse(result);
    }

    @Test
    public void shouldReturnValidValueForGet(){
        StringLinkedList list = new StringLinkedList();
        list.add("TEST");
        assertEquals("TEST", list.get(0));
        assertNull(list.get(1));
        for(int i = 0; i < 100; i++){
            list.add("SSSS");
        }
        assertEquals("SSSS", list.get(100));
        assertNull(list.get(101));
    }

    @Test
    public void shouldReturnValidSize(){
        StringLinkedList list = new StringLinkedList();
        assertEquals(0, list.size());
        list.add("AAA");
        assertEquals(1, list.size());
        list.add("BBB");
        list.add("CCC");
        assertEquals(3, list.size());
        list.add("DDD");
        assertEquals(4, list.size());
    }

    @Test
    public void shouldReturnValidListForAdd(){
        //GIVEN
        StringLinkedList list = new StringLinkedList();

        //WHEN
        boolean result = list.add("AAA",2);
        //THEN
        assertEquals(false, result);

        //WHEN
        result = list.add("AAA",0);
        //THEN
        assertEquals(true, result);
        assertEquals("AAA",list.get(0));

        //WHEN
        result = list.add("BBB",0);
        //THEN
        assertEquals(true, result);
        assertEquals("BBB", list.get(0));
        assertEquals("AAA", list.get(1));

        //WHEN
        result = list.add("CCC", 2);
        result = list.add("DDD", 2);
        result = list.add("EEE", 4);
        result = list.add("FFF", -1);
        //THEN
        assertEquals(false, result);

        //GIVEN
        list = new StringLinkedList();
        //WHEN
        list.add("B",0);
        list.add("C",1);
        list.add("A",0);
        list.add("D",3);
        list.add("E",4);
        //THEN
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));
        assertEquals("E", list.get(4));
    }

    @Test
    public void shouldReturnValidListForAddingToEndOfList(){
        StringLinkedList list = new StringLinkedList();
        list.add("AAA",0);
        list.add("BBB");
        assertEquals("AAA", list.get(0));
        assertEquals("BBB", list.get(1));
        list.add("CCC", 2);
        list.add("DDD");
        assertEquals("CCC", list.get(2));
        assertEquals("DDD", list.get(3));
    }

    @Test
    public void shouldReturnValidListAfterRemovingItemsFromList(){
        StringLinkedList list = new StringLinkedList();
        list.add("AAA",0);
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        list.remove(0);
        assertEquals("BBB", list.get(0));
        list.remove(2);
        assertEquals(null, list.get(2));
        list.add("DDD");
        assertEquals("DDD", list.get(2));

    }
}
