package Lesson1DZ.four;

import Lesson1DZ.Employee;

public class Dz {
    public static void main(String [] args) {

        Employee work = new Employee("Ivan", 15000, 27);
        Employee workHelper = new Employee("Vladimir", 11000, 18);
        Employee checkMen = new Employee("Grigoriy", 17000, 55);
        Employee accountant = new Employee("Potap", 50000, 89);
        Employee driver = new Employee("Vasilich", 20000, 42);

        Employee[] employees = {work, workHelper, checkMen, accountant, driver};
        double b = 0;
        double c = 0;
        for (int i = 0; i < employees.length; i++) {
            System.out.print(employees[i]);
            if (employees[i].getAge() > 45) employees[i].setSalary(employees[i].getSalary()+5000);
            System.out.println(" ЗПешка " + employees[i].getSalary());
            b += employees[i].getSalary() / employees.length;
            c += employees[i].getAge() / employees.length;
        }
        System.out.println("Средняя зарплата = " + b + "; Средний возраст сотрудников = " + c);
    }
}
