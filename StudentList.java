import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		for (int len = 0; len < args.length; ++len) {
			if (args[len].equals("a")) {
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					String studentList[] = r.split(", ");
					for (String studentName : studentList) {
						System.out.println(studentName);
					}
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[len].equals("r")) {
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					// System.out.println(r);
					String studentList[] = r.split(", ");
					Random rand = new Random();
					int id =rand.nextInt(0, 4);
					System.out.println(studentList[id]);
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			} else if (args[len].contains("+")) {
				System.out.println("Loading data ...");
				try {
					BufferedWriter s = new BufferedWriter(
							new FileWriter("students.txt", true));
					String newStudent = args[len].substring(1);
					Date d = new Date();
					String df = "dd/mm/yyyy-hh:mm:ss a";
					DateFormat dateFormat = new SimpleDateFormat(df);
					String formattedDate = dateFormat.format(d);
					s.write("," + newStudent + "\nList last updated on " + formattedDate);
					s.close();
				} catch (Exception e) {

				}

				System.out.println("Data Loaded.");
			} else if (args[len].contains("?")) {
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					String studentList[] = r.split(",");
					boolean done = false;
					String newStudent = args[len].substring(1);
					for (int idx = 0; idx < studentList.length && !done; idx++) {
						if (studentList[idx].equals(newStudent)) {
							System.out.println("We found it!");
							done = true;
						}
					}
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[len].contains("c")) {
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String D = s.readLine();
					char a[] = D.toCharArray();
					boolean in_word = false;
					int count = 0;
					for (char c : a) {
						if (c == ' ') {
							if (!in_word) {
								count++;
								in_word = true;
							} else {
								in_word = false;
							}
						}
					}
					System.out.println(count + " word(s) found");
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			}
		}
	}
}