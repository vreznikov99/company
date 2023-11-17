package tlalim.company.service;

import tlalim.company.dto.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class CompanyServiceImpl implements CompanyService {
    HashMap<Long, Employee> employeesMap = new HashMap<>();
    HashMap<String, Set<Employee>> employeesDepartment = new HashMap<>();  // key - department, value - Set of employees working in the department
    TreeMap<Integer, Set<Employee>> employeesSalary = new TreeMap<>();     // key - salary, value - set of employees having the salary value
    TreeMap<LocalDate, Set<Employee>> employeesAge = new TreeMap<>();      // key - birthdate, value - set of employees born at the date


    @Override
    /*
     *  Adds new Employee into a company
     *  In the case an employee with the given ID already exists,
     *  the exception IllegalStateException must be thrown
     *  returns reference to the being added Employee object
     */
    public Employee hireEmployee(Employee empl) {
        // Algorithm Complexity: O[1]
        long id = empl.id();
        if(employeesMap.containsKey(id)){
            throw new IllegalStateException("Employee already exists" + id);
        }
        employeesMap.put(id, empl);
        addEmployeeSalary(empl);
        addEmployeeDepartment(empl);
        addEmployeeAge(empl);
        return empl;
    }

    private void addEmployeeDepartment(Employee empl) {
        String department = empl.department();
        Set<Employee> set = employeesDepartment.get(department);
        if(set == null){
            set = new HashSet<>();
            employeesDepartment.put(department, set);
        }
        set.add(empl);
    }

    private void addEmployeeAge(Employee empl) {
        LocalDate birthDate = empl.birthDate();
        Set<Employee> set = employeesAge.computeIfAbsent(birthDate, k -> new HashSet<>());
        set.add(empl);

    }

    private void addEmployeeSalary(Employee empl) {
        int salary = empl.salary();
        employeesSalary.computeIfAbsent(salary, k -> new HashSet<>()).add(empl);

    }

    @Override
    /*
     *  Removes Employee object from company according to a given ID
     *  In the case an employee with the given ID doesn't exist
     *  the method must throw IllegalStateException
     */
    public Employee fireEmployee(long id) {
        // Algorithm Complexity: O[1]
        Employee empl = employeesMap.remove(id);
        if(empl == null)
        {
            throw new IllegalStateException("Employee not found" + id);
        }
        removeEmployeesDepartment(empl);
        removeEmployeesSalary(empl);
        removeEmployeesAge(empl);
        return empl;
    }

    private void removeEmployeesAge(Employee empl) {
        LocalDate birthDate = empl.birthDate();
        Set<Employee> set = employeesAge.get(birthDate);
        set.remove(empl); // removing reference to being removed employee from the set of employees with a given birth date
        if(set.isEmpty()){
            employeesAge.remove(birthDate);
        }

    }

    private void removeEmployeesSalary(Employee empl) {
        int salary = empl.salary();
        Set<Employee> set = employeesSalary.get(salary);
        set.remove(empl);
        if(set.isEmpty()){
            employeesSalary.remove(salary);
        }
    }

    private void removeEmployeesDepartment(Employee empl) {
        String department = empl.department();
        Set<Employee> set = employeesDepartment.get(department);
        set.remove(empl);
        if(set.isEmpty()){
            employeesDepartment.remove(department);
        }
    }

    @Override
    /*
     *  Returns reference to Employee object with a given ID value
     *  In the case employee with the ID doesn't exist
     *  the method returns null
     */
    public Employee getEmployee(long id) {
        // Algorithm Complexity: O[1]
        return employeesMap.get(id);
    }

    @Override
    /*
     *  Returns list of Employee objects working in given Department
     *  In the case none employees in the department the method returns empty list
     */
    public List<Employee> getEmployeesByDepartment(String department) {
        // Algorithm Complexity: O[1]
        //in the case no employees in the given department the empty collection should be returned
        Set<Employee> setEmployeesDep = employeesDepartment.getOrDefault(department, new HashSet<>());

        return new ArrayList<>(setEmployeesDep);
    }

    @Override
    public List<Employee> getAllEmployees() {
        // Algorithm Complexity: O[N]
        return new ArrayList<>(employeesMap.values());
    }

    @Override
    public List<Employee> getEmployessBySalary(int salaryFrom, int salaryTo) {
        // Algorithm Complexity: O[LogN]
        Collection<Set<Employee>> col = employeesSalary.subMap(salaryFrom, salaryTo).values();
        ArrayList<Employee> res = new ArrayList<>();
        for (Set<Employee> set: col){
            res.addAll(set);
        }
        return res;
    }

    @Override
    public List<Employee> getEmployeeByAge(int ageFrom, int ageTo) {
        // Algorithm Complexity: O[LogN]
        LocalDate dateFrom = getBirthfDate(ageTo);
        LocalDate dateTo = getBirthfDate(ageFrom);
        Collection<Set<Employee>> col = employeesAge.subMap(dateFrom, dateTo).values();
        ArrayList<Employee> res = new ArrayList<>();
        for(Set<Employee> set : col)
        {
            res.addAll(set);
        }

        return res;
    }

    private LocalDate getBirthfDate(int age) {
        return LocalDate.now().minusYears(age);
    }

    @Override
    public List<DepartmentAvgSalary> salaryDistributionByDepartments() {
        // Algorithm Complexity: O[N]
//        Map<String, Double> map = employeesMap.values().stream().
//                                          collect(Collectors.groupingBy(empl -> empl.department(),
//                                                  Collectors.averagingInt(empl -> empl.salary())));
////        System.out.println(map);
//        return map.entrySet().stream().
//                map(e -> new DepartmentAvgSalary(e.getKey(), e.getValue().intValue())).
//                toList();

        Map<String, Double> map = employeesMap.values().stream()
                .collect(Collectors.groupingBy(empl -> empl.department()
                        ,Collectors.averagingInt(Employee::salary)));
        System.out.println(map);

        return map.entrySet().stream().map(e -> new DepartmentAvgSalary(e.getKey(), e.getValue()
                .intValue())).toList();
    }

    @Override
    public List<SalaryIntervalDistribution> getSalaryDistribution(int interval) {
        // Algorithm Complexity: O[N]
        //  key       number ampu bt
        Map<Integer, Long> map = employeesMap.values().
                                 stream().
                                 collect(Collectors.groupingBy(e->e.salary() / interval, Collectors.counting()));
//        System.out.println(map);
        return map.entrySet().stream().sorted((e1, e2) -> Integer.compare(e1.getKey(), e2.getKey())).
                map(e->new SalaryIntervalDistribution(e.getKey() * interval, e.getKey() * interval + interval, e.getValue())).toList();
//        return map.entrySet().stream()
//                .sorted((e1,e2) -> Integer.compare(e1.getKey(), e2.getKey()))
//                .map(e -> new SalaryIntervalDistribution(
//                        e.getKey() * interval,
//                        e.getKey() * interval + interval
//                        ,e.getValue())).toList();
    }

    @Override
    public Employee updateDepartment(long id, String newDepartment) {
        // Algorithm Complexity: O[1]
        Employee empl = fireEmployee(id);
        Employee newEmployee =
                new Employee(id, empl.name(), empl.salary(), newDepartment, empl.birthDate());

        return hireEmployee(newEmployee);
    }

    @Override
    public Employee updateSalary(long id, int newSalary) {
        // Algorithm Complexity: O[LogN]
        Employee empl = fireEmployee(id);
        Employee newEmployee =
                new Employee(id, empl.name(), newSalary, empl.department(), empl.birthDate());

        return hireEmployee(newEmployee);
    }

    @Override
    public void save(String filePath) {
        // Algorithm Complexity: O[N]
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath))){
            output.writeObject(getAllEmployees());
        }catch(Exception e){
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }

    }

    @Override
    public void restore(String filePath) {
        // Algorithm Complexity: O[N]
        List<Employee> employees = null;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))){
            employees = (List<Employee>) input.readObject();
            employees.forEach(this::hireEmployee);
        }catch (FileNotFoundException e){
            System.out.println("File with data does not exist");
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
