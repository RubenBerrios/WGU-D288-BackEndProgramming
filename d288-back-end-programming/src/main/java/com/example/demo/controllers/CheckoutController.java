package com.example.demo.controllers;

import com.example.demo.services.CheckoutService;
import com.example.demo.services.Purchase;
import com.example.demo.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;


    public CheckoutController(CheckoutService checkoutService)
    {

        this.checkoutService = checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse checkout(@RequestBody Purchase purchase)
    {
        PurchaseResponse purchaseResponse = checkoutService.checkout(purchase);
        return purchaseResponse;
    }



}
