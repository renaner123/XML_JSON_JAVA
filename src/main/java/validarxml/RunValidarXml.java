package validarxml;

import java.io.File;

public class RunValidarXml {

	public static void main(String[] args) throws Exception {
		ValidarXml validador = new ValidarXml();
		validador.valida(new File("src\\main\\resources\\pedido.xml"), new File("src\\main\\resources\\pedido.xsd"));
	}
}