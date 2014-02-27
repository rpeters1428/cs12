/*
 * Program Name: BetterArray.java
 * Date:    2/4/2014
 * Class:   CS-13 Spring 2014
 * Name:    Ryan Peters
 */

public class BetterArray<T>
{
    // Variables to be used throughout the class
    private T[] arr;
    private int length;   // The "illusion" size of the array
    // Constructor
    public BetterArray()
    {
        arr = (T[]) new Object[10];
        length = 0;
    }
    // Methods
    // Add always adds to the end of the array...extend it if over length
    public void add(T s)
    {
        if (length < arr.length)
        {
            arr[length] = s;
            length++;
        }
        else // length == arr.length
        {
            // Need to extend the size of the array by 50% in size
            int newLength = (int)(arr.length * 1.5);
            T[] newArr;
            newArr = (T[]) new Object[newLength];
            for (int i = 0; i < arr.length; i++)
            {
                newArr[i] = arr[i];
            }
            
            arr = newArr;
            
            arr[length] = s;
            length++;
        }
    }
    // Set last element to null
    // Reduce length
    public void remove()
    {   // If the last element in the array "length" doesn't equal null
        if(arr[length - 1] != null)
        {
            arr[length] = null;
            length--;
        }
        else
        {   // Else throw an exception showing that the "length" is out of bounds
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
    }
    // Return all the elements of the array in the form
    // 0:elem0, 1:elem1, 2:elem2
    public String toString()
    {
        // Start with an empty string
        // Use a loop to build it up
        // Return it at the end.
        String s = "";
        for(int i = 0; i < length; i++) 
        {
            s = s + i + ":" + arr[i] + ", ";
        }
        s = s.replaceAll(", $", "");
        return s;
    }
    // Return the size of the array using "length" instead of arr.length
    public int size()
    {
        return length;
    }
    // Replace element at given index with s
    // Throw exception if out of bounds
    public void set(int index, T s)
    {
        if(index < length && length >= 0)
        {
             arr[index] = s;       
        }
        else
        {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
    }
    // Get the element by passing an index
    public T get(int index)
    {
        if(index < length && length >= 0)
        {
            return arr[index];
        }
        else
        {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
    }
    // Insert String at given index and move all Strings one slot over to the right
    public void insert(int index, T s)
    {
        if(length < arr.length)
        {
            if(index < length && index >= 0)
            {
                for(int i = 0; i <= length-index; i++)
                {
                    arr[length-i+1] = arr[length-i];
                }
                arr[index] = s;
                length++;
            }
            else
            {
                throw new java.lang.ArrayIndexOutOfBoundsException();
            }
        }
        else    // If the index is over the "length"
        {
            // Need to extend the array
            int newLength = (int)(arr.length * 1.5);
            T[] newArr;
            newArr = (T[]) new Object[newLength];
            for (int i = 0; i < arr.length; i++)
            {
                newArr[i] = arr[i];
            }
            
            arr = newArr;
            
            arr[length] = s;
            length++;
            
            System.out.println("Hello My Name is Ryan Peters");
        }
    }
    // Delete given String at the given index and move Strings over to the left
    public void delete(int index)
    {
        if(index < length && index >= 0)
        {
            for(int i = 0; i <= length - index; i++)
            {
                arr[index + i] = arr[index + 1 + i];
            }
            length--;
        }
        else    // Again if "length" is too high or under 0 (negative) then throw exception
        {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
    }
    // Find at what index the string is at 
    // in the array if not in array return -1 as an int value
    public int indexOf(T s)
    {
        for(int i = 0; i < length; i++)
        {
            if(arr[i].equals(s))
            {
                return i;
            }
        }
        return -1;
    }
    // Find out if String is in the array
    public boolean contains(T s)
    {
        for(int i = 0; i < length; i++)
        {
            if(arr[i].equals(s))
            {
                return true;
            }
        }
        return false;
    }
}
