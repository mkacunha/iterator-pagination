package com.mkacunha.sample;

import java.util.ArrayList;
import java.util.List;

public class NumberClient {

    private static List<Number> numbers = List.of(
            new Number(1),
            new Number(2),
            new Number(3),
            new Number(4),
            new Number(5),
            new Number(6),
            new Number(7),
            new Number(8),
            new Number(9),
            new Number(10));

    public NumberResponse find(int offset) {
        if (offset == 6) {
            var newNumbers = new ArrayList<Number>();
            newNumbers.add(new Number(0));
            newNumbers.addAll(numbers);
            numbers = List.copyOf(newNumbers);
        }

        return new NumberResponse(numbers.size(), offset, getNumbers(offset));
    }

    private List<Number> getNumbers(int offset) {
        if ((offset + 1) > numbers.size()) {
            return List.of();
        }

        if ((offset + 1) >= numbers.size()) {
            return List.of(this.numbers.get(offset));
        }

        return List.of(this.numbers.get(offset), this.numbers.get(offset + 1));
    }
}
