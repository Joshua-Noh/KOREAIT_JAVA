package Object;
public class CloneExample implements Cloneable {
    private int id;
    private String name;

    public CloneExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // clone() 메서드 재정의
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // toString() 메서드 재정의
    @Override
    public String toString() {
        return "CloneExample [id=" + id + ", name=" + name + "]";
    }

    // main 메서드
    public static void main(String[] args) {
        try {
            CloneExample original = new CloneExample(1, "홍길동");
            CloneExample cloned = (CloneExample) original.clone();

            System.out.println("원본 객체: " + original);
            System.out.println("복제된 객체: " + cloned);

            // 복제된 객체의 필드 변경
            cloned.id = 2;
            cloned.name = "이순신";

            System.out.println("변경 후 원본 객체: " + original);
            System.out.println("변경 후 복제된 객체: " + cloned);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}