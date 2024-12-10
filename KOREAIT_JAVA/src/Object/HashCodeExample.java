// HashCodeExample.java
package Object;

import java.util.HashSet;

public class HashCodeExample {
    private int id;
    private String name;

    public HashCodeExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // hashCode() 메서드 재정의
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    // equals() 메서드 재정의
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HashCodeExample other = (HashCodeExample) obj;
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
        return "HashCodeExample [id=" + id + ", name=" + name + "]";
    }

    // main 메서드
    public static void main(String[] args) {
        HashCodeExample obj1 = new HashCodeExample(1, "홍길동");
        HashCodeExample obj2 = new HashCodeExample(1, "홍길동");
        HashCodeExample obj3 = new HashCodeExample(2, "이순신");

        HashSet<HashCodeExample> set = new HashSet<>();
        set.add(obj1);
        set.add(obj2);
        set.add(obj3);

        System.out.println("HashSet에 저장된 객체들:");
        for (HashCodeExample obj : set) {
            System.out.println(obj);
        }

        // 해시코드 확인
        System.out.println("obj1.hashCode(): " + obj1.hashCode());
        System.out.println("obj2.hashCode(): " + obj2.hashCode());
        System.out.println("obj3.hashCode(): " + obj3.hashCode());
    }
}
