public class CountedElement<E extends Comparable<E>> implements Comparable<CountedElement<E>> {
	private E element;
	private int count;

	public CountedElement(E e, int count){
		element = e;
		this.count = count;
	}
	
	public CountedElement(E e){
		element = e;
		count = 1;
	}

	public int getCount() {
		return count;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public String toString() {
		return (String) "(" + element + ", " + count + "), ";
	}
	
	public int compareTo(CountedElement<E> sC1) {
		if(this.getElement().compareTo(sC1.getElement())  == 0) {
			count++;
			sC1.count++;
		}
		return this.getElement().compareTo(sC1.getElement());		
	}
}
