package project;

import java.io.Serializable;

public class TreeTable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Tree[] hashArray; // array holds hash table
	private Tree defunct; // for deleted trees

	public TreeTable() {
		hashArray = new Tree[21];
		defunct = new Tree(); // deleted tree
		// insert student in the root of the defunct tree
		defunct.insert(new Student(000000000, "null", 0.0));
	}

	public int hashFunc(int key) {
		return key % 20;
	}

	public boolean isFull() {
		for (int i = 0; i < 21; i++)
			if (hashArray[i] == null || hashArray[i] == defunct)
				return false;
		return true;
	}

	/**
	 * 
	 * @param current
	 * @return getting the year of the node
	 */

	public int getYearOfTheHashNode(Tree current) {
		String id = String.valueOf(current.getRoot().getStudent().getId());
		if (id.length() < 4) {
			return 0;
		} // substring error fixed
		int year = Integer.valueOf(id.substring(0,4));
		return year;
	}

	/**
	 * 
	 * @param year
	 * @return node tree of the hashTable
	 */
	public Tree findHashNode(int year) {
		int hashVal = hashFunc(year);
		int start = hashVal;
		boolean checkAll = false;
		while (hashArray[hashVal] != null && !checkAll) {
			if (getYearOfTheHashNode(hashArray[hashVal]) == year)
				return hashArray[hashVal];
			++hashVal;
			hashVal %= 21;
			if (hashVal == start)
				checkAll = true;
		}
		return null;
	}

	/**
	 * what is required to insert a student in the treeTable how to do it
	 * 
	 */
	public void insert(Student s) {
		if (!isFull()) {
			String str_id = String.valueOf(s.getId()); // extract id and convert to string
			int year = Integer.valueOf(str_id.substring(0, 3));// get year of that id
			Tree t = findHashNode(year);// get the tree of that year
			if (t != null) {// if already exist students in this year add the student s to the Tree
				if (t.find(s.getId()) == null)
					t.insert(s);
				else {
					System.out.println("Student with this ID already in University");
					return;
				}
			} else {
				// no students in this year
				// create New Tree and add student s to the Tree
				Tree tree = new Tree();
				tree.insert(s);
				int hashVal = hashFunc(year);
				while (hashArray[hashVal] != null && hashArray[hashVal] != defunct) {
					++hashVal; // go to next cell
					hashVal %= 21; // wrap around if necessary
				}
				hashArray[hashVal] = tree; // insert item
			}

		}
	}

	/**
	 * 
	 * @param id
	 * @return finding a student by his id in the treeTable how to do it
	 */

	public Student find(int id) {
		String str_id = String.valueOf(id);
		int year = Integer.valueOf(str_id.substring(0, 4));
		int hashVal = hashFunc(year);
		int start = hashVal;
		boolean checkAll = false;
		while (hashArray[hashVal] != null && !checkAll) {
			if (getYearOfTheHashNode(hashArray[hashVal]) == year)
				return hashArray[hashVal].find(id);
			++hashVal; // go to next cell
			hashVal %= 21;
			if (hashVal == start)
				checkAll = true;
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return method if the id is the same then remove him or delete him in the
	 *         treeTable how to do it
	 */
	public boolean remove(int id) {
		String str_id = String.valueOf(id);
		int year = Integer.valueOf(str_id.substring(0, 4));
		int hashVal = hashFunc(year);
		int start = hashVal;
		boolean checkAll = false;
		while (hashArray[hashVal] != null && !checkAll) {
			if (getYearOfTheHashNode(hashArray[hashVal]) == year) {
				if (hashArray[hashVal].remove(id)) {// student found and removed
					if (hashArray[hashVal].getRoot() == null)// if it was 1 student and deleted
						hashArray[hashVal] = defunct; // delete hash tree
					return true;
				}
			}
			++hashVal; // go to next cell
			hashVal %= 21; // wrap around if necessary
			if (hashVal == start) // if we compare all and go back
				// to the same start index
				checkAll = true;
		}
		return false;
	}

	/**
	 * 
	 * @param year students record updated successfully
	 */
	public void printStudent(int year) {
		Tree t = findHashNode(year);
		if (t == null)
			System.out.println("students information updated successfully ");
		else
			t.inOrder(t.getRoot());
	}

	/**
	 * method for displaying all of the students
	 * 
	 * public void printAll() { Tree t = null; for (int j = 0; j < 20; j++) { t =
	 * hashArray[j]; if (t != null && t != defunct) {
	 * System.out.printf("--------------------------- %d
	 * ---------------------------\n", getYearOfTheHashNode(t));
	 * t.preOrder(t.getRoot()); } } }
	 */

}
