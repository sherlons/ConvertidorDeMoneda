import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        TipoDeMoneda consulta = new TipoDeMoneda();
        int opciones = 0;

        while (opciones != 8) {
            System.out.println("*********************************\n" +
                    "Bienvenidos al Convertidor de Moneda Sherlons\n" +
                    "¿Qué moneda quieres convertir?\n\n" +
                    "1. Dólar a Peso Colombiano\n" +
                    "2. Peso Colombiano a Dólar\n" +
                    "3. Dólar a Peso Argentino\n" +
                    "4. Peso Argentino a Dólar\n" +
                    "5. Dólar a Real Brasileño\n" +
                    "6. Real Brasileño a Dólar\n" +
                    "7. Convertir otras monedas\n" +
                    "8. Salir");
            opciones = lectura.nextInt();
            lectura.nextLine();  // Limpiar buffer de entrada

            switch (opciones) {
                case 1:
                    TipoDeMoneda.convertir("USD", "COP", consulta, lectura);
                    break;
                case 2:
                    TipoDeMoneda.convertir("COP", "USD", consulta, lectura);
                    break;
                case 3:
                    TipoDeMoneda.convertir("USD", "ARS", consulta, lectura);
                    break;
                case 4:
                    TipoDeMoneda.convertir("ARS", "USD", consulta, lectura);
                    break;
                case 5:
                    TipoDeMoneda.convertir("USD", "BRL", consulta, lectura);
                    break;
                case 6:
                    TipoDeMoneda.convertir("BRL", "USD", consulta, lectura);
                    break;
                case 7:
                    ConvertidorDeMoneda.convertirOtraMoneda(consulta, lectura);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println("\nFinalizando operación...\n");
        }
        lectura.close();
    }
}
