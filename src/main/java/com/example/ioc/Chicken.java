package com.example.ioc;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Chicken implements Ingredient {
    final String name;
}
// 현재는 name 하나만 쓰는데 많은 것들이 필요하다.
// lombok을 사용하면 깔끔하게 쓸 수 있다.
// final 키워드는 불변성을 가지는 java의 문법 키워드
// 불변성의 목적? -> 멀티 스레드 환경에서 thread-safe를 보장한다.
// 변할 수 없다는 것? -> 할당된 이후 변경을 못하게 한다.(특정하지 않는 이상)
// required는 final혹은 nullable 하지 않는 변수에 대해서,
// RequiredArgsConstructor를 사용하면 final이 있는 변수만 가지는 생성자를 만든다.
// record로 변경? - 관심 있으면 공부해
