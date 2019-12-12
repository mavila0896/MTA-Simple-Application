import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//I used a Hashmap since it's alot safer. This will take the 2 txt files and store them in the file designated below.
public class HashStorage {

	public static void main(String[] args) throws IOException {

		HashMap<String, String> HM = new HashMap<String, String>();

		//Creates the Strng and will pass along the txt file and assigns it as a key and a value
		//Checks if its valid.
		String line;
		BufferedReader br = new BufferedReader(new FileReader("UserPassList.txt"));
		while ((line = br.readLine()) != null) {
			String[] Array = line.split(" ");
				if (Array.length >= 2) {
					String key = Array[0];
					String value = Array[1];
					HM.put(key, value);
			}
			else {
				System.out.println("Overriding..." + line);
			}
		}
		for (String key : HM.keySet()) { // for
			System.out.println(key + " " + HM.get(key));
		}
		br.close();
	}
}