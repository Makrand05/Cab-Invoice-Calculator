package com.biz.cabinvice;

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
}
