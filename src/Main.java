public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.addNewEmployee(new Employee("Иванов Максим Павлович", 1, 67852.36));
        employeeBook.addNewEmployee(new Employee("Петров Никита Иванович", 1, 88745.72));
        employeeBook.addNewEmployee(new Employee("Николаева Анна Владимировна", 2, 79852.17));
        employeeBook.addNewEmployee(new Employee("Смоляков Вадим Вадимович", 3, 65887.53));
        employeeBook.addNewEmployee(new Employee("Никифоров Александр Николаевич", 2, 58442.45));
        employeeBook.addNewEmployee(new Employee("Владимирова Илана Викторовна", 4, 100456.87));
        employeeBook.addNewEmployee(new Employee("Графов Петр Иванович", 4, 72454.79));
        employeeBook.addNewEmployee(new Employee("Смирнов Кирилл Сергеевич", 5, 72454.79));
        employeeBook.addNewEmployee(new Employee("Клементьева Раиса Павловна", 5, 85456.95));
        //employees[9] = new Employee("Ивановская Мария Глебовна", 4, 69785.15);

        employeeBook.addNewEmployee(new Employee("Ивановская Мария Глебовна", 4, 69785.15));
        employeeBook.printEmployeesData();
        System.out.printf("Общие расходы за месяц на оплату труда составляют %.2f рублей%n",
                employeeBook.calculateSalaryExpenses());
        employeeBook.printLowestSalaryEmployee();
        employeeBook.printHighestSalaryEmployee();
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

        employeeBook.deleteEmployee(7);
        employeeBook.printEmployeesNames();
        employeeBook.printEmployeesData();
        System.out.println(employeeBook.calculateAverageSalary());

    }
}
