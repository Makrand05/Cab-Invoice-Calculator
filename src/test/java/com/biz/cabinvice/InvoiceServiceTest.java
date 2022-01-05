package com.biz.cabinvice;

import com.biz.cabinvice.model.InvoiceSummery;
import com.biz.cabinvice.model.Ride;
import com.biz.cabinvice.service.InvoiceService;
import com.biz.cabinvice.service.UserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void givenUserID_whenCalculateFare_shouldReturnAggregareSummery() {
        InvoiceService invoiceService=new InvoiceService();

        String userName="Rahul";
        List<Ride> rideList=new ArrayList<>();

              rideList.add(new Ride(2.0,5));
              rideList.add(new Ride(1.0,5));
              rideList.add(new Ride(0.1,1));
        new UserAccount(userName,rideList);
        InvoiceSummery actualSummery= invoiceService.GetInvoiceSummary(userName);
        InvoiceSummery expectedSummery= new InvoiceSummery(3,45.0);
      //  InvoiceSummery actualSummery=invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedSummery,actualSummery);
    }
}
