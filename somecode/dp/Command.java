public class Command {
    public static void main(String[] args) {
        Client c = new Client();
        Order order = c.createOrder(); // 顾客生成订单

        Taobao t = new Taobao();
        t.receiveOrder(order);         // 淘宝接收订单
        t.handleOrder();               // 淘宝处理订单
    }
}

class Taobao {
    private Order order;

    public void receiveOrder(Order order) {
        this.order = order;
    }

    // 处理订单
    public void handleOrder() {
        order.execute();
    }
}

class Client {
    public Order createOrder() {
        Shops phone = new HuaWeiShop();
        Order phoneOrder = new GoodsOrder(phone);
        return phoneOrder;
    }
}

interface Order {
    void execute();
}

class GoodsOrder implements Order {
    private Shops shop;

    public GoodsOrder(Shops shop) {
        this.shop = shop;
    }

    public void execute() {
        String goods = shop.sell();
        System.out.println(goods);
    }
}

abstract class Shops {
    protected String shopName;
    protected abstract String sell();
}

class HuaWeiShop extends Shops {

    public HuaWeiShop() {
        this.shopName = "HUAWEI";
    }

    public String sell() {
        return "HuaWei Phone";
    }
}