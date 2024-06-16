package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoPorHora;
import entidades.Departamentos;
import entidades.Trabalhadores;
import entidades.enums.NivelDeCargo;

public class Programa {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o nome do departamento: ");
		String nomeDoDepartamento = sc.nextLine();
		System.out.println("Digite os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salario base: ");
		double salarioBaseTrabalhador = sc.nextDouble ();
		Trabalhadores trabalhador = new Trabalhadores(nomeTrabalhador, NivelDeCargo.valueOf(nivelTrabalhador), salarioBaseTrabalhador, new Departamentos(nomeDoDepartamento));
		
		System.out.println("Quantos contratos esse trabalhador tem? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n ; i++) {
			System.out.println("Digite os dados do contrato #" + i + ":");
			System.out.print("Data (DD/MM/YYYY)");
			Date dataDoContrato = sdf.parse(sc.next()); // "sdf.parse" -> .parse permite o programador definir data e hora.SSSS
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (Em horas): ");
			int horas = sc.nextInt();
			ContratoPorHora contrato = new ContratoPorHora(dataDoContrato, valorPorHora, horas);
			trabalhador.addContrato(contrato);		//<- faz meu contrato ser associado ao meu trabalhador.
		}
		
		System.out.println();
		System.out.print("Digite o mes e o ano para calcular o salario (MM/YYYY): ");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2)); 	// "substring" -> usado para pegar alguns valores especificos da string.
		int ano = Integer.parseInt(mesEano.substring(3));    	// "Integer.parseInt" -> converte string para um numero inteiro.
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamentos().getNome());
		System.out.println("O salario no mes " + mesEano + " desse funcionario foi: " + String.format("%.2f", trabalhador.calcular(ano, mes)));
		
				
		sc.close();
	}
}
