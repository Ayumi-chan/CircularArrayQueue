
public interface IQueue<T> {

	public boolean empty();
	public boolean offer(T item);
	public T poll();
	public T peek();
}
