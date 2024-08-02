package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 *
 * @author gewuyou
 * @since 2024-08-26 09:31:40
 */
public class ImportanceOfEmployees {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
       Map<Integer, Employee> map = new HashMap<>();
       for (Employee employee : employees) {
           map.put(employee.id, employee);
       }
       return getImportance(map, id);
    }
    public int getImportance(Map<Integer,Employee> employees, int id) {
        int importance = 0;
        Employee employee = employees.get(id);
        if (employee != null) {
            importance += employee.importance;
            for (int subordinate : employee.subordinates) {
                importance += getImportance(employees, subordinate);
            }
        }
        return importance;
    }
}
