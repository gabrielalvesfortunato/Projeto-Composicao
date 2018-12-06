package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do Departamento: ");
		String departmentName = scan.nextLine();
		System.out.println("\nEntre com os dados do Funcionario: ");
		System.out.print("Nome: ");
		String workerName = scan.nextLine();
		System.out.print("Hierarquia: ");
		String workerLevel = scan.nextLine().toUpperCase();
		System.out.print("Salario base: ");
		Double baseSalary = scan.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

		System.out.println();

		System.out.print("Quantos contratos esse Funcionario tera? ");
		int n = scan.nextInt();
		
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.println("\nEntre com o contrato #" + (i+1) + " data:");
			System.out.print("Data (DD/MM/YYYY): ");
			Date contractDate = dateFormat.parse(scan.next());
			System.out.print("Valor Por Hora: ");
			double valorHora = scan.nextDouble();
			System.out.print("Duraçao (horas): ");
			int horas = scan.nextInt();
			HourContract contract = new HourContract(contractDate, valorHora, horas);
			worker.addContract(contract);
			
		}
		
		System.out.println();
		
		System.out.print("Entre com mes e ano para calcular o salario(MM/YYYY): ");
        String monthAndYear = scan.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println();
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Salario de " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		scan.close();
	}

}