public class Adapter {
    public static void xiaoMing(BicycleInterface b) {
        b.ride();
    }

    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        Car c = new Car();

        xiaoMing(b);
        // xiaoMing(c); //类型不匹配

        CarAdapter ca = new CarAdapter(c); // 将 Car 适配成 Bicycle
        xiaoMing(ca); // 小明可以用了
    }
}

class CarAdapter implements BicycleInterface {
    private CarInterface car;

    public CarAdapter(CarInterface car) {
        this.car = car;
    }

    public void ride() {
        car.drive();
    }
}

interface BicycleInterface {
    void ride();
}

class Bicycle implements BicycleInterface {
    public void ride() {
        System.out.println("I am riding a bicycle.");
    }
}

interface CarInterface {
    void drive();
}

class Car implements CarInterface {
    public void drive() {
        System.out.println("I am driving a car.");
    }
}
