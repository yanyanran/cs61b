package hashcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Set 集合的“异常”
 * */
public class EqualsExample {
    public static void main(String[] args) {
        // 对象 1
        Persion p1 = new Persion();
        p1.setName("Java");
        p1.setAge(18);
        // 对象 2
        Persion p2 = new Persion();
        p2.setName("Java");
        p2.setAge(18);
        // 创建 Set 集合
        Set<Persion> set = new HashSet<Persion>();
        set.add(p1);
        set.add(p2);
        // 打印 Set 中的所有数据
        set.forEach(p -> {
            System.out.println(p);
        });
    }
}
class Persion {
    private String name;
    private int age;
    /** 只重写了 equals 方法 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 引用相等返回 true
        // 如果等于 null，或者对象类型不同返回 false
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // 强转为自定义 Persion 类型
        Persion persion = (Persion) o;
        // 如果 age 和 name 都相等，就返回 true
        return age == persion.age && Objects.equals(name, persion.name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}