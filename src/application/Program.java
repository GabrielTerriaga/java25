package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuintes;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuintes> list = new ArrayList<>();
		
		System.out.print("Enter the number os tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char select = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double income = sc.nextDouble();
			
			if (select == 'i') {
			System.out.print("Health expenditures: ");
			double healthExpend = sc.nextDouble();
			
			list.add(new PessoaFisica(name, income, healthExpend));
			}
			else if (select == 'c') {
				System.out.print("Number of employees: ");
				int numberEmployee = sc.nextInt();
				
				list.add(new PessoaJuridica(name, income, numberEmployee));
			}//end if select
		}//end for
		
		//varaivel para somar tudo
		double sum = 0.0;
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for (Contribuintes c : list) {
			System.out.println(c.getNome() + ": $ " + String.format("%.2f", c.impostoPago()));
			sum += c.impostoPago();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

		
		sc.close();
	}

}
