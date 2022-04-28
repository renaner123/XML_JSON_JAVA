package Json;

import java.util.ArrayList;
import java.util.List;

public class Informacoes {

	private int informacao1 = 500;
	private String informacao2 = "Olá";

	@SuppressWarnings("serial")
	private List<String> listaInformacoes = new ArrayList<String>() {
	  {
		add("String 1");
		add("String 2");
		add("String 3");
	  }
	};

	@Override
	public String toString() {
	   return "Informacoes [Informação 1 =" + informacao1 +
", Informação 2 =" + informacao2 + ", list=" + listaInformacoes + "]";
	}

	public int getInformacao1() {
		return informacao1;
	}

	public void setInformacao1(int informacao1) {
		this.informacao1 = informacao1;
	}

	public String getInformacao2() {
		return informacao2;
	}

	public void setInformacao2(String informacao2) {
		this.informacao2 = informacao2;
	}

	public List<String> getListaInformacoes() {
		return listaInformacoes;
	}

	public void setListaInformacoes(List<String> listaInformacoes) {
		this.listaInformacoes = listaInformacoes;
	}
}