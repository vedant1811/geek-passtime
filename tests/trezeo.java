// Assuming the Lifo class is defined with the following signature:
public class Lifo<T>
{
 // Push an item on the top of the stack
 public void Push(T item);
 // Remove the last pushed item from the stack and return it
 public T Pop();
}

// Implement a Fifo class with “first-in first-out” semantics using only the Lifo class as defined above. The
// Fifo class must have the following signature:
public class Fifo<T>
{

  // new items are always added to main stack
  private Lifo<T> main = new Lifo<T>();

  // items are popped from the auxilary stack
  // if this stack is empty, then items from main are moved here and then returned
  private Lifo<T> auxilary = new Lifo<T>();

  // Push an item into the queue
  // Time complexity is always O(1)
  public void Enqueue(T item)
  {
    main.Push(item);
  }

  // Remove the oldest item from the queue and return it
  // Time complexity is O(n) in worst case
  // But aromatic time complexity is O(1) (since mainToAuxilary() calls will be rare)
  public T Dequeue()
  {
    T fromAux = auxilary.Pop();
    if (fromAux != null)
      return fromAux;

    mainToAuxilary();
    return auxilary.Pop();
  }

  // move all elements from main to auxilary
  private void mainToAuxilary()
  {
    while(true)
    {
      T item = main.Pop();
      if (item != null)
        auxilary.Push(item);
      else
        break;
    }
  }
}
