package com.ptit.controller.addition;

public class MovieViewStar {
    private String name;
    private int sum;
    private double avg;

    public MovieViewStar() {
    }

    public MovieViewStar(String name, int sum, double avg) {
        this.name = name;
        this.sum = sum;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "MovieViewStar{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", avg=" + avg +
                '}';
    }
}
