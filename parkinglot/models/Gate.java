package parkinglot.models;

public class Gate extends BaseModel {

    private long gateNumber;
    private GateStatus gateStatus;
    private Operator currentOperator;
    private GateType type;

    public Gate(){}

    public Gate(GateStatus gateStatus, Operator currentOperator, GateType type) {
        this.gateStatus = gateStatus;
        this.currentOperator = currentOperator;
        this.type = type;
    }

    public long getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(long gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gateNumber=" + gateNumber +
                ", gateStatus=" + gateStatus +
                ", currentOperator=" + currentOperator +
                ", type=" + type +
                '}';
    }
}
