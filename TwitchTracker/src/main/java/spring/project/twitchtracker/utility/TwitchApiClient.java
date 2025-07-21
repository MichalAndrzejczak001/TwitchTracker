package spring.project.twitchtracker;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

public class TwitchApiClient {

    private final WebClient webClient;

    public TwitchApiClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.twitch.tv/helix")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer fvz8y11fnotoetpufxpp5xsncy4d8v")
                .defaultHeader("Client-Id", "b4aqeo5oua7necanimzt8jp7ght5sm")
                .build();
    }

    public String getUser() {
        return webClient.get()
                .uri("/users?login=twitchdev")
                .retrieve()
                .bodyToMono(String.class)
                .block(); // blokuje do czasu odpowiedzi (w aplikacji produkcyjnej lepiej używać asynchronicznie)
    }
}
