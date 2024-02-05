package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Map<String, Integer> candidates = new TreeMap<>();

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);

				if (candidates.containsKey(name)) {
					int VotesSoFar = candidates.get(name);
					candidates.put(name, votes + VotesSoFar);
				} else {
					candidates.put(name, votes);
				}
				line = br.readLine();
			}

			for(String key : candidates.keySet()) {
			System.out.println(key + ": " + candidates.get(key));
			}
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			;
		}

		sc.close();
	}

}
