package com.example.domain.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MovieRequest {
    // front에서 영화 정보를 생성한다 가정 -> 정보만 전달
    private final String name;
    private final Integer productionYear;
}
