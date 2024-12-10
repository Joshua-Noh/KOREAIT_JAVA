// EqualsExample.java
package Object;

public class EqualsExample {
    private int id;
    private String name;

    public EqualsExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // equals() 메서드 재정의
    @Override
    public boolean equals(Object obj) {
        // 자기 자신인지 확인
        if (this == obj)
            return true;
        // 객체가 null인지 확인
        if (obj == null)
            return false;
        // 클래스 타입 비교
        if (getClass() != obj.getClass())
            return false;
        // 타입 캐스팅
        EqualsExample other = (EqualsExample) obj;
        // 필드 비교
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    // toString() 메서드 재정의
    @Override
    public String toString() {
        return "EqualsExample [id=" + id + ", name=" + name + "]";
    }

    // main 메서드
    public static void main(String[] args) {
        EqualsExample obj1 = new EqualsExample(1, "홍길동");
        EqualsExample obj2 = new EqualsExample(1, "홍길동");
        EqualsExample obj3 = new EqualsExample(2, "이순신");

        System.out.println("obj1: " + obj1);
        System.out.println("obj2: " + obj2);
        System.out.println("obj3: " + obj3);

        System.out.println("obj1.equals(obj2): " + obj1.equals(obj2)); // true
        System.out.println("obj1.equals(obj3): " + obj1.equals(obj3)); // false
    }
}
