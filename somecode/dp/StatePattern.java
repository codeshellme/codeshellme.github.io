public class StatePattern {
    public static void main(String[] args) {
        RoleStateMachine role = new RoleStateMachine();

        // 初始状态为 StateA，积分为 0
        assert role.getCurrentState().equals("StateA");
        assert role.getScore() == 0;

        role.y(); // 在状态 A 进行 y 操作

        // 在状态 A 时，没有 y 操作
        // 所以如果进行 y 操作，状态和积分都保持不变
        assert role.getCurrentState().equals("StateA");
        assert role.getScore() == 0;

        role.x(); // 在状态 A 进行 x 操作
        assert role.getCurrentState().equals("StateB");
        assert role.getScore() == 100;

        role.y(); // 在状态 B，进行 y 操作
        assert role.getCurrentState().equals("StateD");
        assert role.getScore() == 300;

        role.z(); // 在状态 D，进行 z 操作
        assert role.getCurrentState().equals("StateC");
        assert role.getScore() == 250;

        role.z(); // 在状态 C，进行 z 操作
        assert role.getCurrentState().equals("StateA");
        assert role.getScore() == 200;

        System.out.println("Test OK.");
    }
}

abstract class State {
    protected String stateName;
    protected RoleStateMachine machine;

    void x() {
        // do nothing
    }

    void y() {
        // do nothing
    }

    void z() {
        // do nothing
    }

    // 获取当前状态名
    public String getStateName() {
        return stateName;
    }
}

class RoleStateMachine {
    private State currentState; // 当前状态
    private int score;          // 积分

    public RoleStateMachine() {
        this.score = 0;
        this.currentState = new StateA(this);
    }

    // 当发生某个操作时需要转化到相应的状态
    // 用该方法进行设置
    public void setCurrentState(State state) {
        currentState = state;
    }

    // 获取当前状态
    public String getCurrentState() {
        return currentState.getStateName();
    }

    // 获取积分
    public int getScore() {
        return score;
    }

    // 增加积分
    public void addScore(int score) {
        this.score += score;
    }

    // 减少积分
    public void delScore(int score) {
        this.score -= score;
    }

    // 状态机中也包含状态中的所有操作
    // 每个操作都委托给当前状态的相应操作来完成

    public void x() {
        currentState.x();
    }

    public void y() {
        currentState.y();
    }

    public void z() {
        currentState.z();
    }
}

class StateA extends State {
    public StateA(RoleStateMachine machine) {
        this.machine = machine;
        this.stateName = "StateA";
    }

    public void x() {
        machine.addScore(100);
        machine.setCurrentState(new StateB(machine));
    }
}

class StateB extends State {
    public StateB(RoleStateMachine machine) {
        this.machine = machine;
        this.stateName = "StateB";
    }

    public void x() {
        machine.addScore(100);
        machine.setCurrentState(new StateC(machine));
    }

    public void y() {
        machine.addScore(200);
        machine.setCurrentState(new StateD(machine));
    }
}

class StateC extends State {
    public StateC(RoleStateMachine machine) {
        this.machine = machine;
        this.stateName = "StateC";
    }

    public void x() {
        machine.addScore(100);
        machine.setCurrentState(new StateD(machine));
    }

    public void z() {
        machine.delScore(50);
        machine.setCurrentState(new StateA(machine));
    }
}

class StateD extends State {
    public StateD(RoleStateMachine machine) {
        this.machine = machine;
        this.stateName = "StateD";
    }

    public void z() {
        machine.delScore(50);
        machine.setCurrentState(new StateC(machine));
    }
}