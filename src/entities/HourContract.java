package entities;

import java.util.Date;

public class HourContract {

	private Date data;
	private Double valorHora;
	private Integer horas;

	public HourContract(Date data, Double valorHora, Integer horas) {
		this.horas = horas;
		this.data = data;
		this.valorHora = valorHora;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setValorPorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Double getValorPorHora() {
		return valorHora;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public Double valorTotal() {
		return horas * valorHora;
	}

}