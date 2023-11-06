package tlalim.company.dto;

import java.io.Serializable;
import java.util.Objects;

public record DepartmentAvgSalary(String department, int salary)
        implements Serializable {

}
