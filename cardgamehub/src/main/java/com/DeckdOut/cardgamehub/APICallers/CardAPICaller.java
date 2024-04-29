package com.DeckdOut.cardgamehub.APICallers;

import com.DeckdOut.cardgamehub.model.Card;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for calling an API to retrieve card information.
 */
public class CardAPICaller {

    /**
     * Retrieves cards from the API.
     *
     * @return An array of Card objects retrieved from the API.
     */
    public static Card[] getCardsFromAPI() {
        List<Card> cards = new ArrayList<>();

        try {
            // Create URL
            URL url = new URL("http://localhost:8080/card");

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response
            ObjectMapper mapper = new ObjectMapper();
            cards = List.of(mapper.readValue(response.toString(), Card[].class));

            // Close connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cards.toArray(new Card[0]);
    }

    /**
     * Main method to test fetching cards from the API.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        Card[] cards = getCardsFromAPI();

        // Print cards
        System.out.println("Cards:");
        for (Card card : cards) {
            System.out.println(card.getId() + ", " + card.getSuit() + ", " + card.getValue() + ", " + card.getOwner()+ ", " + card.isPlayed());
        }
    }
}
