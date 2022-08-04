import java.util.NoSuchElementException;
import java.util.Stack;

public class StudentLinkedList {
    private Node head;
    private Stack<Pair> actions;

    public StudentLinkedList() {
        this.head = null;
        actions = new Stack<Pair>();
    }
    // Requirement 1
    public boolean addStudent(Student sv) {
        // code here
		if(head == null || head.getData().getId() > sv.getId()){
            head = new Node(sv, head);
        }
        else if(sv.getId() > head.getData().getId()){
			Node tmp = head;
            while (tmp.getNext() != null && sv.getId() >= tmp.getNext().getData().getId()) {
				tmp = tmp.getNext();
                if (tmp.getData().getId() == sv.getId()) {
                    return false;
                }
            }
            Node nNode = new Node(sv, tmp.getNext());
            tmp.setNext(nNode);
		}
		return true;
	}

    // Requirement 2
	public boolean deleteStudent(int id) {
        // code here
        if (head != null && head.getData().getId() == id) {
            head = head.getNext();
            return true;
        }
        if (head == null ) { 
            return false; 
        }

        Node preNode = null;
        Node delNode = head;

        while (delNode.getNext() != null) {
			preNode = delNode;
            delNode = delNode.getNext();
            if (delNode.getData().getId() == id) {
			    preNode.setNext(delNode.getNext());
			    delNode.setNext(null);
				return true;
            }
        }   

        return false;
    }

    // Requirement 3
    public boolean modifyName(int id, String name) {
        // code here
        return true;
    }

    // Requirement 4
    public Student getHighestScore() {
        // code here
        return null;
    }

    // Requirement 5
    public StudentLinkedList getGraduateStudents(int year) {
        // code here
        return null;
    }

    // Requirement 6
    public StudentLinkedList findByName(String str) {
        // code here
        return null;
    }

    // Requirement 7
    public boolean undo() {
        // code here
        return true;
    }

    // Student don't modify the methods below

    public String toString() {
        String result = "";
        if (head == null) {
            return "No item";
        }
        Node temp = head;
        while (temp.getNext() != null) {
            result += temp.getData() + "\n";
            temp = temp.getNext();
        }
        return result += temp.getData();
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}
