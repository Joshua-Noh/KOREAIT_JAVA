package scheduler;

public interface Scheduler {
	public void getNextCall();
	public void sendCallToAgent();
}


//Perfect! You're defining an interface in Java named `Scheduler` with two methods: `getNextCall` and `sendCallToAgent`. 
//
//Here’s a breakdown:
//```java
//package scheduler;
//
//// 인터페이스 선언
//public interface Scheduler {
//    // 다음 호출을 가져오는 메소드
//    public void getNextCall();
//
//    // 호출을 에이전트에게 보내는 메소드
//    public void sendCallToAgent();
//}
//```
//
//### 설명:
//- **`package scheduler;`**: 이 인터페이스가 속한 패키지를 정의합니다.
//- **`public interface Scheduler`**: `Scheduler`라는 이름의 인터페이스를 정의합니다.
//- **`getNextCall()`**: 다음 호출을 가져오는 메소드를 선언합니다.
//- **`sendCallToAgent()`**: 호출을 에이전트에게 보내는 메소드를 선언합니다.
//
//이 인터페이스를 구현하려면, 클래스를 만들어서 두 메소드를 모두 구현해야 합니다.
//
//### 구현 예시:
//```java
//package scheduler;
//
//// Scheduler 인터페이스를 구현하는 클래스
//public class CallScheduler implements Scheduler {
//    @Override
//    public void getNextCall() {
//        System.out.println("Getting the next call...");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        System.out.println("Sending call to agent...");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scheduler scheduler = new CallScheduler();
//        scheduler.getNextCall(); // "Getting the next call..." 출력
//        scheduler.sendCallToAgent(); // "Sending call to agent..." 출력
//    }
//}
//```
//
//### 다형성과 인터페이스를 활용한 예시:
//여기서 `Scheduler` 인터페이스를 통해 다형성을 구현할 수 있습니다. 실제 사용 시에는 `Scheduler` 타입의 변수를 사용하여 다양한 구현체를 할당할 수 있습니다.
//
//```java
//public class PriorityScheduler implements Scheduler {
//    @Override
//    public void getNextCall() {
//        System.out.println("Getting the next high-priority call...");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        System.out.println("Sending high-priority call to agent...");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scheduler scheduler;
//
//        // 일반 콜 스케줄러
//        scheduler = new CallScheduler();
//        scheduler.getNextCall(); // "Getting the next call..." 출력
//        scheduler.sendCallToAgent(); // "Sending call to agent..." 출력
//
//        // 우선 콜 스케줄러
//        scheduler = new PriorityScheduler();
//        scheduler.getNextCall(); // "Getting the next high-priority call..." 출력
//        scheduler.sendCallToAgent(); // "Sending high-priority call to agent..." 출력
//    }
//}
//```
//
//이 예시에서 볼 수 있듯이, `Scheduler` 인터페이스는 다양한 구현체에 대해 일관된 방식으로 메소드를 호출할 수 있게 해줍니다. 이렇게 하면 코드의 유연성과 확장성이 크게 증가합니다.
//
//이해가 되셨나요? 더 궁금한 점이나 추가로 알고 싶은 내용이 있으면 언제든지 말씀해 주세요!