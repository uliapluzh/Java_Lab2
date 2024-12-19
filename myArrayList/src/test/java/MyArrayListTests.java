import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MyArrayListTests {
    @Test
    void testIsEmpty() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        assertTrue(myList.isEmpty());
        assertTrue(standardList.isEmpty());
        assertEquals(0, myList.size());
        assertEquals(0, standardList.size());
        assertEquals(standardList.isEmpty(), myList.isEmpty());
    }

    @Test
    void testAdd() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        myList.add(7);
        myList.add(9);
        standardList.add(7);
        standardList.add(9);

        assertEquals(standardList.size(), myList.size());

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(standardList.get(i), myList.get(i));
        }
    }

    @Test
    void testContains() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        myList.add(11);
        myList.add(20);
        standardList.add(11);
        standardList.add(20);

        assertTrue(myList.contains(20));
        assertTrue((standardList.contains(20)));
        assertEquals(myList.contains(20), standardList.contains(20));
        assertEquals(myList.contains(100), standardList.contains(100));
        assertEquals(myList.contains(null), standardList.contains(null));
    }

    @Test
    void testToArray() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        myList.add(10);
        myList.add(-8);
        standardList.add(10);
        standardList.add(-8);

        assertArrayEquals(myList.toArray(), standardList.toArray());

    }

    @Test
    void testToArray2() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            myList.add(i);
            standardList.add(i);
        }

        Integer[] smallArray = new Integer[2];
        assertArrayEquals(myList.toArray(smallArray), standardList.toArray(smallArray));

        Integer[] largeArray = new Integer[5];
        assertArrayEquals(myList.toArray(largeArray), standardList.toArray(largeArray));

        assertNull(largeArray[3]);
        assertNull(largeArray[4]);
    }

    @Test
    void testAddAll() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();
        Collection<Integer> collection = new ArrayList<>();

        assertFalse(myList.addAll(collection));
        assertFalse(standardList.addAll(collection));
        assertEquals(myList.isEmpty(), standardList.isEmpty());

        collection.add(4);
        collection.add(0);
        collection.add(5);

        myList.addAll(collection);
        standardList.addAll(collection);

        assertEquals(collection.size(), myList.size());
        assertEquals(collection.size(), standardList.size());
        assertIterableEquals(myList, standardList);

    }

    @Test
    void testAddAllAtIndex() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();
        Collection<Integer> collection = new ArrayList<>();

        myList.add(1);
        myList.add(2);
        standardList.add(1);
        standardList.add(2);
        collection.add(5);
        collection.add(7);
        collection.add(8);
        collection.add(10);

        myList.addAll(1, collection);
        standardList.addAll(1, collection);
        assertIterableEquals(myList, standardList);
        assertEquals(myList.size(), standardList.size());

    }

    @Test
    void testContainsAll() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();
        Collection<Integer> collection = new ArrayList<>();

        collection.add(48);
        collection.add(32);
        myList.add(3);
        standardList.add(3);
        myList.add(4);
        standardList.add(4);
        myList.addAll(0, collection);
        standardList.addAll(0, collection);
        assertEquals(myList.containsAll(collection), standardList.containsAll(collection));

    }

    @Test
    void testRemove() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        myList.add(67);
        standardList.add(67);
        myList.add(88);
        standardList.add(88);

        myList.remove((Integer) 88);
        standardList.remove((Integer) 88);

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(standardList.get(i), myList.get(i));
        }

        assertEquals(myList.remove((Integer) 200), standardList.remove((Integer) 200));

        myList.remove((Integer) 67);
        standardList.remove((Integer) 67);
        assertEquals(myList.isEmpty(), standardList.isEmpty());

    }

    @Test
    void testRemoveAll() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();
        Collection<Integer> collection = new ArrayList<>();

        myList.add(-3);
        myList.add(-6);
        myList.add(101);
        standardList.add(-3);
        standardList.add(-6);
        standardList.add(101);

        collection.add(-3);
        collection.add(101);

        myList.removeAll(collection);
        standardList.removeAll(collection);

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(standardList.get(i), myList.get(i));
        }

    }

    @Test
    void testRetainAll() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();
        Collection<Integer> collection = new ArrayList<>();

        myList.add(44);
        myList.add(-24);
        myList.add(99);
        standardList.add(44);
        standardList.add(-24);
        standardList.add(99);

        collection.add(-24);
        collection.add(44);

        myList.retainAll(collection);
        standardList.retainAll(collection);

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(standardList.get(i), myList.get(i));
        }

    }

    @Test
    void testAddAtIndex() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            myList.add(i);
            standardList.add(i);
        }

        myList.add(4, 77);
        standardList.add(4, 77);

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(standardList.get(i), myList.get(i));
        }

    }

    @Test
    void testRemoveAtIndex() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            myList.add(i);
            standardList.add(i);
        }

        Integer myres = myList.remove(3);
        Integer stres = standardList.remove(3);

        assertEquals(myres, stres);

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(standardList.get(i), myList.get(i));
        }

    }

    @Test
    void testIterator() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            myList.add(i);
            standardList.add(i);
        }

        Iterator<Integer> myIterator = myList.iterator();
        Iterator<Integer> standardIterator = standardList.iterator();

        while (myIterator.hasNext() && standardIterator.hasNext()) {
            assertEquals(standardIterator.next(), myIterator.next());
        }

        assertFalse(myIterator.hasNext());
        assertFalse(standardIterator.hasNext());

        assertThrows(NoSuchElementException.class, () -> myIterator.next());
        assertThrows(NoSuchElementException.class, () -> standardIterator.next());
    }

    @Test
    void testClear() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            myList.add(i);
            standardList.add(i);
        }

        myList.clear();
        standardList.clear();

        assertEquals(0, myList.size());
        assertEquals(0, standardList.size());

        assertEquals(myList.isEmpty(), standardList.isEmpty());

    }

    @Test
    void testGet() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            myList.add(i * 10);
            standardList.add(i * 10);
        }

        assertEquals(10, myList.get(0));
        assertEquals(20, myList.get(1));
        assertEquals(10, standardList.get(0));
        assertEquals(20, standardList.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> standardList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> standardList.get(3));
    }

    @Test
    void testSet() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            myList.add(i * 10);
            standardList.add(i * 10);
        }

        Integer myres = myList.set(0, 25);
        Integer stres = standardList.set(0, 25);

        assertEquals(myres, stres);

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(standardList.get(i), myList.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> myList.set(-1, 100));
        assertThrows(IndexOutOfBoundsException.class, () -> myList.set(3, 100));
        assertThrows(IndexOutOfBoundsException.class, () -> standardList.set(-1, 100));
        assertThrows(IndexOutOfBoundsException.class, () -> standardList.set(3, 100));
    }

    @Test
    void testIndexOf() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            myList.add(i * 10);
            standardList.add(i * 10);
        }

        assertEquals(standardList.indexOf(10), myList.indexOf(10));
        assertEquals(standardList.indexOf(20), myList.indexOf(20));
        assertEquals(standardList.indexOf(30), myList.indexOf(30));

        myList.add(null);
        standardList.add(null);
        assertEquals(standardList.indexOf(null), myList.indexOf(null));
        assertEquals(-1, myList.indexOf(40));

    }

    @Test
    void testLastIndexOf() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            myList.add(i * 2);
            standardList.add(i * 2);
        }

        myList.add(4);
        standardList.add(4);
        myList.add(6);
        standardList.add(6);

        assertEquals(standardList.lastIndexOf(2), myList.lastIndexOf(2));
        assertEquals(standardList.lastIndexOf(4), myList.lastIndexOf(4));
        assertEquals(standardList.lastIndexOf(6), myList.lastIndexOf(6));

        assertEquals(-1, myList.indexOf(8));

    }

    @Test
    void testListIterator() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            myList.add(i * 10);
            standardList.add(i * 10);
        }

        ListIterator<Integer> myListIterator = myList.listIterator();
        ListIterator<Integer> standardListIterator = standardList.listIterator();

        while (myListIterator.hasNext() && standardListIterator.hasNext()) {
            assertEquals(standardListIterator.next(), myListIterator.next());
        }
        assertEquals(standardListIterator.hasNext(), myListIterator.hasNext());

        while (myListIterator.hasPrevious() && standardListIterator.hasPrevious()) {
            assertEquals(standardListIterator.previous(), myListIterator.previous());
        }
        assertEquals(standardListIterator.hasPrevious(), myListIterator.hasPrevious());

        myListIterator.next();
        standardListIterator.next();

        myListIterator.set(999);
        standardListIterator.set(999);

        assertEquals(myList.get(0), standardList.get(0));
        assertEquals((Integer) 999, myList.get(0));
        assertEquals((Integer) 999, standardList.get(0));

        myListIterator.next();
        standardListIterator.next();

        myListIterator.remove();
        standardListIterator.remove();

        assertEquals(2, myList.size());
        assertEquals(2, standardList.size());
        assertFalse(myList.contains(10));
        assertFalse(standardList.contains(10));

        myListIterator.next();
        standardListIterator.next();

        myListIterator.add(555);
        standardListIterator.add(555);

        assertEquals(myList.get(2), standardList.get(2));
        assertEquals((Integer) 555, myList.get(2));
        assertEquals((Integer) 555, standardList.get(2));
    }

    @Test
    void testListIteratorWithIndex() {
        myArrayList<Integer> myList = new myArrayList<>();
        List<Integer> standardList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            myList.add(i * 10);
            standardList.add(i * 10);
        }

        ListIterator<Integer> myListIterator = myList.listIterator(2);
        ListIterator<Integer> standardListIterator = standardList.listIterator(2);

        assertEquals(20, myListIterator.next());
        assertEquals(20, standardListIterator.next());

        assertEquals(myListIterator.hasNext(), standardListIterator.hasNext());
        assertFalse(myListIterator.hasNext());
        assertFalse(standardListIterator.hasNext());

        assertEquals(20, myListIterator.previous());
        assertEquals(20, standardListIterator.previous());
        assertEquals(10, myListIterator.previous());
        assertEquals(10, standardListIterator.previous());
        assertEquals(0, myListIterator.previous());
        assertEquals(0, standardListIterator.previous());

        assertFalse(myListIterator.hasPrevious());
        assertFalse(standardListIterator.hasPrevious());

    }
}