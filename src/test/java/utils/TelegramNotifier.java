package utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class TelegramNotifier {
    public static void sendMessage(String token,
                                   String chatId,
                                   String message) {
        try {
            String url =
                    "https://api.telegram.org/bot"
                            + token
                            + "/sendMessage?chat_id="
                            + chatId
                            + "&text="
                            + java.net.URLEncoder.encode(message, "UTF-8");
            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .GET()
                            .build();
            HttpClient.newHttpClient()
                    .send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}