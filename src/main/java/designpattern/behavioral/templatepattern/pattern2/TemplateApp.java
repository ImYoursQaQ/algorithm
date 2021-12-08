package designpattern.behavioral.templatepattern.pattern2;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import designpattern.behavioral.templatepattern.Order;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author teohubo
 */
public class TemplateApp {

    public static void main(String[] args) {
        Order o1 = new Order(1, 1, 1);
        Order o2 = new Order(2,2,2);
        Order o3  = new Order(3,1,-1);
        Order o4 = new Order(4, 3, 1);
        ArrayList<Order> orders = Lists.newArrayList(o1, o2, o3, o4);
        MyOrderHandler handler = new MyOrderHandler(orders);
        List<Order> current = handler.doFilter(order -> order.getStatus() != -1)
                .doSort(Comparator.comparingInt(Order::getType))
                .doMark(order -> order.setBatchNo("CURRENT"))
                .doHouseSelect(order -> order.setHouseNo("10000"))
                .getOrders();
        current.forEach(order -> System.out.println(JSONObject.toJSONString(order)));
    }
}

@Getter
class MyOrderHandler{

    private List<Order> orders;

    public MyOrderHandler(List<Order> orders) {
        this.orders = orders;
    }

    public MyOrderHandler doFilter(Predicate<Order> predicate){
        this.orders = orders.stream().filter(predicate).collect(Collectors.toList());
        return this;
    }

    public MyOrderHandler doSort(Comparator<Order> comparator){
        this.orders = orders.stream().sorted(comparator).collect(Collectors.toList());
        return this;
    }

    public MyOrderHandler doMark(Consumer<Order> consumer){
        orders.forEach(consumer);
        return this;
    }

    public MyOrderHandler doHouseSelect(Consumer<Order> consumer){
        orders.forEach(consumer);
        return this;
    }

}


