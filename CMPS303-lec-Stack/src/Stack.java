/**
 * 2 * A collection of objects that are inserted and removed according to the
 * last-in 3 * first-out principle. Although similar in purpose, this interface
 * differs from 4 * java.util.Stack. 5 * 6 * @author Michael T. Goodrich 7
 * * @author Roberto Tamassia 8 * @author Michael H. Goldwasser 9
 */
public interface Stack<E> {
	/**
	 * 13 * Returns the number of elements in the stack. 14 * @return number of
	 * elements in the stack 15
	 */
	int size();

	/**
	 * 19 * Tests whether the stack is empty. 20 * @return true if the stack is
	 * empty, false otherwise 21
	 */
	boolean isEmpty();

	/**
	 * 25 * Inserts an element at the top of the stack. 26 * @param e the element to
	 * be inserted 27
	 */
	void push(E e);

	/**
	 * 31 * Returns, but does not remove, the element at the top of the stack. 32
	 * * @return top element in the stack (or null if empty) 33
	 */
	E top();

	/**
	 * 37 * Removes and returns the top element from the stack. 38 * @return element
	 * removed (or null if empty) 39
	 */
	E pop();
}