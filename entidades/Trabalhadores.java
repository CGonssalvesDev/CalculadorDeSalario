package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelDeCargo;

public class Trabalhadores {
	
	private String nome;			//	
	private NivelDeCargo cargo;		// Atributos basicos
	private Double salarioBase;		//	
	
	private Departamentos departamentos;						 //Associações  
	private List<ContratoPorHora> contratos = new ArrayList<>(); // 	              
	
	public Trabalhadores() {
	}


	public Trabalhadores(String nome, NivelDeCargo cargo, Double salarioBase, Departamentos departamentos) {
		this.nome = nome;
		this.cargo = cargo;
		this.salarioBase = salarioBase;
		this.departamentos = departamentos;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDeCargo getCargo() {
		return cargo;
	}

	public void setCargo(NivelDeCargo cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salarioBase;
	}

	public void setSalario(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamentos getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	public List<ContratoPorHora> getContratos() {
		return contratos;
	}

	public void addContrato(ContratoPorHora contrato) {			//
		contratos.add(contrato);								// dois metodos responsaveis por
	}															// fazer ou desfazer a assosiação
																// entre um trabalhador e um
	public void removeContrato(ContratoPorHora contrato) {		// contrato.
		contratos.remove(contrato);								//
	}
	
	public double calcular(int ano, int mes) {   				// 
		double soma = salarioBase;								//  
		Calendar cal = Calendar.getInstance();					// 
		for (ContratoPorHora c : contratos) {					// metodo usado para calcular a soma
			cal.setTime(c.getData());							// do salario base + os contratos que
			int c_ano = cal.get(Calendar.YEAR);					// o trabalhador possui.
			int c_mes = 1 + cal.get(Calendar.MONTH);			//
			if(ano == c_ano && mes == c_mes) {					//
				soma += c.valorTotal();							//
			}
		}
		return soma;
	}
}