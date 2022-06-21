package com.api.backpackerapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrderDt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="order_number", length = 12, nullable = false)
    private String orderNumber;

    @Column(name= "item_name", length=100, nullable = false)
    private String itemName;

    @Column(name= "payment_datetime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime paymentDateTime;

    @Column(name = "member_id")
    private Long memberId;

    @Builder
    public OrderDt(String orderNumber, String itemName, long memberId, LocalDateTime paymentDateTime){
        this.orderNumber = orderNumber;
        this.itemName = itemName;
        this.memberId = memberId;
        this.paymentDateTime = paymentDateTime;
    }

    @Override
    public String toString() {
        return "OrderDt{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", itemName='" + itemName + '\'' +
                ", paymentDateTime=" + paymentDateTime +
                ", memberId=" + memberId +
                '}';
    }
}
