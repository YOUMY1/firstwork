import java.util.Comparator;

public class Animal implements Comparable<Animal>{
    private String  variety;
    private String sex;
    private int age;
    private int id;

    public Animal(String variety, String sex, int age, int id) {
        this.variety = variety;
        this.sex = sex;
        this.age = age;
        this.id = id;
    }

    public Animal() {
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Animal o) {
        return this.age-o.getAge();
    }
}