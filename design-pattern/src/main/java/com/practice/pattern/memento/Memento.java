package com.practice.pattern.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 4:14 下午
 */
//备忘录
@AllArgsConstructor
@Data
class Memento {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}