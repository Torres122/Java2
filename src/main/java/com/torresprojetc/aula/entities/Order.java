package com.torresprojetc.aula.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.torresprojetc.aula.entities.enuns.OrderStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    private Integer orderStatus;

    public Order(){}

    public Order(Long id, Instant moment,OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = status.getCode();
        this.client = client;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.ValueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
       if (orderStatus != null){
           this.orderStatus = orderStatus.getCode();
       }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return id == order.id && Objects.equals(moment, order.moment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Objects.hashCode(moment);
        result = 31 * result + Objects.hashCode(client);
        return result;
    }


}
