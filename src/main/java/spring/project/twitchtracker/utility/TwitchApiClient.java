package spring.project.twitchtracker.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import spring.project.twitchtracker.model.TwitchUsersResponse;
import spring.project.twitchtracker.model.User;

public class TwitchApiClient {

    private static final String CLIENT_ID = "b4aqeo5oua7necanimzt8jp7ght5sm";
    private static final String AUTHORIZATION = "Bearer fvz8y11fnotoetpufxpp5xsncy4d8v";

    private final WebClient webClient;

    public TwitchApiClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.twitch.tv/helix")
                .defaultHeader(HttpHeaders.AUTHORIZATION, AUTHORIZATION)
                .defaultHeader("Client-Id", CLIENT_ID)
                .build();
    }

    public User getUser(String login) {
//        return webClient.get()
//                .uri("/users?login=" + login)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block(); // blokuje do czasu odpowiedzi (w aplikacji produkcyjnej lepiej używać asynchronicznie)
        TwitchUsersResponse resp = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/users")
                        .queryParam("login", login)
                        .build())
                .retrieve()
                .bodyToMono(TwitchUsersResponse.class)
                .block();

        // Zwróć pierwszy (i zwykle jedyny) element listy
        return (resp != null && !resp.getData().isEmpty()) ? resp.getData().get(0) : null;
    }
}
