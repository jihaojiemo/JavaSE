class Person {}
class Student {}
public class JieShouDuiXiang {
    public static void main(String[] args) {
        fun(new Person());
        fun(new Student());
    }
    public static void fun(Object obj) {
        System.out.println(obj);
    }
}