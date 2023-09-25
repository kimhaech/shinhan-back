package com.example.domain.response;

import com.example.domain.entity.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder // 함수형으로 정보들을 만들 수 있게한다.
@Getter
public class MovieResponse {
    private final long id;
    private final String name;
    private final Integer productionYear;

    // static template method
    public static MovieResponse of(Movie movie) {
        return new MovieResponse(movie.getId(), movie.getName(), movie.getProductionYear());
    }
}
