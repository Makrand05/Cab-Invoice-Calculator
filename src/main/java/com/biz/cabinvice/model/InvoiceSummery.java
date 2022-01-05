package com.biz.cabinvice.model;

import java.util.Objects;

public class InvoiceSummery {
    private int totalRides;
    private double totalFare;
    private double average;

    public InvoiceSummery(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.average =this.totalFare/this.totalRides;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummery that = (InvoiceSummery) o;
        return totalRides == that.totalRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.average, average) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRides, totalFare, average);
    }
}
