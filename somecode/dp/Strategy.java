public class Strategy {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal pig = new Pig();
        Animal rabbit = new Rabbit();

        dog.eatGrass();
        pig.eatGrass();
        rabbit.eatGrass();
    }
}

abstract class Animal {
    protected EatGrassable eg;

    public Animal() {
        eg = null;
    }

    public void run() {
        System.out.println("I can run.");
    }

    public void drinkWater() {
        System.out.println("I can drink water.");
    }

    public void eatGrass() {
        if (eg != null) {
            eg.eatGrass();
        }
    }

    protected abstract String type();
}

class Dog extends Animal {
    public Dog() {
        // Dog 不能吃草
        eg = new EatNoGrass();
    }

    public String type() {
        return "Dog";
    }
}

class Pig extends Animal {
    public Pig() {
        eg = new EatGreenGrass();
    }

    public String type() {
        return "Pig";
    }
}

class Rabbit extends Animal {
    public Rabbit() {
        eg = new EatDogtailGrass();
    }

    public String type() {
        return "Rabbit";
    }
}

interface EatGrassable {
    void eatGrass();
}

class EatGreenGrass implements EatGrassable {
    // 吃绿草
    public void eatGrass() {
        System.out.println("I can eat green grass.");
    }
}

class EatDogtailGrass implements EatGrassable {
    // 吃狗尾草
    public void eatGrass() {
        System.out.println("I can eat dogtail grass.");
    }
}

class EatNoGrass implements EatGrassable {
    // 不是真的吃草
    public void eatGrass() {
        System.out.println("I can not eat grass.");
    }
}
