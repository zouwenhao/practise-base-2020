package cn.zou.mianshi.tanma;

import java.util.*;

/**
 * 从部门树中找到对应名字的所有id，如找出所有语文的id
 */
public class PrintDepartment {

    public static void main(String[] args) {
        PrintDepartment printDepartment = new PrintDepartment();
        Department d1 = new Department(1L, "小学");
        Department d11 = new Department(2L, "一年级");
        Department d12 = new Department(3L, "二年级");
        Department d111 = new Department(4L, "语文");
        Department d112 = new Department(5L, "数学");
        Department d122 = new Department(6L, "语文");
        d1.setChildren(Arrays.asList(d11, d12));
        d11.setChildren(Arrays.asList(d111, d112));
        d12.setChildren(Arrays.asList(d122));
        Long[] ids = printDepartment.findDeptId(d1, "语文");
        System.out.println(Arrays.toString(ids));;
    }

    public Long[] findDeptId(Department root, String name) {
        Queue<Department> queue = new ArrayDeque<>();
        queue.add(root);
        List<Long> ids = new ArrayList<>();
        while (!queue.isEmpty()) {
            Department dept = queue.poll();
            if (name.equals(dept.getName())) {
                ids.add(dept.getId());
            }
            List<Department> children = dept.getChildren();
            if (children != null && children.size() != 0) {
                children.forEach(queue::add);
            }
        }
        return ids.toArray(new Long[ids.size()]);
    }

}

class Department {
    private Long id;
    private String name;
    private List<Department> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

