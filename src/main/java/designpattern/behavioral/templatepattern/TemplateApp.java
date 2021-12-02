package designpattern.behavioral.templatepattern;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        MyOrderHandler myOrderHandler = new MyOrderHandler();
        myOrderHandler.handlerOrders(orders);
        orders.forEach(order -> System.out.println(JSONObject.toJSONString(order)));
    }
}

@Data
class Order{

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

abstract class OrderHandler{

    public void handlerOrders(List<Order> orders){

        //1。过滤
        doFilter(orders);
        //2。排序
        doSort(orders);
        //3。打标
        doMark(orders);
        //4。选择仓库
        doHouseSelect(orders);
    }

    protected abstract void doHouseSelect(List<Order> orders);

    protected abstract void doMark(List<Order> orders);

    abstract void doFilter(List<Order> orders);

    abstract void doSort(List<Order> orders);
}

interface OrderFilter{

    default void filterOrder(List<Order> orders){
        orders.removeIf(order -> order.getStatus() == -1);
    }
}

class DefaultFilter implements OrderFilter{

}

interface OrderSorter{
    void sortOrder(List<Order> orders);
}

class StatusSorter implements OrderSorter{

    @Override
    public void sortOrder(List<Order> orders) {
        orders.sort(Comparator.comparingInt(Order::getStatus));
    }
}

class TypeSorter implements OrderSorter{

    @Override
    public void sortOrder(List<Order> orders) {
        orders.sort(Comparator.comparingInt(Order::getType));

    }
}

interface OrderMarker{
    void markOrder(List<Order> orders);
}

class CurrentBatchMarker implements OrderMarker{

    @Override
    public void markOrder(List<Order> orders) {
       orders.forEach(order -> order.setBatchNo("CURRENT"));
    }
}

class NextDayBatchMarker implements OrderMarker{
    @Override
    public void markOrder(List<Order> orders) {
        orders.forEach(order -> order.setBatchNo("NEXT"));
    }
}

interface OrderHouseSelector{
    void selectOrder(List<Order> orders);
}

class CenterSelector implements OrderHouseSelector{
    @Override
    public void selectOrder(List<Order> orders) {
        orders.forEach(order -> order.setHouseNo("10000"));
    }
}

class StationSelector implements OrderHouseSelector{
    @Override
    public void selectOrder(List<Order> orders) {
        orders.forEach(order -> order.setHouseNo("10001"));
    }
}

class MyOrderHandler extends OrderHandler{

    private OrderFilter orderFilter;

    private OrderSorter orderSorter;

    private OrderMarker orderMarker;

    private OrderHouseSelector orderHouseSelector;

    public MyOrderHandler(OrderFilter orderFilter, OrderSorter orderSorter, OrderMarker orderMarker, OrderHouseSelector orderHouseSelector) {
        this.orderFilter = orderFilter;
        this.orderSorter = orderSorter;
        this.orderMarker = orderMarker;
        this.orderHouseSelector = orderHouseSelector;
    }

    public MyOrderHandler() {
        this.orderFilter = new DefaultFilter();
        this.orderSorter = new TypeSorter();
        this.orderMarker = new NextDayBatchMarker();
        this.orderHouseSelector = new CenterSelector();
    }


    @Override
    protected void doHouseSelect(List<Order> orders) {
        orderHouseSelector.selectOrder(orders);
    }

    @Override
    protected void doMark(List<Order> orders) {
        orderMarker.markOrder(orders);
    }

    @Override
    void doFilter(List<Order> orders) {
        orderFilter.filterOrder(orders);
    }

    @Override
    void doSort(List<Order> orders) {
        orderSorter.sortOrder(orders);
    }
}

