import java.util.ArrayList;

public class Observers {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();
        ConcreteObserver o1 = new ConcreteObserver("o1");
        ConcreteObserver o2 = new ConcreteObserver("o2");

        s.registerObserver(o1); // 注册 o1
        s.registerObserver(o2); // 注册 o2
        s.notifyObservers("info1");  // 向观察者通知消息

        System.out.println("remove observer o1");

        s.removeObserver(o1);  // 移除 o1
        s.notifyObservers("info2"); // 再向观察者通知消息
    }
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String info);
}

interface Observer {
    void update(String info);
}

class ConcreteSubject implements Subject {
    private final ArrayList<Observer> observers;

    public ConcreteSubject() {
        observers = new ArrayList();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String info) {
        for (Observer o: observers) {
            o.update(info);
        }
    }
}

class ConcreteObserver implements Observer {
    private final String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String info) {
        System.out.println(this.name + " get info: " + info);
    }
}