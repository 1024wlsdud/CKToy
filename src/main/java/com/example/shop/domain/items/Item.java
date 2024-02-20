package com.example.shop.domain.items;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemNm; // 상품명

    @Column(name = "price", nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockNum; // 재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; // 상세설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 판매 상태

    @Builder
    public Item(String itemNm, int price, int stockNum, String itemDetail, ItemSellStatus itemSellStatus){
        this.itemNm = itemNm;
        this.price = price;
        this.stockNum = stockNum;
        this.itemDetail = itemDetail;
        this.itemSellStatus = itemSellStatus;
    }
}
