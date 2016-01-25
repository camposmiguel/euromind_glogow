package net.openwebinars.liststring;

/**
 * Created by miguelcampos on 22/1/16.
 */
public class Student {
    String sex;
    String name;
    int age;

    public Student(String sex, String name, int age) {
        this.sex = sex;
        this.name = name;
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
