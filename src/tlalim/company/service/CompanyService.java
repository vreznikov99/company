package tlalim.company.service;

import tlalim.company.dto.DepartmentAvgSalary;
import tlalim.company.dto.Employee;
import tlalim.company.dto.SalaryIntervalDistribution;

import java.util.List;

public interface CompanyService {
    Employee hireEmployee(Employee empl);
    Employee fireEmployee(long id);
    Employee getEmployee(long id);
    List<Employee> getEmployeesByDepartment(String department);
    List<Employee> getAllEmployees();
    List<Employee> getGetEmployessBySalary(int salaryFrom, int salaryTo);
    List<Employee> getEmployeeByAge(int ageFrom, int ageTo);
    List<DepartmentAvgSalary>  salaryDistributionByDepartments();
    List<SalaryIntervalDistribution> getSalaryDistribution(int interval);
    Employee updateDepartment(long id, String newDepartment);
    Employee updateSalary(long id, int newSalary);
    void save(String filePath);
    void restore(String filePath);


}
