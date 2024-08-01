package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{


    private CustomerRepository customerRepository;

    private CartRepository cartRepository;

    private CartItemRepository cartItemRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository)
    {

        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout(Purchase purchase)
    {

            //get the cart,customer and cart item info
            Cart cart = purchase.getCart();
            Customer customer = purchase.getCustomer();
            Set<CartItem> cartItems = purchase.getCartItems();



            //generate UUID, parse it as string and set as tracking number
            String orderTrackingNum = generateOrderTrackingNumber();
            cart.setOrderTracking(orderTrackingNum);

            //set the status of the order
            cart.setStatus(StatusType.ordered);


            //add all cart items into the cart
            cartItems.forEach(itm -> cart.add(itm));



            //if cart is not empty, save
            if(!cartItems.isEmpty())
            {
                //save to the database
                cartRepository.save(cart);
            }
            else
            {
                //otherwise if empty, don't save to database and display error message
                orderTrackingNum = "NO ITEMS IN CART";
            }



            return new PurchaseResponse(orderTrackingNum);
    }

    private String generateOrderTrackingNumber()
    {
        //return random uuid
        return UUID.randomUUID().toString();
    }
}
