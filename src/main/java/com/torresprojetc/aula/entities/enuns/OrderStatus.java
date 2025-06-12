package com.torresprojetc.aula.entities.enuns;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAYD(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);


    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus ValueOf(int code){
        for (OrderStatus status: OrderStatus.values()){
            if (status.getCode() == code){
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");

    }
}
