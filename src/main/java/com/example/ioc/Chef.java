package com.example.ioc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chef {
    private final IngredientFactory ingredientFactory;

    public String cook(String menu) {
        Ingredient ingredient = ingredientFactory.getIngredient(menu);
        // 재료준비
        Chicken chicken = new Chicken("국내산 닭");

        // 요리함... (비즈니스 로직)


        // 결과반환
        return chicken.getName() + "으로 만든 " + menu;
    }
}
// 지금의 코드에서는 닭고기 원툴이다.