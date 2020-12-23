public class AbstractMethod {
    public static void main(String[] args) {
        DrinkStoreAbstract beiStore = new BeijingDrinkStore();
        beiStore.sellDrink("apple");
        beiStore.sellDrink("banana");
        beiStore.sellDrink("orange");

        DrinkStoreAbstract shangStore = new ShangHaiDrinkStore();
        shangStore.sellDrink("apple");
        shangStore.sellDrink("banana");
        shangStore.sellDrink("orange");
    }
}

abstract class DrinkStoreAbstract {

    // final 防止子类覆盖
    public final Drink sellDrink(String flavor) {

        Drink drink = factoryMethod(flavor);    // 使用实例

        drink.packing();

        return drink;
    }

    // 子类必须实现
    protected abstract Drink factoryMethod(String flavor);
}

class BeijingDrinkStore extends DrinkStoreAbstract {

    @Override
    protected Drink factoryMethod(String flavor) {
        Drink drink = null;
        DrinkBoxFactory factory = new BeiJingBoxFactory();

        if (flavor.equals("apple")) {
            drink = new DrinkApple(factory);
        } else if (flavor.equals("banana")) {
            drink = new DrinkBanana(factory);
        } else if (flavor.equals("orange")) {
            drink = new DrinkOrange(factory);
        }

        return drink;
    }
}


class ShangHaiDrinkStore extends DrinkStoreAbstract {

    @Override
    protected Drink factoryMethod(String flavor) {
        Drink drink = null;
        DrinkBoxFactory factory = new ShangHaiBoxFactory();

        if (flavor.equals("apple")) {
            drink = new DrinkApple(factory);
        } else if (flavor.equals("banana")) {
            drink = new DrinkBanana(factory);
        } else if (flavor.equals("orange")) {
            drink = new DrinkOrange(factory);
        }

        return drink;
    }
}


interface DrinkBoxFactory {
    String createBox();
}


class BeiJingBoxFactory implements DrinkBoxFactory {

    @Override
    public String createBox() {
        return "BeijingBox";
    }
}


class ShangHaiBoxFactory implements DrinkBoxFactory {

    @Override
    public String createBox() {
        return "ShangHaiBox";
    }
}


abstract class Drink {
    String flavor;
    protected abstract void packing();
}


class DrinkApple extends Drink {
    DrinkBoxFactory boxFactory;

    public DrinkApple(DrinkBoxFactory boxFactory) {
        this.boxFactory = boxFactory;
        this.flavor = "DrinkApple";
    }

    @Override
    public void packing() {
        System.out.println(flavor + boxFactory.createBox());
    }
}


class DrinkBanana extends Drink {
    DrinkBoxFactory boxFactory;

    public DrinkBanana(DrinkBoxFactory boxFactory) {
        this.boxFactory = boxFactory;
        this.flavor = "DrinkBanana";
    }

    @Override
    public void packing() {
        System.out.println(flavor + boxFactory.createBox());
    }
}


class DrinkOrange extends Drink {
    DrinkBoxFactory boxFactory;

    public DrinkOrange(DrinkBoxFactory boxFactory) {
        this.boxFactory = boxFactory;
        this.flavor = "DrinkOrange";
    }

    @Override
    public void packing() {
        System.out.println(flavor + boxFactory.createBox());
    }
}