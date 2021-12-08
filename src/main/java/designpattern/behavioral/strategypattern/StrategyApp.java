package designpattern.behavioral.strategypattern;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author teohubo
 */
public class StrategyApp {

    public static void main(String[] args) {
        Order order = new Order(1L, 10000, 1, 100L);
        order.setPayPrice(DiscountStrategyFactory.getPayPrice(order));
        System.out.println("noDiscount");
        System.out.println(order.toString());
        Order order1 = new Order(2L, 10001, 2, 100L);
        order1.setPayPrice(DiscountStrategyFactory.getPayPrice(order1));
        System.out.println("normalDiscount:"+order1.toString());
        Order order2 = new Order(3L, 10003, 3, 100L);
        order2.setPayPrice(DiscountStrategyFactory.getPayPrice(order2));
        System.out.println("vipDiscount:"+order2.toString());

    }
}

@Getter
@ToString
class Order{

    private Long id;

    private Integer userId;

    private Integer userType;

    private Long salePrice;

    public void setPayPrice(Long payPrice) {
        this.payPrice = payPrice;
    }

    private Long payPrice;

    public Order(Long id, Integer userId, Integer userType, Long salePrice) {
        this.id = id;
        this.userId = userId;
        this.userType = userType;
        this.salePrice = salePrice;
    }
}

class DiscountStrategyFactory{

    static Map<Integer, Function<Long,Long>> discountMap = new HashMap<>();

    static {
        discountMap.put(1,DiscountStrategyFactory::noDiscount);
        discountMap.put(2,DiscountStrategyFactory::normalDiscount);
        discountMap.put(3,DiscountStrategyFactory::vipDiscount);
    }


    public static Long getPayPrice(Order order) {
        return discountMap.get(order.getUserType()).apply(order.getSalePrice());
    }

    private static Long noDiscount(Long price){
        return price;
    }

    private static Long normalDiscount(Long price){
        return Float.valueOf(String.valueOf(price * 0.8)).longValue();
    }

    private static Long vipDiscount(Long price){
        return Float.valueOf(String.valueOf(price * 0.75)).longValue();
    }
}

