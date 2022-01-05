package com.biz.cabinvice;

import com.biz.cabinvice.model.InvoiceSummery;
import com.biz.cabinvice.model.Ride;
import com.biz.cabinvice.service.InvoiceService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_whenCalculateFare_shouldReturnTotalFare() {
        InvoiceService invoiceService=new InvoiceService();
        double totalFare=invoiceService.calculateFare(2.0,5);
        Assert.assertEquals(25,totalFare,0.0);
    }
    @Test
    public void givenDistanceAndTimeTest2_whenCalculateFare_shouldReturnTotalFare() {
        InvoiceService invoiceService=new InvoiceService();
        double totalFare=invoiceService.calculateFare(1.0,5);
        Assert.assertEquals(15,totalFare,0.0);
    }
    @Test
    public void givenDistanceAndTimeTest3_whenCalculateFare_shouldReturnTotalFare() {
        InvoiceService invoiceService=new InvoiceService();
        double totalFare=invoiceService.calculateFare(0.0,5);
        Assert.assertEquals(5,totalFare,0.0);
    }

    @Test
    public void givenMultipleRides_whenCalculateFare_shouldReturnTotalFare() {
        InvoiceService invoiceService=new InvoiceService();
        Ride []rides={
                new Ride(2.0,5),
                new Ride(1.0,5),
                new Ride(0.1,1) };
        double totalFare=invoiceService.calculateFares(rides);

        Assert.assertEquals(45.0,totalFare);
    }

    @Test
    public void givenMultipleRides_whenCalculateFare_shouldReturnAggregareTotalFare() {
        InvoiceService invoiceService=new InvoiceService();
        Ride []rides={

                new Ride(2.0,5),
                new Ride(1.0,5),
                new Ride(0.1,1) };
        InvoiceSummery expectedSummery= new InvoiceSummery(3,45.0);
        InvoiceSummery actualSummery=invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedSummery,actualSummery);
    }

}
