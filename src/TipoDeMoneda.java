import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TipoDeMoneda {
    public static void convertir(String monedaBase, String monedaCambio, TipoDeMoneda consulta, Scanner lectura) {
        System.out.println("Valor a cambiar:");
        double cantidad = lectura.nextDouble();
        lectura.nextLine(); // Limpiar el buffer

        double tasa = consulta.obtenerTasaCambio(monedaBase, monedaCambio);
        if (tasa != -1) {
            double resultado = cantidad * tasa;
            System.out.println("Has cambiado " + cantidad + " " + monedaBase + " a " + resultado + " " + monedaCambio);
        } else {
            System.out.println("No se pudo obtener la tasa de cambio.");
        }
    }

    public double obtenerTasaCambio(String monedaBase, String monedaCambio) {
        String apiKey = "c2b03fc6d5f64fdf0faae439";  // Reemplaza con tu API Key
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificamos si la respuesta fue exitosa (código de estado 200)
            if (response.statusCode() == 200) {
                // Parseamos la respuesta JSON usando Gson
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

                // Obtenemos la tasa de cambio para la moneda solicitada
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
                if (conversionRates != null && conversionRates.has(monedaCambio)) {
                    return conversionRates.get(monedaCambio).getAsDouble();
                } else {
                    System.out.println("No se encontró la tasa de cambio para " + monedaCambio);
                }
            } else {
                System.out.println("Error en la respuesta de la API: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return -1;  // En caso de error
    }
}
