package leetcode.algorithm;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.algorithm
 * @createTime : 2023/2/24 10:20
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
class Item {
    String name;
    Double weight;
    Integer profit;

    public Item(String name, Double weight, Integer profit) {
        this.name = name;
        this.weight = weight;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getProfit() {
        return profit;
    }
}

public class Package {
    Integer totalWeight;
    List<Item> items;

    public Package(Integer totalWeight, List<Item> items) {
        this.totalWeight = totalWeight;
        this.items = items;
    }

    static Map<Double, String> map = new HashMap<>();

    public double cal() {
        return single(this.totalWeight, "");
    }

    public double single(double tw, String s) {
        if (tw <= 0) {

            return 0;
        }
        List<Double> tmp = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            String ts = s + items.get(i).getName() + " ";
            tmp.add(items.get(i).getProfit()
                    + single(tw - items.get(i).getWeight(),
                    ts));
            map.put(tmp.get(i), ts);
        }
        tmp.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o2, o1);
            }
        });
        return tmp.get(0);
    }


    static Package aPackage = new Package(15, new ArrayList<Item>());

    public static void main(String[] args) {
        aPackage.items.add(new Item("A", 12.0, 4));
        aPackage.items.add(new Item("B", 1.0, 2));
        aPackage.items.add(new Item("C", 4.0, 10));
        aPackage.items.add(new Item("D", 1.0, 1));
        aPackage.items.add(new Item("E", 2.0, 2));
        Double val = aPackage.cal();
        System.out.println(val);
        String[] s = map.get(val).split("");

        for (String x : s) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(".................");
    }
}
