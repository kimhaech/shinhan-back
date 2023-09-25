package com.example.controller;

import com.example.common.Response;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "무비 컨트롤러~~~~~~")
@RestController // 컨트롤러임을 인식 - Rest API를 만들기 위함
@RequiredArgsConstructor
@RequestMapping("/api") // (/api를 Mapping에 prefix로 붙임) 아래의 각 Mappping 부분의 api를 작성해주지 않아도 된다.
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/v1/movies")
    public Response<List<MovieResponse>> getMovies() {
        return Response.of(movieService.getMovies());
    }

    @GetMapping("/v1/movies/{movieId}")
    public Movie getMovie( // path정보의 movieId 사용
            @PathVariable(value = "movieId") long movieId
    ) {
        return movieService.getMovie(movieId);
    }

    // RequestBody를 통해서 Body를 받을 수 있도록 한다. - Post와 Put에서 사용
    @PostMapping("/v1/movies")
    public void createMovie(@RequestBody MovieRequest movieRequest) {
        movieService.createMovie(movieRequest);
    }

    @PutMapping("/v1/movies/{movieId}")
    public void updateMovie(@PathVariable(value = "movieId") long movieId,
                            @RequestBody MovieRequest movieRequest
    ) {
        movieService.updateMovie(movieId, movieRequest);
    }

    @DeleteMapping("/v1/movies/{movieId}")
    public void deleteMovie(@PathVariable(value = "movieId") long movieId
    ) {
        movieService.deleteMovie(movieId);
    }
}
