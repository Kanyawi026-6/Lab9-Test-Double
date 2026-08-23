package sqa.lab.service;

import java.util.Arrays;
import java.util.List;

public class MoviePortalStub implements MovieService {
    @Override
    public List<String> getMoviesByTheater(String location, String date) {
        return Arrays.asList(
            "Avatar: VIP cinema",
            "Titanic: Standard",
            "Inception: VIP cinema",
            "Avengers: IMAX"
        );
    }
}