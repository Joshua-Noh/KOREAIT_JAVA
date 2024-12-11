package copilot;

public class Employee extends Person {
    private String department;

    public Employee(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("저는 " + department + " 부서에서 일하고 있습니다.");
    }
}
