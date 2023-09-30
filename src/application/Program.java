package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Instatllment;
import services.ContractServices;

public class Program {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy");
		
		
		System.out.println("Entre com o número do contrato: ");
		System.out.print("Numero do contrato: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy)");
		LocalDate date = LocalDate.parse(sc.next(),fmt);
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue); 
		
		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();
		
		ContractServices contractServices = new ContractServices(null);
		
		contractServices.processContract(obj, n);
		
		
		System.out.println("____Parcelas______");
		for (Instatllment instatllment : obj.getInstatllment()) {
			System.out.println(instatllment);
		}
		
		
		
		sc.close();

	}
	

}
