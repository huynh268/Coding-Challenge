package DFSandBFS;

import java.util.*;

/**
 * Created by Tien on 12/29/2017.
 *
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

 For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively.
 Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []].
 Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

 Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

 Example 1:
 Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 Output: 11
 Explanation:
 Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3.
 So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 */
public class EmployeeImportance690 {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    /**
     * DFS using Recursion
     * @param employees
     * @param id
     * @return
     */
    public int getImportance1(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hm = new HashMap<>();
        for(Employee employee : employees) {
            hm.put(employee.id, employee);
        }
        return recursion(hm, id);
    }

    /**
     * DFS Recursion function
     * @param hm - hashmap stores employee's id and subordinates
     * @param id - employee's id
     * @return
     */
    private int recursion(HashMap<Integer, Employee> hm, int id) {
        Employee employee = hm.get(id);
        int sum = employee.importance;

        if(employee.subordinates != null){
            for(int i = 0; i < employee.subordinates.size(); i++) {
                sum += recursion(hm, employee.subordinates.get(i));
            }
        }

        return sum;
    }

    /**************************************************************************************/

    /**
     * DFS using Stack
     * @param employees
     * @param id
     * @return
     */
    public int getImportance2(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hm = new HashMap<>();
        for(Employee employee : employees) {
            hm.put(employee.id, employee);
        }
        return dfs(hm, id);
    }

    private int dfs(HashMap<Integer, Employee> hm, int id) {
        Stack<Employee> stack = new Stack<>();
        stack.push(hm.get(id));
        int sum = 0;

        while(!stack.isEmpty()) {
            Employee employee = stack.pop();
            sum += employee.importance;
            for(int i = 0; i < employee.subordinates.size(); i++)
                stack.push(hm.get(employee.subordinates.get(i)));
        }

        return sum;
    }

    /**************************************************************************************/

    /**
     * BFS using Queue
     * @param employees
     * @param id
     * @return
     */
    public int getImportance3(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hm = new HashMap<>();
        for(Employee employee : employees) {
            hm.put(employee.id, employee);
        }
        return bfs(hm, id);
    }

    private int bfs(HashMap<Integer, Employee> hm, int id) {
        Queue<Employee> queue = new LinkedList<>();
        queue.add(hm.get(id));
        int sum = 0;

        while(!queue.isEmpty()) {
            Employee employee = queue.remove();
            sum += employee.importance;
            for(int i = 0; i < employee.subordinates.size(); i++) {
                queue.add(hm.get(employee.subordinates.get(i)));
            }
        }

        return sum;
    }
}
