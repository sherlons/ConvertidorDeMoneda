import java.util.Scanner;

public class ConvertidorDeMoneda {
    public static void convertirOtraMoneda(TipoDeMoneda consulta, Scanner lectura) {
        System.out.println("Moneda de origen:");
        String monedaOrigen = lectura.nextLine().toUpperCase();
        System.out.println("Moneda de destino:");
        String monedaDestino = lectura.nextLine().toUpperCase();

        TipoDeMoneda.convertir(monedaOrigen, monedaDestino, consulta, lectura);
    }
}
