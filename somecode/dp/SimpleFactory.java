public class SimpleFactory {
    public static void main(String[] args) {
        SimpleDrinkFactory factory = new SimpleDrinkFactory();
        DrinkStore store = new DrinkStore(factory);

        Drink appleDrink = store.sellDrink("apple");
        Drink bananaDrink = store.sellDrink("banana");
        Drink orangeDrink = store.sellDrink("orange");

        System.out.println(appleDrink);
        System.out.println(bananaDrink);
        System.out.println(orangeDrink);
    }
}


class DrinkStore {
    private SimpleDrinkFactory factory;

    public DrinkStore(SimpleDrinkFactory factory) {
        this.factory = factory;
    }

    Drink sellDrink(String flavor) {
        Drink drink = factory.createDrink(flavor);

        drink.packing();

        return drink;
    }
}


class SimpleDrinkFactory {
    public Drink createDrink(String flavor) {
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