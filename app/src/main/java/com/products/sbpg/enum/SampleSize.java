package com.products.sbpg;

enum SampleSize {
    TINY(0.1), SMALL(0.25), MEDIUM(0.5), LARGE(0.75), FULL(1);

    private double sizePercentage;

    SampleSize(double sizePercentage) {
        this.sizePercentage = sizePercentage;
    }

    public double getSizePercentage() {
        return sizePercentage;
    }
}