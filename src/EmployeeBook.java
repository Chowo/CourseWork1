import java.util.Objects;

public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(int employeeBookSize) {
        this.employees = new Employee[employeeBookSize];
    }

    public void printEmployeesData() {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            System.out.println(employee);
        }
    }

    public double calculateSalaryExpenses() {
        double expenses = 0.0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            expenses += employee.getSalary();
        }
        return expenses;
    }

    public void printLowestSalaryEmployee() {
        int employeeIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.isNull(employees[i])) {
                continue;
            }
            if (employees[employeeIndex].getSalary() > employees[i].getSalary()) {
                employeeIndex = i;
            }
        }
        System.out.printf("Работник с наименьшей зарплатой: %s%n", employees[employeeIndex].getFullName());
    }

    public void printHighestSalaryEmployee() {
        int employeeIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.isNull(employees[i])) {
                continue;
            }
            if (employees[employeeIndex].getSalary() < employees[i].getSalary()) {
                employeeIndex = i;
            }
        }
        System.out.printf("Работник с наибольшей зарплатой: %s%n", employees[employeeIndex].getFullName());
    }

    public double calculateAverageSalary() {
        return calculateSalaryExpenses() / employees.length;
    }

    public void printEmployeesNames() {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            System.out.println(employee.getFullName());
        }
    }

    public void conductIndexation(double indexation) {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            double indexationResult = employee.getSalary() + employee.getSalary() * indexation / 100;
            employee.setSalary(indexationResult);
        }
    }

    //Вспомогательный Метод для поиска первого индекса работника работающего в искомом отделе для сравнения зарплат
    private int findFirstDepartmentEmployeeIndex(int department) {
        int departmentIndex = -1;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getDepartment() == department) {
                departmentIndex = employee.getDepartment();
                return departmentIndex;
            }
        }
            throw new IndexOutOfBoundsException("В отделе" + department + " нет работников");
    }

    public void findDepartmentLowestSalaryEmployee(int department) {
        int employeeIndex = findFirstDepartmentEmployeeIndex(department);
        for (int i = 0; i < employees.length; i++) {
            if (Objects.isNull(employees[i])) {
                continue;
            }
            if (employees[i].getDepartment() == department &&
                    employees[employeeIndex].getSalary() > employees[i].getSalary()) {
                employeeIndex = i;
            }
        }
        System.out.printf("Работник с наименьшей зарплатой в отделе %s: %s%n",
                department, employees[employeeIndex].getFullName());
    }

    public void findDepartmentHighestSalaryEmployee(int department) {
        int employeeIndex = findFirstDepartmentEmployeeIndex(department);


        for (int i = 0; i < employees.length; i++) {
            if (Objects.isNull(employees[i])) {
                continue;
            }
            if (employees[i].getDepartment() == department &&
                    employees[employeeIndex].getSalary() < employees[i].getSalary()) {
                employeeIndex = i;
            }
        }
        System.out.printf("Работник с наименьшей зарплатой в отделе %s: %s%n",
                department, employees[employeeIndex].getFullName());
    }

    public double calculateDepartmentSalaryExpenses(int department) {
        double expenses = 0.0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getDepartment() == department) {
                expenses += employee.getSalary();
            }
        }
        return expenses;
    }

    public double calculateDepartmentAverageSalary(int department) {
        int employeesInDepartment = getDepartmentSize(department);
        return calculateDepartmentSalaryExpenses(department) / employeesInDepartment;
    }

    private int getDepartmentSize(int department) {
        int departmentEmployeeCounter = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getDepartment() == department) {
                departmentEmployeeCounter++;
            }
        }
        return departmentEmployeeCounter;
    }


    public void conductDepartmentIndexation(int department, double indexation) {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getDepartment() == department) {
                double indexationResult = employee.getSalary() + employee.getSalary() * indexation / 100;
                employee.setSalary(indexationResult);
            }
        }
    }

    public void printDepartmentEmployees(int department) {
        System.out.printf("Работники отдела %s:%n", department);
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getDepartment() == department) {
                System.out.printf("ФИО - %s. Зарплата - %.2f рублей. ID работника - %s%n",
                        employee.getFullName(), employee.getSalary(), employee.getId());
            }
        }
    }

    public void printEmployeesWithLowerSalary(double checkSalary) {
        System.out.printf("Работники с зарплатой ниже %.2f рублей%n", checkSalary);
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getSalary() < checkSalary) {
                System.out.printf("ID работника - %s. ФИО - %s. Зарплата - %.2f рублей%n",
                        employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public void printEmployeesWithHigherSalary(double checkSalary) {
        System.out.printf("Работники с зарплатой выше %.2f рублей%n", checkSalary);
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getSalary() > checkSalary) {
                System.out.printf("ID работника - %s. ФИО - %s. Зарплата - %.2f рублей%n",
                        employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public boolean addNewEmployee (Employee newEmployee){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int deletableEmployeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (Objects.isNull(employees[i])) {
                continue;
            }
            if (employees[i].getId() == deletableEmployeeId) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeByID(int id) {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new IllegalArgumentException("Работника с указанным ID не существует");
    }


}
