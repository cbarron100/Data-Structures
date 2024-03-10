package CircularList;
import java.util.Iterator;


public class CircularDoublyLinkedList<E> implements Iterable<E>{

	private Node<E> head, tail;
	private int size = 0;

	private static class Node<E>{
		private Node<E> next, previous;
		private E data;
		public Node(E data){
			this.data = data;
			this.next = this.previous = null;
		}
	}

	public CircularDoublyLinkedList(){
		head = null;
		tail = null;
		head.previous = tail;
		tail.next = head;
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.size == 0;
	}

	public void addFirst(E element){
		Node<E> newNode = new Node<>(element);
		if(isEmpty()){
			head = newNode;
			head.next = tail;
			head.previous = tail;
		}else{
			newNode.next = head;
			newNode.previous = tail;
                 	newNode = head;
		}
		this.size++;
	}

	public void addLast(E element){
		Node<E> newNode = new Node(element);
		if(isEmpty()){
			newNode.next = head;
			newNode.previous = head;
		}else{
			newNode.next = head;
			newNode.previous = tail;
			newNode = tail;
		}
		size++;
	}

	public boolean contains(E element) throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}
		Node<E> curNode = head;
		E headData = head.data;
		while(!curNode.data.equals(element)){
			if(curNode.next.equals(headData)){//means we have gotten to the tail and we will start again
				break;
			}
			curNode = curNode.next;
		}
		if(curNode.data.equals(element)){
			return true;
		}
		return false;

	}

	public void addAfter(E key, E element) throws RuntimeException{
		if(contains(key)){
			Node<E> newNode = new Node(element);
			Node<E> curNode = head;
			while(!curNode.previous.equals(key)){
				curNode = curNode.next;
			}
			curNode.previous.next = newNode;
			newNode.next = curNode;
			size++;
		}else{
			throw new RuntimeException("No such element found");
		}
	}


	public E removeFirst() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}

		E removed = head.data;
		if(size == 1){
			head = null;
			tail = null;
			return removed;
		}else{
			head = head.next;
			tail.next = head;
			head.previous = tail;
		}
		size--;
		return removed;

	}



	public E removeLast() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}

		E removed = tail.data;
		if(size == 1){
			tail = null;
			head = null;
		}else{
			tail = tail.previous;
			tail.next = head;
			head.previous = tail;
		}
		size--;
		return removed;
	}


	public void remove(E element) throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");

		}else if(size == 1){
			if(head.data.equals(element)){
				removeFirst();
			}else if(tail.data.equals(element)){
				removeLast();
			}else{
				throw new RuntimeException("Neither head nor tail has such element when size is " + this.size);
			}
		}else if(contains(element)){

			Node<E> curNode = head;
			while(curNode.next != head){
				if(curNode.data.equals(element)){
					curNode.previous.next = curNode.next;
					curNode.next.previous = curNode.previous;
					return;
				}
				curNode = curNode.next;
			}

			if(curNode.data.equals(element)){
				removeLast();
				return;
			}


		}else{
			throw new RuntimeException("Element is not in list");
		}
	}


	public void clear() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is Empty");
		}else{
			Node<E> curNode = head;
			while(curNode.next != tail){
				curNode = curNode.next;
				curNode.previous = null;
			}
			curNode = tail;
			curNode.previous = null;
			removeLast();
		}

	}

	public CircularDoublyLinkedList<E> rotate() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}else if(this.size == 1){
			throw new RuntimeException("Cannot rotate single element");
		}else{
			CircularDoublyLinkedList<E> newList = new CircularDoublyLinkedList<>();
			Node<E> curNode = tail;
			while(curNode.previous != head ){
				E data = curNode.data;
				if(curNode == tail){
					newList.addFirst(data);
				}else{
					newList.addLast(data);
				}
				curNode = curNode.previous;
			}
			newList.addLast(head.data);
			return newList;
		}

	}


	public String display(){
		if(isEmpty()){
			return "[]";
		}else{
			String list = "";
			Node<E> curNode = head;
			while(curNode != tail){
				if(curNode == head){
					list = list + "[" + head.data.toString() + ", ";
				}else{
					list = list + curNode.data.toString() + ", ";
				}
				curNode = curNode.next;
			}
			list = list + tail.data.toString() + "][" + head.data.toString();
			return list;

		}

	}

	public Node<E> getFirstNode() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}else{
			return head;
		}
	}


	public Node<E> getLastNode() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is emptry");
		}else{
			return tail;
		}
	}
}
