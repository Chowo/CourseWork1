import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private double salary;
    private static int idCounter = 1;
    private int id;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        setDepartment(department);
        setSalary(salary);
        id = idCounter;
        idCounter++;
    }

    public void setDepartment(int department) {
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Указан не верный номер отдела");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Указана некорректная зарплата сотрудника");
        }
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Employee employee = (Employee) object;
        return getFullName().equals(employee.getFullName()) &&
                getDepartment() == employee.getDepartment() &&
                getId() == employee.id;
    }

    public int hashCode() {
        return Objects.hash(getFullName(), getId());
    }

    public String toString() {
        return "ФИО - " + getFullName() +
                ". Отдел № " + getDepartment() +
                ". Зарплата - " + getSalary() + " рублей." +
                "ID работника - " + getId();
    }
}
