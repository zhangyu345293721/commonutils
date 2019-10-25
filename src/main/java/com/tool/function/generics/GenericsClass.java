package com.tool.function.generics;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 泛型类
 *
 * @author: zhangyu
 */

@Data
@AllArgsConstructor
public class GenericsClass<T, F> {
    private T t;
    private F f;
}
