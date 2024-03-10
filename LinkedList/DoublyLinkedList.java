package LinkedList;
import java.util.Iterator;


public class DoublyLinkedList<E> implements Iterable<E>{
	private Node<E> head;
	private int size;

	private static class Node<E>{
		private Node<E> next, previous;
		private E data;

		public Node(E data, Node<E> next, Node<E> previous){
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
	}



	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void addFirst(E element){
		Node<E> newNode = new Node<>(element, head, null);
		head = newNode;
		size++;

	}

	public void addLast(E element){
		if(isEmpty()){
			this.addFirst(element);
		}else{
			Node<E> newNode = new Node<E>(element, null, null);
			Node<E> curNode = head;
			while(curNode.next != null){
				curNode = curNode.next;
			}
			newNode.previous = curNode;
			curNode.next = newNode;
			size++;
		}
	}

	public E removeFirst(){

		if(isEmpty()){
			return null;
		}

		E removed = head.data;
		head = head.next;
		head.previous = null;
		size--;
		return removed;

	}

	public E removeLast(){

		if(isEmpty()){
			return null;
		}
		Node<E> curNode = head;
		while(curNode.next.next != null){
			curNode = curNode.next;
		}
		E removed = curNode.next.data;
		curNode.next = null;
		size--;
		return removed;
	}


	public E getFirst(){
		return head.data;
	}



	public E getLast(){
		if(isEmpty()){
			return null;
		}
		Node<E> curNode = head;
		for(int i = 0; i < size; i++){
			curNode = curNode.next;
		}
		return curNode.data;

	}

	public void add(E element, int index) throws RuntimeException{
		if(index >= size || index < 0){
			throw new RuntimeException("Cannot place Element at index: " + index);
		}

		Node<E> newNode = new Node<>(element, null, null);
		Node<E> curNode = head;
		for(int i = 0; i < index; i++){
			curNode = curNode.next;
		}

		newNode.next = curNode.next;
		newNode.previous = curNode;
		size++;
	}



	public E remove(int index) throws RuntimeException{

		if( index >= size || index < 0){
			throw new RuntimeException("Cannot remove element at index: " + index);
		}
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}
		Node<E> curNode = head;
		for(int i = 0; i < index; i++){
			curNode = curNode.next;
		}
		E removed = curNode.data;
		curNode.next.previous = curNode.previous;
		curNode.previous.next = curNode.next;
		size--;
		return removed;
	}


	public E get(int index) throws RuntimeException{
		if(index >= size || index < 0){
			throw new RuntimeException("Index too large or less than 0");
		}
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}

		Node<E> curNode = head;
		for(int i = 0; i < size; i++){
			curNode = curNode.next;
		}
		return curNode.data;
	}

	public void clear() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}
		Node<E> curNode = head;
		while(curNode.next != null){
			curNode.previous = null;
			curNode = curNode.next;
		}
	}

	public boolean contains(E element){

		if(isEmpty()){
			return false;
		}

		Node<E> curNode = head;
		while(curNode.next != null){
			if(curNode.data.equals(element)){
				return true;
			}
			curNode = curNode.next;
		}
		return false;
	}

	public int indexOf(E element) throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}
		Node<E> curNode = head;
		int i = 0;
		while(curNode.next != null){
			if(curNode.data.equals(element)){
				return i;
			}
			curNode = curNode.next;
			i++;
		}

		throw new RuntimeException("Element not in list");
	}



	public int lastOccuranceOf(E element) throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}

		Node<E> curNode = head;
		int occurance = -1;
		int i = 0;
		while(curNode.next != null){
			if(curNode.data.equals(element)){
				occurance = i;
			}
			curNode = curNode.next;
			i++;

		}
		return occurance;
	}

	public Iterator<E> iterator(){
		return new Iterator(){

			Node<E> current = head;

			@Override
			public boolean hasNext(){
				return current.next != null;
			}

			@Override
			public E next(){
				if(hasNext()){
					E data = current.data;
					current = current.next;
					return data;
				}
				return null;
			}

			@Override
			public void remove(){
				throw new RuntimeException("No valid oeration");
			}
		};
	}
}


