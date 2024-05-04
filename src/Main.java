public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Максим Павлович", 1, 67852.36);
        employees[1] = new Employee("Петров Никита Иванович", 1, 88745.72);
        employees[2] = new Employee("Николаева Анна Владимировна", 2, 79852.17);
        employees[3] = new Employee("Смоляков Вадим Вадимович", 3, 65887.53);
        employees[4] = new Employee("Никифоров Александр Николаевич", 2, 58442.45);
        employees[5] = new Employee("Владимирова Илана Викторовна", 4, 100456.87);
        employees[6] = new Employee("Графов Петр Иванович", 4, 72454.79);
        employees[7] = new Employee("Смирнов Кирилл Сергеевич", 5, 72454.79);
        employees[8] = new Employee("Клементьева Раиса Павловна", 5, 85456.95);
        //employees[9] = new Employee("Ивановская Мария Глебовна", 4, 69785.15);

        EmployeeBook employeeBook = new EmployeeBook(employees);
        employeeBook.addNewEmployee(new Employee("Ивановская Мария Глебовна", 4, 69785.15));
        employeeBook.printEmployeesData();
        System.out.printf("Общие расходы за месяц на оплату труда составляют %.2f рублей%n",
                employeeBook.calculateSalaryExpenses());
        employeeBook.findLowestSalaryEmployee();
        employeeBook.findHighestSalaryEmployee();
        System.out.printf("Средняя заработная плата составляет %.2f рублей%n",
                employeeBook.calculateAverageSalary());
        employeeBook.printEmployeesNames();
        employeeBook.conductIndexation(0.1);
        employeeBook.printEmployeesData();
        employeeBook.findDepartmentLowestSalaryEmployee(4);
        employeeBook.findDepartmentHighestSalaryEmployee(4);
        System.out.printf("Общие расходы за месяц на оплату труда составляют %.2f рублей%n",
                employeeBook.calculateDepartmentSalaryExpenses(4));
        System.out.printf("Средняя заработная плата составляет %.2f рублей%n",
                employeeBook.calculateDepartmentAverageSalary(4));
        employeeBook.conductDepartmentIndexation(4, 0.4);
        employeeBook.printEmployeesData();
        employeeBook.printDepartmentEmployees(4);
        employeeBook.printEmployeesWithLowerSalary(75000.0);
        employeeBook.printEmployeesWithHigherSalary(75000.0);
        System.out.println(employeeBook.addNewEmployee(new Employee("Ивановская Мария Глебовна", 4, 69785.15)));
        System.out.println(employeeBook.deleteEmployee(5));
        System.out.println(employeeBook.addNewEmployee(new Employee("DDD", 4, 69785.15)));
        employeeBook.printEmployeesData();

        System.out.println(employeeBook.getEmployeeByID(5));
        System.out.println(employeeBook.getEmployeeByID(10));
        System.out.println(employeeBook.getEmployeeByID(15));

    }
}
