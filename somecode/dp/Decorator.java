public class Decorator {
    public static void main(String[] args) {
        // 只有一份清汤锅底
        HotPot hotpot = new SoupPot();
        hotpot.printMenu();

        // 清汤锅底 + 蔬菜
        hotpot = new VegetablesDish(hotpot);
        hotpot.printMenu();

        // 清汤锅底 + 蔬菜 + 羊肉
        hotpot = new MuttonDish(hotpot);
        hotpot.printMenu();

        // 清汤锅底 + 蔬菜 + 羊肉 + 可乐
        hotpot = new ColaDish(hotpot);
        hotpot.printMenu();

        // 清汤锅底 + 蔬菜 + 羊肉 + 可乐 + 蔬菜
        hotpot = new VegetablesDish(hotpot);
        hotpot.printMenu();
    }
}

class HotPot {
    protected String desc = "HotPot";
    protected double price = 0;

    public String description() {
        return desc;
    }

    public double cost() {
        return price;
    }

    public void printMenu() {
        System.out.println("菜单：" + description() + " 消费总价：" + cost());
    }
}

class SideDish extends HotPot {
    protected HotPot hotpot;

    public double cost() {
        return hotpot.cost() + price;
    };

    public String description() {
        return hotpot.description() +" + "+ desc;
    };
}

class SoupPot extends HotPot {
    public SoupPot() {
        desc = "Soup";
        price = 5;
    }
}

class SpicyPot extends HotPot {
    public SpicyPot() {
        desc = "Spicy";
        price = 7;
    }
}

class VegetablesDish extends SideDish {
    public VegetablesDish(HotPot hotpot) {
        this.hotpot = hotpot;
        desc = "Vegetables";
        price = 3;
    }
}

class MuttonDish extends SideDish {
    public MuttonDish(HotPot hotpot) {
        this.hotpot = hotpot;
        desc = "Mutton";
        price = 6;
    }
}

class ColaDish extends SideDish {
    public ColaDish(HotPot hotpot) {
        this.hotpot = hotpot;
        desc = "Cola";
        price = 2;
    }
}