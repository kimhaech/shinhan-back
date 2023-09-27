package com.example.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BaseTest {
    @BeforeAll // 테스트 전 매번
    public static void beforeAll() {
        System.out.println("매 테스트 전 호출");
    }
    @BeforeEach // 테스트 전 한번
    public void beforeEach() {
        System.out.println("매 테스트 전 한번 호출");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("매 테스트 후 호출");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("매 테스트 후 한번 호출");
    }

    @Test
    @DisplayName("더하기 테스트")
    public void calTest() {
        // given - 주어진 것(자원)
        int a = 1;
        int b = 3;

        // when - 어떤 행동을 할 것인가
        int sum = a + b;

        // then - 그 결과
        assertEquals(4, sum);
    }
}
