package sqa.lab.service;

import java.util.List;

public interface MovieService {
    List<String> getMoviesByTheater(String location, String date);
}