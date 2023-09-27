package com.example.service;

import com.example.domain.entity.Director;
import com.example.domain.entity.Log;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.LogRepository;
import com.example.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final LogService logService;

    @Transactional
    public MovieResponse getMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(); // 없음 던짐 -> null 하지 않다.

        return MovieResponse.of(movie);
    }

    @Transactional
    public List<MovieResponse> getMovies() {
        List<Movie> movies = movieRepository.findByProductionYear(2022);
        return movies.stream().map(MovieResponse::of).toList();
    }

    @Transactional
    public void saveMovie(MovieRequest movieRequest) {
        Movie movie1 = new Movie(movieRequest.getName() + "1", movieRequest.getProductionYear());
        Movie movie2 = new Movie(movieRequest.getName() + "2", movieRequest.getProductionYear());
        Movie movie3 = new Movie(movieRequest.getName() + "3", movieRequest.getProductionYear());

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);

        logService.saveLog();
    }

    @Transactional
    public void updateMovie(long movieId, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movie.setName("변경1");
        movie.setName("변경2");
        movie.setName("변경3");
    }

    @Transactional
    public void removeMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movieRepository.delete(movie);
    }
}
