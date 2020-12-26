public class FactoryMethod {
    public static void main(String[] args) {
        DrinkStore store = new DrinkStore();

        Drink appleDrink = store.sellDrink("apple");
        Drink bananaDrink = store.sellDrink("banana");
        Drink orangeDrink = store.sellDrink("orange");

        System.out.println(appleDrink);
        System.out.println(bananaDrink);
        System.out.println(orangeDrink);
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


class DrinkStore extends DrinkStoreAbstract {

    public Drink factoryMethod(String flavor) {
        Drink drink;

        if (flavor.equals("apple")) {
            drink = new DrinkApple();
        } else if (flavor.equals("banana")) {
            drink = new DrinkBanana();
        } else if (flavor.equals("orange")) {
            drink = new DrinkOrange();
        } else {
            drink = new Drink();
        }

        return drink;
    }
}


class Drink {
    public void packing() {
        //
    }
}

class DrinkApple extends Drink {
}

class DrinkBanana extends Drink {
}

class DrinkOrange extends Drink {
}
