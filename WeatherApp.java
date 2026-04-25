import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n");
            System.out.println("====================================");
            System.out.println("🌤 Welcome to the Weather App 🌤");
            System.out.println("====================================");
            System.out.println("\n");

            System.out.print("Enter city: ");
            String city = sc.nextLine();

            String apiKey = System.getenv("WEATHER_API_KEY");

            if (apiKey == null) {
                System.out.println("❌ API key not found. Please set WEATHER_API_KEY.");
                return;
            }

            String url = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + apiKey + "&units=metric";

            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(url))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // 🔍 Print raw response (for debugging)
                // System.out.println(response.body());

                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

                // ✅ Check if API returned error
                if (!json.has("main")) {
                    String message = json.has("message")
                            ? json.get("message").getAsString()
                            : "Unknown error";

                    System.out.println("\n❌ Error: " + message);
                    return;
                }

                // ✅ Extract data safely
                double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
                int humidity = json.getAsJsonObject("main").get("humidity").getAsInt();
                double feelsLike = json.getAsJsonObject("main").get("feels_like").getAsDouble();

                String weather = json.getAsJsonArray("weather")
                        .get(0).getAsJsonObject()
                        .get("description").getAsString();

                double windSpeed = json.getAsJsonObject("wind").get("speed").getAsDouble();

                // 🎯 Clean output
                System.out.println("\n🌤 Weather Report");
                System.out.println("----------------------------");
                System.out.println("City        : " + city);
                System.out.println("Temperature : " + temp + "°C");
                System.out.println("Feels Like  : " + feelsLike + "°C");
                System.out.println("Humidity    : " + humidity + "%");
                System.out.println("Wind Speed  : " + windSpeed + " m/s");
                System.out.println("Condition   : " + weather);
                System.out.println("----------------------------");

            } catch (Exception e) {
                System.out.println("\n❌ Error occurred: " + e.getMessage());
            }

            System.out.println("\nDo you want to check another city? (yes/no)");
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("\n👋 Thank you for using the Weather App! Goodbye!");
                break;
            }

        }
        sc.close();
    }

}