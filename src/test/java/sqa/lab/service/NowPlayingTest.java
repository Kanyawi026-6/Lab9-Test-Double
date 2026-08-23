package sqa.lab.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NowPlayingTest {

    @Test
    public void testGetVipMoviesWithStub() {
        MovieService movieServiceStub = new MoviePortalStub();
        NowPlaying nowPlaying = new NowPlaying(movieServiceStub);

        List<String> result = nowPlaying.getVipMovies("KhonKaen", "2026-08-23");

        assertEquals(2, result.size());
        assertTrue(result.contains("Avatar: VIP cinema"));
        assertTrue(result.contains("Inception: VIP cinema"));
    }
}