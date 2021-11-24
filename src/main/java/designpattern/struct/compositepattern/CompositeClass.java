package designpattern.struct.compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author teohubo
 */
public class CompositeClass {


    /**
     * 构造树
     * 销售部  ---- 北京大区-----张三
     *        ----李四
     *        ----罗翔
     */
    public static void main(String[] args) {
        Department sale = new Department(1, "Sale");
        Department beijing = new Department(2, "beijing-sale");
        Staff zhngsan = new Staff(3, "zhngsan");
        Staff lisi = new Staff(4, "lisi");
        Staff luoxiang = new Staff(5, "luoxiang");
        beijing.addSubNode(zhngsan);
        sale.addSubNode(beijing);
        sale.addSubNode(lisi);
        sale.addSubNode(luoxiang);
        System.out.println(sale.getStaffNums());

    }
}

abstract class HumanResources{

    private int id;

    private String name;

    public HumanResources(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract int getStaffNums();

}

class Department extends HumanResources{

    private List<HumanResources> childs;

    public Department(int id, String name) {
        super(id, name);
        this.childs = new ArrayList<>();
    }

    public void addSubNode(HumanResources resources){
        this.childs.add(resources);
    }

    @Override
    int getStaffNums() {
        return childs.stream().mapToInt(HumanResources::getStaffNums).sum();
    }
}

class Staff extends HumanResources{

    public Staff(int id, String name) {
        super(id, name);
    }

    @Override
    int getStaffNums() {
        return 1;
    }
}
