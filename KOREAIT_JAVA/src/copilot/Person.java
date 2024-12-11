package copilot;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void introduce() {
        System.out.println("안녕하세요, 제 이름은 " + name + "이고, 나이는 " + age + "살 입니다.");
    }

    public static void main(String[] args) {
        // Person 객체 생성 및 메서드 호출
        Person person = new Person("홍길동", 25);
        person.introduce();
    }
}
