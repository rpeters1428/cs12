/*
 * File Name: Node.java
 * Name:      Ryan Peters
 * Date:      2/19/2014
 * 
 */

public class Node<T>
{
    private T value;
    Node next, previous;
    private Node link;
    
    public T getValue()
    {
        return value;
    }
    
    public void setValue(T v)
    {
        value = v;
    }
    
    public void setLink(Node l)
    {
        link = l;
    }
    
    public Node getLink()
    {
        return link;
    }    
}