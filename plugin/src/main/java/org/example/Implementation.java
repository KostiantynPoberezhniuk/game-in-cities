package org.example;


import java.util.ArrayList;
import java.util.List;

public class Implementation {

    private final List<String> usedCities = new ArrayList<>();
    private String lastComputerCity = null;
    private int userScore = 0;
    private int computerScore = 0;

    public String computerMove(String userCity) {
        usedCities.add(userCity.toLowerCase());
        userScore++;

        char lastChar = getLastLatter(userCity);

        for (String city : dto.CITIES) {
            String cityLower = city.toLowerCase();
            if (cityLower.charAt(0) == lastChar && !usedCities.contains(cityLower)) {
                usedCities.add(cityLower);
                lastComputerCity = city; // зберігаємо останнє місто
                computerScore++;
                return city;
            }
        }
        return null;
    }

    private char getLastLatter(String city) {
        String lower = city.toLowerCase().trim();
        int index = lower.length() - 1;

        while (index > 0 && (lower.charAt(index) == 'ь' || lower.charAt(index) == 'й')) {
            index--;
        }
        return lower.charAt(index);
    }

    public boolean isCityAlreadyUsed(String city) {
        return usedCities.contains(city.toLowerCase());
    }

    public boolean isValidMove(String userCity) {
        if (lastComputerCity == null) {
            return true;
        }
        char expectedChar = getLastLatter(lastComputerCity);
        char userFirstChar = Character.toLowerCase(userCity.charAt(0));

        return userFirstChar == expectedChar;
    }

    public char getExpectedLatter() {
        if (lastComputerCity == null) {
            return ' ';
        }
        return getLastLatter(lastComputerCity);
    }

    public int getUserScore(){
        return userScore;
    }

    public int getComputerScore(){
        return computerScore;
    }

}
