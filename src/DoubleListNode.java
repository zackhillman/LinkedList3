import java.io.Serializable;

public class DoubleListNode<T> implements Serializable
{	private T value;
	private DoubleListNode<T> next;
	private DoubleListNode<T> previous;
	public DoubleListNode(){value=null; next=null;previous=null;}
public DoubleListNode(T initValue, DoubleListNode<T> initNext, DoubleListNode<T> initPrevious)
	{
		value=initValue;
		next=initNext;
		previous=initPrevious;
	}
	public T getValue(){ return value;}
	public DoubleListNode<T> getNext(){return next;}
	public DoubleListNode<T> getPrevious(){return previous;}
public void setValue(T newValue){ value=newValue;}
	public void setNext(DoubleListNode<T> newNext){next=newNext;}
public void setPrevious(DoubleListNode<T> newPrevious){previous=newPrevious;}
} 

