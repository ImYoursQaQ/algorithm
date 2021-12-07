package designpattern.behavioral.templatepattern;

import lombok.Data;

@Data
public class Order{

    private Integer id;

    private Integer type;

    private String batchNo;

    private String houseNo;

    private Integer status;

    public Order(Integer id, Integer type, Integer status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }
}