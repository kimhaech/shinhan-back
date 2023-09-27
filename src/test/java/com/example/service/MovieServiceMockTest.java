package com.example.service;


import com.example.domain.entity.Actor;
import com.example.domain.entity.Director;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;

    @Mock
    private LogService logService;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void 영화_단건_조회_정상조회_테스트() {
        // given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("테스트");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        // when
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        //then
        MovieResponse result = movieService.getMovie(movieId);
        assertNotNull(result);
    }

    @Test
    public void 영화_단건_조회_불가_테스트() {
        // given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("위위위위우");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        // when
        when(movieRepository.findById(anyLong())).thenReturn(null);

        //then
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }

    @Test
    public void 영화_추가_정상_테스트() {
        MovieRequest request = new MovieRequest("ddudghk", 2002);
        Movie movie = new Movie("ddudghk", 2002);

        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        doNothing().when(logService).saveLog();

        movieService.saveMovie(request);
    }
}
