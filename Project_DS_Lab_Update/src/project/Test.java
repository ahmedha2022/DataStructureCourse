package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTable tb = new TreeTable();
		Scanner input = new Scanner(System.in);
		int choice = 0, id, year;
		double gpa;
		String str_id;

		try {
			do {
				System.out.println("\n1- Add New Student ");
				System.out.println("2- Search for a Student ");
				System.out.println("3- Delete a Student ");
				System.out.println("4- Exit");
				System.out.println("choose from (1 to 4) ");
				choice = input.nextInt();

				switch (choice) {

				case 1:
					Student s = new Student();
					do {
						System.out.print("Enter Student id (yyyy-----): ");
						id = input.nextInt();
						input.nextLine();
						str_id = String.valueOf(id);
						if (str_id.length() <= 4)
							System.out.println("Invalid Id");
					} while (str_id.length() <= 4);

					s.setId(id);
					System.out.print("Enter Student Name : ");
					s.setName(input.nextLine());

					System.out.print("Enter Student GPA : ");
					s.setGpa(input.nextDouble());
					input.nextLine();
					tb.insert(s);
					saveToFile(tb);
					break;

				case 2:
					do {
						tb = loadData();
						System.out.print("Enter Student id to search : (yyyy-----): ");
						id = input.nextInt();
						input.nextLine();
						str_id = String.valueOf(id);
						if (str_id.length() <= 4)
							System.out.println("Invalid Id");
					} while (str_id.length() <= 4);

					if (tb.find(id) == null)
						System.out.println("Student was not found!");
					else
						System.out.println(tb.find(id));
					break;

				case 3:
					do {
						tb = loadData();
						System.out.print("Enter Student id to delete: (yyyy-----): ");
						id = input.nextInt();
						input.nextLine();
						str_id = String.valueOf(id);
						if (str_id.length() <= 4)
							System.out.println("Invalid Id");
					} while (str_id.length() <= 4);
					if (!tb.remove(id))
						System.out.println("Student was not found!");
					else
						System.out.println("Student has been removed");
					break;

				case 4:
					System.out.println("See you later");

					break;
				default:
					System.out.println("Invalid choice !");
					break;

				}// switch
			} while (choice != 4);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		input.close();
	}// main

	public static void saveToFile(TreeTable h) {
		try {
			// FileOutputStream CREATION
			FileOutputStream fos = new FileOutputStream("treeTable.ser");
			// ObjectOutputStream CREATION
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// WRITE Set OBJECT TO ObjectOutputStream
			oos.writeObject(h);
			// CLOSE THE ObjectOutputStream
			oos.close();
			System.out.println("HashTable Saved into File Sucessfully");
		} catch (Exception e) {
			System.out.println("Error Occurred : " + e.getMessage());
		}
	}

	public static TreeTable loadData() {
		TreeTable t = new TreeTable();
		try {
			// FileInputStream CREATION
			FileInputStream fis = new FileInputStream("treeTable.ser");
			// ObjectInputStream CREATION
			ObjectInputStream ois = new ObjectInputStream(fis);
			// READ Hashtable OBJECT FROM ObjectInputStream
			t = (TreeTable) ois.readObject();
			ois.close();
			System.out.println("HashTable Read from File Sucessfully");
		} catch (Exception e) {
			System.out.println("Error Occurred : " + e.getMessage());
		}
		return t;
	}

}
