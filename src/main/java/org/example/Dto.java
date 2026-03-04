package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.stream.Collectors;

public class Dto {

    private Dto(){}

    public static final String SURRENDER = "здаюсь";
    private static final Set<String> CITIES = loadCities();

    private static Set<String> loadCities() {
        try (InputStream is = Dto.class.getResourceAsStream("/cities.txt")) {
            if (is == null) {
                throw new IllegalStateException("cities.txt not found in resources");
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8))) {
                return reader.lines()
                        .map(String::trim)
                        .filter(line -> !line.isEmpty())
                        .collect(Collectors.toUnmodifiableSet());
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load cities", e);
        }
    }

    public static Set<String> getCities(){
        return CITIES;
    }
}
