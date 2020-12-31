public class Facede {
    public static void main(String[] args) {
//        Vegetables v = new Vegetables();
//        v.bugVegetables();
//        v.washVegetables();
//        v.fryVegetables();
//
//        Rice r = new Rice();
//        r.fryRice();
//
//        Bowl b = new Bowl(v, r);
//        b.prepare();
//
//        System.out.println("xiao ming is having a meal.");
//
//        b.washBowl();

        Nanny n = new Nanny();
        n.prepareMeal();

        System.out.println("xiao ming is having a meal.");

        n.cleanUp();
    }
}

class Nanny {
    private Vegetables v;
    private Rice r;
    private Bowl b;

    public Nanny() {
        v = new Vegetables();
        r = new Rice();
        b = new Bowl(v, r);
    }

    public void prepareMeal() {
        v.bugVegetables();
        v.washVegetables();
        v.fryVegetables();

        r.fryRice();

        b.prepare();
    }

    public void cleanUp() {
        b.washBowl();
    }
}

class Vegetables {
    public void bugVegetables() {
        System.out.println("buying vegetables.");
    }

    public void washVegetables() {
        System.out.println("washing vegetables.");
    }

    public void fryVegetables() {
        System.out.println("frying vegetables.");
    }

    public void toBowl() {
        System.out.println("putting the vegetables into the bowl.");
    }
}

class Rice {
    public void fryRice() {
        System.out.println("frying rice.");
    }

    public void toBowl() {
        System.out.println("putting the rice into the bowl.");
    }
}

class Bowl {
    private Vegetables vegetables;
    private Rice rice;

    public Bowl(Vegetables vegetables, Rice rice) {
        this.vegetables = vegetables;
        this.rice = rice;
    }

    // 盛好饭菜
    public void prepare() {
        vegetables.toBowl();
        rice.toBowl();
    }

    public void washBowl() {
        System.out.println("washing bowl.");
    }
}