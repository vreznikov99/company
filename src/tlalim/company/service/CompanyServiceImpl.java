package tlalim.company.service;

import tlalim.company.dto.*;

import java.util.*;

public class CompanyServiceImpl implements CompanyService {
    HashMap<Long, Employee> employeesMap = new HashMap<>();
    HashMap<String, Set<Employee>> employeesDepartment = new HashMap<>();

    @Override
    /*
     *  Adds new Employee into a company
     *  In the case an employee with the given ID already exists,
     *  the exception IllegalStateException must be thrown
     *  returns reference to the being added Employee object
     */
    public Employee hireEmployee(Employee empl) {
        // Algorithm Complexity: O[1]
        return null;
    }

    @Override
    /*
     *  Removes Employee object from company according to a given ID
     *  In the case an employee with the given ID doesn't exist
     *  the method must throw IllegalStateException
     */
    public Employee fireEmployee(long id) {
        // Algorithm Complexity: O[1]
        return null;
    }

    @Override
    /*
     *  Returns reference to Employee object with a given ID value
     *  In the case employee with the ID doesn't exist
     *  the method returns null
     */
    public Employee getEmployee(long id) {
        // Algorithm Complexity: O[1]
        return null;
    }

    @Override
    /*
     *  Returns list of Employee objects working in given Department
     *  In the case none employees in the department the method returns empty list
     */
    public List<Employee> getEmployeesByDepartment(String department) {
        // Algorithm Complexity: O[N]
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {

        return null;
    }

    @Override
    public List<Employee> getEmployessBySalary(int salaryFrom, int salaryTo) {

        return null;
    }

    @Override
    public List<Employee> getEmployeeByAge(int ageFrom, int ageTo) {

        return null;
    }

    @Override
    public List<DepartmentAvgSalary> salaryDistributionByDepartments() {

        return null;
    }

    @Override
    public List<SalaryIntervalDistribution> getSalaryDistribution(int interval) {

        return null;
    }

    @Override
    public Employee updateDepartment(long id, String newDepartment) {

        return null;
    }

    @Override
    public Employee updateSalary(long id, int newSalary) {

        return null;
    }

    @Override
    public void save(String filePath) {

    }

    @Override
    public void restore(String filePath) {

    }
}
