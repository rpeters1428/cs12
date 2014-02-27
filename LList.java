/*
 * File Name: LList.java
 * Name:      Ryan Peters
 * Date:      2/19/2014
 * 
 */
public class LList<T>
{
    private Node head;
    private Node tail;
    private Node next;
    private int size;
    
    // Constructor sets a new Node at value null
    public LList()
    {
        Node<T> a = new Node<T>();
        a.setValue(null);
        size = 0;
    }
    
    // Add to the head of the linked list (string)
    public void add(T v)
    {
        Node<T> b = new Node<T>();
        b.setValue(v);
        b.setLink(head);
        head = b;
        size++;
    }
    
    // Return the size of the linked list using a counter
    public int size()
    {
        return size;
    }
    
    public T get(int index)
    {
        if(index < 0 || index > size)
        {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        else
        {
            Node<T> a = head;
            for (int i = 0; i < index-1; i++)
            {
                a = a.getLink();
            }
            return a.getValue();
        }
    }
    
    // Clearing out the linked list to null
    public void clear()
    {
        head = null;
        size = 0;
    }
    
    // Returning the value(s) (int) of the linked list
    public String toString()
    {
        Node<T> i = head;
        String s = "";
        int l = 0;
        
        while (i != null)
        {
            s += " " + l + ":" + i.getValue();
            i = i.getLink();
            l++;
        }
        return s;
    }
    
    public void remove()
    {
        if (head != null)
        {
            head = head.getLink();
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
    }
    
    public void insert(T v, int index)
    {
        if (index < 0 || index > size)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        if (index == 0)
        {
            add(v);
        }
        else
        {
            // Hop down index-1 Nodes
            Node<T> current = head;
            for (int i = 0; i < index-1; i++)
            {
                current = current.getLink();
            }
            
            Node<T> newNode = new Node<T>();
            newNode.setValue(v);
            newNode.setLink(current.getLink());
            current.setLink(newNode);
        }
        size++;
    }
    
    public void delete(int index)
    {
        if (index < 0 || index > size)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        else
        {
            Node<T> current = head;
            if (index == 0)
            {
                remove();
            }
            else if (index == size)
            {
                for (int i = 0; i < index - 1; i++)
                {
                    current = current.getLink();
                }
                
                current = null;
                size--;
            }
            else
            {
                for (int i = 0; i < index - 1; i++)
                {
                    current = current.getLink();
                }
                current.setLink(current.getLink().getLink());
                size--;
            }
        }
    }
    
    public int indexOf(T v)
    {
        Node<T> n = head;
        int c = 0;
        if (n.getValue() == v)
        {
            return c;
        }
        for (int i = 0; i < size - 1; i++)
        {
            n = n.getLink();
            c++;
            if(n.getValue() == v)
            {
                return c;
            }
        }
        return -1;
    }
    
    public boolean contains(T v)
    {
        Node<T> n = head;
        int c = 0;
        if (n.getValue() == v)
        {
            return true;
        }
        for (int i = 0; i < size - 1; i++)
        {
            n = n.getLink();
            c++;
            if(n.getValue() == v)
            {
                return true;
            }
        }
        return false;
    }
}