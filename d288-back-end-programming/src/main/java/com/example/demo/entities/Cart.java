package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "order_tracking_number",nullable = false)
    private String orderTracking;

    @Column(name = "package_price",nullable = false)
    private BigDecimal package_price;

    @Column(name = "party_size", nullable = false)
    private int party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItem = new HashSet<>();


    public void add(CartItem cartItm)
    {
        //check if null, if not null then proceed adding
        if(cartItm != null)
        {
            if(cartItem == null)
            {
                cartItem = new HashSet<>();
            }
            cartItem.add(cartItm);
            cartItm.setCart(this);

        }
    }

    public void setOrderTrackingNumber(String orderTrackingNum)
    {
        this.orderTracking = orderTrackingNum;
    }

    /*
    public Cart()
    {

    }*/
}
