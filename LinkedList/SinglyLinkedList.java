package LinkedList;



public class SinglyLinkedList<E>{

	private Node<E> head, tail;
	private int size;

	private static class Node<E>{

		private Node<E> next;
		private E data;
		public Node(E data, Node<E> next){
			this.next = next;
			this.data = data;

		}
	}

	public SinglyLinkedList(){

		head = null;
		tail = null;
		size = 0;

	}



	public int size(){
		return size;
	}


	public boolean isEmpty(){
		return size == 0;
	}

	public void addFirst(E element){
		Node<E> newNode = new Node<>(element, null);
		size++;
	}


	public void addLast(E element){
		Node<E> newNode = new Node<>(element, null);
		if(isEmpty()){
			head = newNode;
		}else {
			Node<E> curNode = head;
			while(curNode.next != null){
				curNode = curNode.next;
			}
			curNode.next = newNode;
		}
		size++;
	}

	public E removeFirst(){
		if(isEmpty()){
			return null;
		}else{
			E removedElement = head.data;
			head = head.next;
			size--;
			return removedElement;

		}
	}

	public boolean remove(E element){

		if(isEmpty()){
			return false;
		}
		if(head.data.equals(element)){
			removeFirst();
			return true;
		}

		Node<E> curNode = head;
		while(!curNode.data.equals(element) && curNode != null){
			curNode = curNode.next;
		}


		if(curNode.next != null){
			curNode.next = curNode.next.next;
			size--;
			return true;
		}

		return false;
	}



	public E get(int position){
		if(isEmpty() || position >= size || position < 0){
			return null;
		}


		Node<E> curNode = head;
		for(int i = 0; i < position; i++){
			curNode = curNode.next;
		}
		return curNode.data;

	}

	public boolean contains(E element){

		if(isEmpty()){
			return false;
		}


		Node<E> curNode = head;

		while(curNode.data != null){
			if(curNode.data.equals(element)){
                        	return true;
                	}
			curNode = curNode.next;
		}

		return false;
	}
}
