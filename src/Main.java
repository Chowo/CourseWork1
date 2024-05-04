public class Main {
    static Employee[] employees = new Employee[10];

    public static void printEmployeesData() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double calculateSalaryExpenses() {
        double expenses = 0.0;
        for (Employee employee : employees) {
            expenses += employee.getSalary();
        }
        System.out.printf("Общие расходы за месяц на оплату труда составляют %.2f рублей%n", expenses);
        return expenses;
    }

    public static void findLowestSalaryEmployee() {
        int employeeIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[employeeIndex].getSalary() > employees[i].getSalary()) {
                employeeIndex = i;
            }
        }
        System.out.printf("Работник с наименьшей зарплатой: %s%n", employees[employeeIndex].getFullName());
    }

    public static void findHighestSalaryEmployee() {
        int employeeIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[employeeIndex].getSalary() < employees[i].getSalary()) {
                employeeIndex = i;
            }
        }
        System.out.printf("Работник с наибольшей зарплатой: %s%n", employees[employeeIndex].getFullName());
    }

    public static double calculateAverageSalary() {
        double averageSalary = calculateSalaryExpenses() / employees.length;
        System.out.printf("Средняя заработная плата составляет %.2f рублей%n", averageSalary);
        return averageSalary;
    }

    public static void printEmployeesNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public static void conductIndexation(double indexation) {
        for (Employee employee : employees) {
            double indexationResult = employee.getSalary() + employee.getSalary() * indexation / 100;
            employee.setSalary(indexationResult);
        }
    }

    public static Employee[] makeDepartmentEmployeeArray(int deparment) {
        int departmentEmployeeCounter = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == deparment) {
                departmentEmployeeCounter++;
            }
        }
        Employee[] departmentEmployees = new Employee[departmentEmployeeCounter];
        departmentEmployeeCounter = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == deparment) {
                departmentEmployees[departmentEmployeeCounter] = employee;
                departmentEmployeeCounter++;
            }
        }
        return departmentEmployees;
    }

    public static void findDepartmentLowestSalaryEmployee(int department) {
        int employeeIndex = 0;
        Employee[] departmentEmployees = makeDepartmentEmployeeArray(department);

        for (int i = 0; i < departmentEmployees.length; i++) {
            if (departmentEmployees[employeeIndex].getSalary() > departmentEmployees[i].getSalary()) {
                employeeIndex = i;
            }
        }
        System.out.printf("Работник с наименьшей зарплатой в отделе %s: %s%n", department, departmentEmployees[employeeIndex].getFullName());
    }

    public static void findDepartmentHighestSalaryEmployee(int department) {
        int employeeIndex = 0;
        Employee[] departmentEmployees = makeDepartmentEmployeeArray(department);

        for (int i = 0; i < departmentEmployees.length; i++) {
            if (departmentEmployees[employeeIndex].getSalary() < departmentEmployees[i].getSalary()) {
                employeeIndex = i;
            }
        }
        System.out.printf("Работник с наименьшей зарплатой в отделе %s: %s%n", department, departmentEmployees[employeeIndex].getFullName());
    }

    public static double calculateDepartmentSalaryExpenses(int department) {
        double expenses = 0.0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                expenses += employee.getSalary();
            }
        }
        System.out.printf("Общие расходы за месяц на оплату труда составляют %.2f рублей%n", expenses);
        return expenses;
    }

    public static double calculateDepartmentAverageSalary(int department) {
        int employeesInDeparment = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employeesInDeparment++;
            }
        }
        double averageSalary = calculateDepartmentSalaryExpenses(department) / employeesInDeparment;
        System.out.printf("Средняя заработная плата составляет %.2f рублей%n", averageSalary);
        return averageSalary;
    }

    public static void conductDepartmentIndexation(int deparment, double indexation) {

        for (Employee employee : employees) {
            if (employee.getDepartment() == deparment) {
                double indexationResult = employee.getSalary() + employee.getSalary() * indexation / 100;
                employee.setSalary(indexationResult);
            }
        }
    }

    public static void printDepartmentEmployees(int department) {
        System.out.printf("Работники отдела %s:%n", department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.printf("ФИО - %s. Зарплата - %.2f рублей. ID работника - %s%n",
                        employee.getFullName(), employee.getSalary(), employee.getId());
            }
        }
    }

    public static void printEmployeesWithLowerSalary(double checkSalary) {
        System.out.printf("Работники с зарплатой ниже %.2f рублей%n", checkSalary);
        for (Employee employee : employees) {
            if (employee.getSalary() < checkSalary) {
                System.out.printf("ID работника - %s. ФИО - %s. Зарплата - %.2f рублей%n",
                        employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithHigherSalary(double checkSalary) {
        System.out.printf("Работники с зарплатой выше %.2f рублей%n", checkSalary);
        for (Employee employee : employees) {
            if (employee.getSalary() > checkSalary) {
                System.out.printf("ID работника - %s. ФИО - %s. Зарплата - %.2f рублей%n",
                        employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }


    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Максим Павлович", 1, 67852.36);
        employees[1] = new Employee("Петров Никита Иванович", 1, 88745.72);
        employees[2] = new Employee("Николаева Анна Владимировна", 2, 79852.17);
        employees[3] = new Employee("Смоляков Вадим Вадимович", 3, 65887.53);
        employees[4] = new Employee("Никифоров Александр Николаевич", 2, 58442.45);
        employees[5] = new Employee("Владимирова Илана Викторовна", 4, 100456.87);
        employees[6] = new Employee("Графов Петр Иванович", 4, 72454.79);
        employees[7] = new Employee("Смирнов Кирилл Сергеевич", 5, 72454.79);
        employees[8] = new Employee("Клементьева Раиса Павловна", 5, 85456.95);
        employees[9] = new Employee("Ивановская Мария Глебовна", 4, 69785.15);
        printEmployeesData();
        calculateSalaryExpenses();
        findLowestSalaryEmployee();
        findHighestSalaryEmployee();
        calculateAverageSalary();
        printEmployeesNames();
        conductIndexation(0.1);
        printEmployeesData();
        findDepartmentLowestSalaryEmployee(4);
        findDepartmentHighestSalaryEmployee(4);
        calculateDepartmentSalaryExpenses(4);
        calculateDepartmentAverageSalary(4);
        conductDepartmentIndexation(4, 0.4);
        printEmployeesData();
        printDepartmentEmployees(4);
        printEmployeesWithLowerSalary(75000.0);
        printEmployeesWithHigherSalary(75000.0);

    }
}
