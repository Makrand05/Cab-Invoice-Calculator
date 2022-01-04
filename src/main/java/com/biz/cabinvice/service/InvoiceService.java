package com.biz.cabinvice.service;

public class InvoiceService {

    private final double COST_PER_KM = 10.0;
    private final int COST_PER_MINUTES = 1;
    private final double MIN_FARE = 5;

    public static void main(String[] args) {
        System.out.println("Welcome in Cab Invoice calculator");
    }

    public double calculateFare(double distance, int time) {
        double fare = distance * COST_PER_KM + time * COST_PER_MINUTES;
        return Math.max(fare,MIN_FARE);
    }
}
