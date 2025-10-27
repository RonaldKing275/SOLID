package solid.ocp;

public abstract class Employee {

    protected int salary;

    public Employee(int salary) {
        this.salary = salary;
    }

    public abstract int payAmount();

}