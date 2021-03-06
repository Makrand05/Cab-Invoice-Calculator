package com.biz.cabinvice.service;

import com.biz.cabinvice.model.InvoiceSummery;
import com.biz.cabinvice.model.Ride;

import java.util.List;

public class InvoiceService {

    private final double COST_PER_KM = 10.0;
    private final int COST_PER_MINUTES = 1;
    private final double MIN_FARE = 5;
    private final double PREMIUM_COST_PER_KM = 15.0;
    private final int PREMIUM_COST_PER_MINUTES = 2;
    private final double PREMIUM_MIN_FARE = 20;

    public static void main(String[] args) {
        System.out.println("Welcome in Cab Invoice calculator");
    }

    public double calculateFare(double distance, int time, String rideType) {
        if(rideType.equals("Normal")) {
          return calculateFare(distance, time);
        }
        else {
            double fare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MINUTES;
            return Math.max(fare, PREMIUM_MIN_FARE);
        }
    }

    public InvoiceSummery calculateFare(Ride[] rides) {
        double totalFare=0.0;
        for(Ride ride:rides)
        {
            totalFare+=calculateFare(ride.getDistance(),ride.getTime(), ride.getRideType());
        }
        System.out.println("Number of rides : " +rides.length+" Fare : "+totalFare);
        return new InvoiceSummery(rides.length,totalFare);
    }
    public double calculateFares(Ride[] rides) {
        double totalFare=0.0;
        for(Ride ride:rides)
        {
            totalFare+=calculateFare(ride.getDistance(),ride.getTime(), ride.getRideType());
        }
        return totalFare;
    }

    public InvoiceSummery GetInvoiceSummary(String userName) {

        List<Ride> list=UserAccount.userMap.get(userName);
        double totalFare=0.0;
        int rideCount=0;
        for(Ride ride:list)
        {
            totalFare+=calculateFare(ride.getDistance(),ride.getTime(),ride.getRideType());
            rideCount++;
        }

        return new InvoiceSummery(rideCount,totalFare);
    }

    public double calculateFare(double distance, int time) {

            double fare = distance * COST_PER_KM + time * COST_PER_MINUTES;
            return Math.max(fare, MIN_FARE);

    }
}
