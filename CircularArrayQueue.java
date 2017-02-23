import java.util.Arrays;

public class CircularArrayQueue<T> implements IQueue<T> {

	private int head;
	private int tail;
	private int capacity;
	private Object[] elements;

	public CircularArrayQueue(int capacity) {
		this.capacity = capacity;

		elements = new Object[capacity];
		head = 0;
		tail = 0;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return head == 0 && tail == 0;
	}

	@Override
	public boolean offer(T item) {
		// TODO Auto-generated method stub

		if (elements[head] == null) {
			elements[head] = item;
		} else {
			tail = incrementIndex(tail);

			if (elements[tail] == null) {
				elements[tail] = item;
			} else {

				Object[] temp = elements;
				elements = new Object[capacity * 2];

				for (int i = 0, j = head; i < temp.length; ++i) {

					elements[i] = temp[j];
					j = incrementIndex(j);
				}

				capacity *= 2;

				head = 0;
				tail = temp.length;

				elements[tail] = item;
			}

		}

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T poll() {
		Object o = elements[head];
		elements[head] = null;
		head = incrementIndex(head);
		return (T) o;
	}

	private int incrementIndex(int n) {
		if (n + 1 == capacity) {
			n = 0;
		} else {
			n++;
		}

		return n;
	}

	public int decrementIndex(int n) {
		if (n - 1 == -1) {
			n = capacity - 1;
		} else {
			n--;
		}

		return n;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		return (T) elements[head];
	}

	public String toString() {
		return Arrays.toString(elements);
	}

	public static void main(String[] args) {
		CircularArrayQueue<Integer> a = new CircularArrayQueue<>(10);
		a.offer(1);
		a.offer(2);
		a.offer(3);
		a.offer(4);
		a.offer(5);
		a.offer(6);
		a.offer(7);
		a.offer(8);
		a.offer(9);
		System.out.println(a);
		System.out.println("NEXT: " + a.poll());
		System.out.println("NEXT: " + a.poll());
		System.out.println("NEXT: " + a.poll());
		System.out.println(a);
		a.offer(10);
		System.out.println(a);
		a.offer(11);
		System.out.println(a);
		a.offer(12);
		System.out.println(a);
		System.out.println("NEXT: " + a.poll());
		System.out.println(a);
		a.offer(13);
		System.out.println(a);
		a.offer(14);
		System.out.println(a);
		a.offer(15);
		System.out.println(a);
		System.out.println("NEXT: " + a.poll());
		System.out.println(a);
	}
}
