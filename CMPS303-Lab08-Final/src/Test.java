public class Test {
	
	public static void main(String[] args) {
		LinkedQueue<Character> q1=new LinkedQueue<>();
		
		Stack<Integer> stackInt = new LinkedStack<Integer>();
		stackInt.push(10);
		stackInt.push(20);
		stackInt.push(40);
		stackInt.push(30);
		System.out.println("searchStack: " + searchStack(stackInt,400));
		System.out.println(postfix("57+"));
	}
	
	public static <E>boolean searchStack(Stack<E> s, E e) {
		Stack<E> tmpStack = new LinkedStack<E>();
		boolean found=false;
		while (!s.isEmpty()) {
			if (s.top().equals(e)) {
				found = true; 
				break;
			}
			tmpStack.push(s.pop());
		}
		while (!tmpStack.isEmpty())
			s.push(tmpStack.pop());
		return found;
	}
	
	public static <E>boolean remove(Stack<E> s, E e) {
		Stack<E> tmpStack = new LinkedStack<E>();
		boolean found=false;
		while (!s.isEmpty()) {
			if (s.top().equals(e)) {
				found = true; 
				s.pop();
				break;
			}
			tmpStack.push(s.pop());
		}
		while (!tmpStack.isEmpty())
			s.push(tmpStack.pop());
		return found;
	}
	
	public static <E>boolean searchQueue(Queue<E> q, E e) {
		Queue<E> tmp = new LinkedQueue<E>();
		boolean found=false;
		while (!q.isEmpty()) {
			if (q.first().equals(e)) {
				found = true; 
				break;
			}
			tmp.enqueue(q.dequeue());	//check
		}
		while (!tmp.isEmpty())
			q.enqueue(tmp.dequeue());
		return found;
	}
	
	public static <E>void reverseQueue(Queue<E> q){
		Stack<E> tmpStack= new LinkedStack<E>();
		while (!q.isEmpty()) 
			tmpStack.push(q.dequeue());
		while (!tmpStack.isEmpty())
			q.enqueue(tmpStack.pop());		
	}
	
	public static <E>void removeEven(Stack<Integer> s) {
		Stack<Integer> tmp = new LinkedStack<Integer>();
		while (!s.isEmpty()) {
			if (s.top()%2!=0)
				tmp.push(s.pop());
			else
				s.pop();
		}
		while (!tmp.isEmpty())
			s.push(tmp.pop());
	}
	
	public static <E>boolean recursivesearchStack(Stack<E> s, E e) {
		if (!s.isEmpty())
			return false;
		if (s.top().equals(e))
			return true;
			
		E t=s.pop();
		boolean found=recursivesearchStack(s, e);
		s.push(t);
		return found;	
	}

	public static double postfix(String s) {
		Stack<Double> st = new LinkedStack<Double>();
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				double x=c-'0';
				st.push(x);
				//st.push((double) c);
			}
			else {
				double val1= st.pop();
				double val2= st.pop();
				switch(c) {
				case '+':st.push(val1+val2);break;
				case '-':st.push(val1-val2);break;
				case '*':st.push(val1*val2);break;
				case '/':st.push(val1/val2);break;
				}
			}
		}
		return st.pop();
	}
}