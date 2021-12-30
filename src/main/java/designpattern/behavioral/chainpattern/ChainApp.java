package designpattern.behavioral.chainpattern;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author teohubo
 */
public class ChainApp {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new StatusFilter()).addFilter(new TypeFilter());
        Order o1 = new Order(1, 1, 1);
        Order o2 = new Order(2,2,2);
        Order o3  = new Order(3,1,-1);
        Order o4 = new Order(4, 3, 1);
        ArrayList<Order> orders = Lists.newArrayList(o1, o2, o3, o4);
        filterChain.filterOrders(orders);
        System.out.println(JSONObject.toJSONString(orders));
    }
}


class FilterChain{
    List<OrderFilter> filters = new ArrayList<>();

    public FilterChain addFilter(OrderFilter filter){
        this.filters.add(filter);
        return this;
    }

    public void filterOrders(List<Order> orders){
        filters.forEach(filter -> filter.filterOrders(orders));
    }
}
interface OrderFilter{

    /**
     * 过滤订单接口
     * @param orders
     */
    void filterOrders(List<Order> orders);
}

class StatusFilter implements OrderFilter{

    /**
     * 过滤订单接口
     *
     * @param orders
     */
    @Override
    public void filterOrders(List<Order> orders) {
        orders.removeIf(order -> order.getStatus() == -1);
    }
}

class TypeFilter implements OrderFilter{

    /**
     * 过滤订单接口
     *
     * @param orders
     */
    @Override
    public void filterOrders(List<Order> orders) {
        orders.removeIf(order -> order.getType() == 1);

    }
}
