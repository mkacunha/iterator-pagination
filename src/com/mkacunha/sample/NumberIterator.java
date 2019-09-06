package com.mkacunha.sample;

import java.util.Iterator;
import java.util.List;

public class NumberIterator implements Iterator<Number> {

    private List<Number> numbers;

    private int offset = 0;

    private int amount = 0;

    private int position = 0;

    private final NumberClient numberClient;

    public NumberIterator(NumberClient numberClient) {
        this.numberClient = numberClient;
        this.findNumbers();
    }

    private void findNumbers() {
        System.out.println("findNumbers -> offset " + offset);
        var numberResponse = this.numberClient.find(offset);

        if (this.amount != 0 && this.amount < numberResponse.getAmount()) {
            System.out.println("Cache != cloud amount");
            this.offset += (numberResponse.getAmount() - this.amount);
            this.amount = numberResponse.getAmount();
            this.findNumbers();
            return;
        }

        this.numbers = numberResponse.getNumbers();
        this.amount = numberResponse.getAmount();
        this.position = 0;
        this.offset += this.numbers.size();
        System.out.println("finded Numbers -> new offset " + offset + ", amount " + amount);
    }

    @Override
    public boolean hasNext() {
        var hasCache = position < numbers.size();
        var hasCloud = this.offset < this.amount;
        var hasNext = hasCache || hasCloud;

        System.out.println("hasCache " + hasCache + ", hasCloud " + hasCloud + ", hasNext " + hasNext);

        if (!hasCache && hasCloud) {
            this.findNumbers();
        }
        return hasNext;
    }

    @Override
    public Number next() {
        return numbers.get(position++);
    }
}
