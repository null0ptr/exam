import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	static String readFile() throws IOException {
		BufferedReader s=null;
		try {
			 s = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.FILENAME)));
			return s.readLine();
		} catch (Exception e) {
			System.out.println(Constants.NOT_FOUND);
			return null;
		}
		finally {
			s.close();
		}
	}
	public static void main(String[] args) {

		// Check arguments
		for (int len = 0; len < args.length; ++len) {
			if (args[len].equals("a")) {
				System.out.println(Constants.LOADING);
				try {
					String studentList[] = readFile().split(", ");
					for (String studentName : studentList) {
						System.out.println(studentName);
					}
				} catch (Exception e) {
				}
				System.out.println(Constants.LOADED);
			} else if (args[len].equals("r")) {
				System.out.println(Constants.LOADING);
				try {
					String studentList[] = readFile().split(", ");
					int id = new Random().nextInt(0,4);
					System.out.println(studentList[id]);
				} catch (Exception e) {
				}
				System.out.println(Constants.LOADED);
			} else if (args[len].contains("+")) {
				System.out.println(Constants.LOADING);
				try {
					BufferedWriter s = new BufferedWriter(new FileWriter(Constants.FILENAME, true));
					String newStudent = args[len].substring(1);
					String formattedDate = new SimpleDateFormat(Constants.DATE_FORMAT).format(new Date());
					s.write("," + newStudent + "\nList last updated on " + formattedDate);
					s.close();
				} catch (Exception e) {
				}
				System.out.println(Constants.LOADED);
			} else if (args[len].contains("?")) {
				System.out.println(Constants.LOADING);
				try {
					String studentList[] = readFile().split(", ");
					String newStudent = args[len].substring(1);
					boolean found = false;
					for (int idx = 0; idx < studentList.length; idx++) {
						if (studentList[idx].equals(newStudent)) {
							System.out.println(studentList[idx] + Constants.FOUND);
							found = true;
							break;
						}
					}
					if (!found) {
						System.out.println(newStudent + " is not included in the student list");
					}
				} catch (Exception e) {
				}
				System.out.println(Constants.LOADED);
			} else if (args[len].contains("c")) {
				System.out.println(Constants.LOADING);
				try {
					char a[] = readFile().toCharArray();
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
				System.out.println(Constants.LOADED);
			}
		}
	}
}