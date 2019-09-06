package com.mkacunha.sample;

import java.util.List;

public class NumberResponse {


    private final int amount;

    private final int offset;

    private final List<Number> numbers;

    public NumberResponse(int amount, int offset, List<Number> numbers) {
        this.amount = amount;
        this.offset = offset;
        this.numbers = numbers;
    }

    public int getAmount() {
        return amount;
    }

    public int getOffset() {
        return offset;
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
