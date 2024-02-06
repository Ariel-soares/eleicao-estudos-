package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class App {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();

		System.out.print("Insira o caminho do arquivo: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();			
			}
			
			System.out.print("Insira o salário: ");
			Double salary = sc.nextDouble();
			
			List<String> list2 = (List<String>) list.stream().map(p -> p.getName());
			
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
