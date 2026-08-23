package sqa.lab.service;

import java.util.ArrayList;
import java.util.List;

public class NowPlaying {
    private MovieService movieService;

    public NowPlaying(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<String> getVipMovies(String location, String date) {
        List<String> allMovies = movieService.getMoviesByTheater(location, date);
        List<String> vipMovies = new ArrayList<>();
        
        for (String movie : allMovies) {
            if (movie.contains("VIP cinema")) {
                vipMovies.add(movie);
            }
        }
        return vipMovies;
    }
}