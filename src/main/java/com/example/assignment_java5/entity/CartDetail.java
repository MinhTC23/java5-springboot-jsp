package com.example.assignment_java5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Cart_Detail")
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Number")
    private Integer number = 1;

    @Column(name = "Unit_price")
    private Float unitPrice;

    @Column(name = "Amount")
    private Float amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Product_Details")
    private ProductDetails productDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Cart")
    private Cart cart;

    @Transient
    private List<CartDetail> list = new ArrayList<>();

    public void addItem(CartDetail cartDetai) {
        for (CartDetail cd : list
        ) {
            if (cd.getProductDetails().getId() == cartDetai.getProductDetails().getId()) {
                cd.setNumber(cd.getNumber() + 1);
                return;
            }
        }
        list.add(cartDetai);
    }

    public List<CartDetail> getList() {
        return list;
    }
}
