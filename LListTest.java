import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LListTest.
 *
 * @author  Ryan Peters
 * @version 2/19/2014
 */
public class LListTest
{
    // Test to see if the linked list even creates and is empty
    @Test
    public void testLList()
    {
        LList<String> x = new LList<String>();
        assertEquals(0, x.size());
    }
    // Test to see if the linked list adds correctly to the head of the list
    @Test
    public void testAdd()
    {
        LList<String> x = new LList<String>();
        x.add("Hello");
        assertEquals(" 0:Hello", x.toString());
        assertEquals(1, x.size());
        x.add("Ten");
        assertEquals(" 0:Ten 1:Hello", x.toString());
        assertEquals(2, x.size());
        x.clear();
        assertEquals(0, x.size());
    }
    
    // Testing to add large amounts of nodes to the list and making sure they are equal
    @Test
    public void testAdd50()
    {
        LList<String> x = new LList<String>();
        for(int i = 0; i<50; i++)
        {
            x.add("Wonderful");
        }
        assertEquals(50, x.size());
        x.clear();
        assertEquals(0, x.size());
        for(int i = 0; i < 50; i++)
        {
            x.add("Hello");
        }
        assertEquals(50, x.size());
    }
    
    @Test
    public void testRemove()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.add("Jane");
        x.add("Bob");
        x.remove();
        assertEquals(" 0:Jane 1:Sue 2:Jim", x.toString());
        x.remove();
        assertEquals(" 0:Sue 1:Jim", x.toString());
        x.remove();
        assertEquals(" 0:Jim", x.toString());
        x.remove();
        assertEquals("", x.toString());
    }
    
    @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testRemoveException()
    {
        LList<String> x = new LList<String>();
        x.remove();
    }
    // Test to see if the size method works like it should
    @Test
    public void testSize()
    {
        LList<String> x = new LList<String>();
        int length = 45;
        x.add("No");
        assertEquals(1, x.size());
        x.clear();
        for(int i = 0; i < length; i++)
        {
            x.add("Hello");
        }
        assertEquals(length, x.size());
    }
    // Test to see if the clear method does what it should do 
    @Test
    public void testClear()
    {
        LList<String> x = new LList<String>();
        x.add("No");
        assertEquals(1, x.size());
        x.clear();
        assertEquals(0, x.size());
        x.add("Pompeii");
        assertEquals(1, x.size());
        x.clear();
        assertEquals(0, x.size());
        x.clear();
        assertEquals(0, x.size());
        x.add("Ryan");
        assertEquals(1, x.size());
        x.clear();
        assertEquals(0, x.size());
    }
    
    @Test
    public void testGet()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.add("Jane");
        x.add("Bob");
        assertEquals(4, x.size());
        assertEquals(" 0:Bob 1:Jane 2:Sue 3:Jim", x.toString());
        assertEquals("Bob", x.get(1));
        assertEquals("Jane", x.get(2));
        assertEquals("Sue", x.get(3));
        assertEquals("Jim", x.get(4));
    }
    
    // When working test the exception in the get(index) method
    @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetException()
    {
        LList<String> x = new LList<String>();
        x.add("Hello");
        x.get(1);
    }
    
    @Test
    public void testToString()
    {
        LList<String> x = new LList<String>();
        x.add("str1");
        assertEquals(" 0:str1", x.toString());
        x.add("str2");
        assertEquals(" 0:str2 1:str1", x.toString());
        x.add("str3");
        assertEquals(" 0:str3 1:str2 2:str1", x.toString());
        x.clear();
        assertEquals("", x.toString());
    }
    
    @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testInsertException()
    {
        LList<String> x = new LList<String>();
        x.add("Ryan");
        x.insert("Nope", -1);
    }
    
    @Test
    public void testInsert()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.add("Jane");
        x.add("Bob");
        x.insert("Tom", 2);
        assertEquals(" 0:Bob 1:Jane 2:Tom 3:Sue 4:Jim", x.toString());
    }
    
    @Test
    public void testInsertFirst()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.insert("Bob", 0);
        assertEquals(" 0:Bob 1:Sue 2:Jim", x.toString());
    }
    
    @Test
    public void testInsertLast()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.insert("Bob", 2);
        assertEquals(" 0:Sue 1:Jim 2:Bob", x.toString());
    }
    
    @Test
    public void testDelete()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.add("Jane");
        x.add("Bob");
        x.delete(0);
        assertEquals(" 0:Jane 1:Sue 2:Jim", x.toString());
        assertEquals(3, x.size());
        x.delete(2);
        assertEquals(" 0:Jane 1:Sue", x.toString());
        assertEquals(2, x.size());
    }
    
    @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testDeleteException()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.add("Jane");
        x.add("Bob");
        x.delete(5);
    }
    
    @Test
    public void testIndexOf()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.add("Jane");
        x.add("Bob");
        assertEquals(0, x.indexOf("Bob"));
        assertEquals(1, x.indexOf("Jane"));
        assertEquals(2, x.indexOf("Sue"));
        assertEquals(3, x.indexOf("Jim"));
        assertEquals(-1, x.indexOf("NoValue"));
    }
    
    @Test
    public void testContains()
    {
        LList<String> x = new LList<String>();
        x.add("Jim");
        x.add("Sue");
        x.add("Jane");
        x.add("Bob");
        assertEquals(true, x.contains("Bob"));
        assertEquals(true, x.contains("Jane"));
        assertEquals(true, x.contains("Sue"));
        assertEquals(true, x.contains("Jim"));
        assertEquals(false, x.contains("NoValue"));
    }
    
}