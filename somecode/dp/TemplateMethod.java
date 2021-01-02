public class TemplateMethod {
    public static void main(String[] args) {
        AppleBeverage apple = new AppleBeverage(true);
        apple.makeBeverage();

        OrangeBeverage orange = new OrangeBeverage(false);
        orange.makeBeverage();
    }
}

abstract class Beverage {
    protected boolean isSweet;

    // 榨果汁
    public abstract void squeezeJuice();

    // 将果汁倒入杯中
    public abstract void juiceToCup();

    // 向杯中倒入水
    public void waterToCup() {
        System.out.println("pour water into the cup");
    }

    // 向杯中倒入白糖
    public void sugarToCup() {
        System.out.println("pour sugar into the cup");
    }

    // 制作苹果饮料
    public final void makeBeverage() {
        squeezeJuice();
        juiceToCup();
        waterToCup();

        if (isSweet) {
            sugarToCup();
        }
    }
}


class AppleBeverage extends Beverage {
    public AppleBeverage(boolean isSweet) {
        this.isSweet = isSweet;
    }

    public void squeezeJuice() {
        System.out.println("squeeze apple juice");
    }

    public void juiceToCup() {
        System.out.println("pour the apple juice into the cup");
    }
}

class OrangeBeverage extends Beverage {
    public OrangeBeverage(boolean isSweet) {
        this.isSweet = isSweet;
    }

    public void squeezeJuice() {
        System.out.println("squeeze orange juice");
    }

    public void juiceToCup() {
        System.out.println("pour the orange juice into the cup");
    }
}

/*
class AppleBeverage {
    private boolean isSweet;

    public AppleBeverage(boolean isSweet) {
        this.isSweet = isSweet;
    }

    // 把苹果榨成苹果汁
    public void squeezeAppleJuice() {
        System.out.println("squeeze apple juice");
    }

    // 将苹果汁倒入杯中
    public void appleJuiceToCup() {
        System.out.println("pour the apple juice into the cup");
    }

    // 向杯中倒入水
    public void waterToCup() {
        System.out.println("pour water into the cup");
    }

    // 向杯中倒入白糖
    public void sugarToCup() {
        System.out.println("pour sugar into the cup");
    }

    // 制作苹果饮料
    public void makeAppleBeverage() {
        squeezeAppleJuice();
        appleJuiceToCup();
        waterToCup();

        if (isSweet) {
            sugarToCup();
        }
    }
}

class OrangeBeverage {
    private boolean isSweet;

    public OrangeBeverage(boolean isSweet) {
        this.isSweet = isSweet;
    }

    // 把橙子榨成橙汁
    public void squeezeOrangeJuice() {
        System.out.println("squeeze orange juice");
    }

    // 将橙汁倒入杯中
    public void orangeJuiceToCup() {
        System.out.println("pour the orange juice into the cup");
    }

    // 向杯中倒入水
    public void waterToCup() {
        System.out.println("pour water into the cup");
    }

    // 向杯中倒入白糖
    public void sugarToCup() {
        System.out.println("pour sugar into the cup");
    }

    // 制作橙子饮料
    public void makeOrangeBeverage() {
        squeezeOrangeJuice();
        orangeJuiceToCup();
        waterToCup();

        if (isSweet) {
            sugarToCup();
        }
    }
}
*/