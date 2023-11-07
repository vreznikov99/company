package tlalim.company.test;

import tlalim.company.dto.DepartmentAvgSalary;
import tlalim.company.dto.Employee;
import tlalim.company.service.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceImplTest {
    private static final long ID1 = 123;
    private static final long ID2 = 124;
    private static final long ID3 = 125;
    private static final long ID4 = 126;
    private static final long ID5 = 127;
    private static final long ID6 = 1000;
    private static final int SALARY1 = 5000;
    private static final int SALARY2 = 6000;
    private static final int SALARY3 = 7000;
    private static final int SALARY4 = 8000;
    private static final int SALARY5 = 9000;
    private static final String DEPARTMENT1 = "QA";
    private static final String DEPARTMENT2 = "Development";
    private static final String DEPARTMENT3 = "Management";
    private static final String DEPARTMENT6 = "Audit";
    private static final LocalDate DATE1 = LocalDate.of(1970, 10,23);
    private static final LocalDate DATE2 = LocalDate.of(1975, 1,1);
    private static final LocalDate DATE3 = LocalDate.of(1980, 5,3);
    private static final LocalDate DATE4 = LocalDate.of(1990, 5,3);
    private static final LocalDate DATE5 = LocalDate.of(2000, 5,3);

    Employee empl1 = new Employee(ID1, "name1", SALARY1, DEPARTMENT1, DATE1);
    Employee empl2 = new Employee(ID2, "name2", SALARY2, DEPARTMENT1, DATE2);
    Employee empl3 = new Employee(ID3, "name3", SALARY3, DEPARTMENT2, DATE3);
    Employee empl4 = new Employee(ID4, "name4", SALARY4, DEPARTMENT2, DATE4);
    Employee empl5 = new Employee(ID5, "name5", SALARY5, DEPARTMENT3, DATE5);
    Employee[] employees = {empl1, empl2, empl3, empl4, empl5};

    CompanyService company = null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception{
        company = new CompanyServiceImpl();
        for(Employee empl: employees)
            company.hireEmployee(empl);
    }
    @org.junit.jupiter.api.Test
    void testHireEmployeeNormal(){
        Employee newEmployee = new Employee(ID6, "name6", SALARY1, DEPARTMENT1, DATE1);
        assertEquals(newEmployee, company.hireEmployee(newEmployee));
    }
    @org.junit.jupiter.api.Test
    void testHireEmployeeException(){
        Employee newEmployee = empl1;
        //FIXME
        boolean flException = false;
        try{
            company.hireEmployee(newEmployee);
        } catch (IllegalStateException e){
            flException = true;
        }
        assertTrue(flException);
    }
    @org.junit.jupiter.api.Test
    void testFireEmployeeNormal(){
        assertEquals(empl1, company.fireEmployee(ID1));
        assertEquals(empl1, company.hireEmployee(empl1));
    }
    @org.junit.jupiter.api.Test
    void testFireEmployeeException() {
        boolean flException = false;
        try{
            company.fireEmployee(ID6);
        } catch (IllegalStateException e) {
            flException = true;
        }
        assertTrue(flException);
    }
    @org.junit.jupiter.api.Test
    void testGetEmployee() {
        assertEquals(empl1, company.getEmployee(ID1));
        assertNull(company.getEmployee(ID6));
    }

    @org.junit.jupiter.api.Test
    void testGetEmployeesByDepartment() {
        Employee[] expectedDep1 = {empl1, empl2};
        Employee[] expectedDep2 = {empl3, empl4};

        List<Employee> list1 = company.getEmployeesByDepartment(DEPARTMENT1);
        List<Employee> list2 = company.getEmployeesByDepartment(DEPARTMENT2);

        Employee[] actualDep1 = list1.toArray(new Employee[] {});
        Employee[] actualDep2 = list2.toArray(new Employee[] {});

        Arrays.sort(actualDep1);
        Arrays.sort(actualDep2);

        assertTrue(company.getEmployeesByDepartment(DEPARTMENT6).isEmpty());
        assertArrayEquals(expectedDep1, actualDep1);
        assertArrayEquals(expectedDep2, actualDep2);
    }
    private int getAge(LocalDate birthDate)
    {
        int result = (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        return result;

    }

    @org.junit.jupiter.api.Test
    void testGetEmployeeByAge() {
        List<Employee> listAll = company.getEmployeeByAge(0, 100);
        Employee[] actualAll = listAll.toArray(new Employee[] {});
        Arrays.sort(actualAll);
        assertArrayEquals(employees, actualAll);
        List<Employee> listEmpty = company.getEmployeeByAge(90,100);
        assertTrue(listEmpty.isEmpty());
        List<Employee> list2_3 = company.getEmployeeByAge(getAge(DATE3), getAge(DATE1)); // DATE1 is not taken
        Employee[] actual2_3 = list2_3.toArray(new Employee[] {});
        Employee[] expected2_3 = {empl2, empl3};
        Arrays.sort(actual2_3);
        assertArrayEquals(expected2_3, actual2_3);
//        assert (actual2_3 == expected2_3);
    }

    @org.junit.jupiter.api.Test
    void testSalaryDistributionByDepartments() {
        DepartmentAvgSalary[] expectedDistribution = {
                new DepartmentAvgSalary(DEPARTMENT1, (SALARY1 + SALARY2) / 2),
                new DepartmentAvgSalary(DEPARTMENT2, (SALARY3 + SALARY4) / 2),
                new DepartmentAvgSalary(DEPARTMENT2, SALARY5)
        };
        List<DepartmentAvgSalary> listDistribution = company.salaryDistributionByDepartments();
        DepartmentAvgSalary[] actualDistribution = listDistribution.toArray(new DepartmentAvgSalary[] {});
        Arrays.sort(actualDistribution);
        assertArrayEquals(expectedDistribution, actualDistribution);
     }



    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void hireEmployee() {
    }

    @org.junit.jupiter.api.Test
    void fireEmployee() {
    }

    @org.junit.jupiter.api.Test
    void getEmployee() {
    }

    @org.junit.jupiter.api.Test
    void getEmployeesByDepartment() {
    }

    @org.junit.jupiter.api.Test
    void getAllEmployees() {
        // HW
    }

    @org.junit.jupiter.api.Test
    void getGetEmployessBySalary() {
        // HW
    }

    @org.junit.jupiter.api.Test
    void getEmployeeByAge() {
    }

    @org.junit.jupiter.api.Test
    void salaryDistributionByDepartments() {
    }

    @org.junit.jupiter.api.Test
    void getSalaryDistribution() {
    }

    @org.junit.jupiter.api.Test
    void updateDepartment() {
    }

    @org.junit.jupiter.api.Test
    void updateSalary() {
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void restore() {
    }
}