package com.example.service;

import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private static List<Movie> movies = new ArrayList<>();

    @PostConstruct // 생성하기 전에 호출한다는 의미
    public void init() {
        movies.addAll(List.of(
                new Movie(1, "코딩스텔라", 2015, LocalDateTime.now()),
                new Movie(2, "코펜하이머", 2023, LocalDateTime.now()),
                new Movie(3, "코딩이 운다", 1999, LocalDateTime.now())
        ));
    }

    public List<MovieResponse> getMovies() {
        // 아래와 같은 기능이지만 외부에서 작성하느냐, 내부에서 작성하느냐의 차이
//        return movies.stream().map(MovieResponse::of).toList(); // lambda 문법
        return movies.stream().map(movie -> MovieResponse.of(movie)).toList();

//        return movies.stream().map(movie ->
//                MovieResponse.builder()
//                    .id(movie.getId())
//                    .name(movie.getName())
//                    .productionYear(movie.getProductionYear())
//                    .build()
//        ).toList();
    }

    public Movie getMovie(long movieId) {
        return movies.stream()
                .filter(movie -> movie.getId() == movieId)
                .toList()
                .stream()
                .findFirst()
                .orElseThrow();
    }

    public void createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(movies.size() + 1, movieRequest.getName(), movieRequest.getProductionYear()
                , LocalDateTime.now());
        movies.add(movie);
    }

    public void updateMovie(long movieId, MovieRequest movieRequest) {
        Movie movie = getMovie(movieId);
        movie.setName(movieRequest.getName());
        movie.setProductionYear(movieRequest.getProductionYear());
    }

    public void deleteMovie(long movieId) {
        Movie movie = getMovie(movieId);
        movies.remove(movie);
    }
}
