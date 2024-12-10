package scheduler;

import java.io.IOException;

public class SchedulerTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("전화 상담 할당 방식을 선택하세요.");
		System.out.println("R : 한명씩 차례대로 할당 ");
		System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
		System.out.println("P : 우선순위가 높은 고객 먼저 할당");

		int ch = System.in.read();
		Scheduler scheduler = null;

		if (ch == 'R' || ch == 'r') {
			scheduler = new RoundRobin();
		} else if (ch == 'L' || ch == 'l') {
			scheduler = new LeastJob();
		} else if (ch == 'P' || ch == 'p') {
			scheduler = new PriorityAllocation();
		} else {
			System.out.println("지원되지 않는 기능입니다.");
			return;
		}

		scheduler.getNextCall();
		scheduler.sendCallToAgent();

	}
}




//코드 분석 및 개선 제안
//코드 분석
//장점:
//
//명확한 목적: 전화 상담 할당 방식을 선택하여 스케줄링 알고리즘을 구현하는 것을 목표로 합니다.
//간단한 인터페이스: Scheduler 인터페이스를 통해 다양한 할당 방식을 구현할 수 있도록 유연성을 제공합니다.
//사용자 입력: 사용자로부터 할당 방식을 입력받아 적절한 스케줄러를 선택합니다.
//단점 및 개선점:
//
//인터페이스 미정의: Scheduler 인터페이스가 구체적으로 정의되어 있지 않아 확장성이 제한적입니다.
//에러 처리 부족: 사용자가 잘못된 입력을 하거나 예상치 못한 예외가 발생할 경우 적절한 처리가 되지 않습니다.
//알고리즘 구현 부족: RoundRobin, LeastJob, PriorityAllocation 클래스의 구체적인 구현이 빠져 있습니다.
//테스트 코드 부재: 코드의 정확성을 검증하기 위한 테스트 코드가 없습니다.
//유연성 부족: 새로운 할당 방식을 추가하기 위해 코드를 수정해야 합니다.
//개선된 코드
//Java
//
//package scheduler;
//
//import java.io.IOException;
//
//interface Scheduler {
//    void getNextCall();
//    void sendCallToAgent();
//}
//
//class RoundRobin implements Scheduler {
//    // 라운드 로빈 알고리즘 구현
//}
//
//class LeastJob implements Scheduler {
//    // 최소 작업량 알고리즘 구현
//}
//
//class PriorityAllocation implements Scheduler {
//    // 우선순위 할당 알고리즘 구현
//}
//
//public class SchedulerTest {
//    public static void main(String[] args) throws IOException {
//        System.out.println("전화 상담 할당 방식을 선택하세요.");
//        System.out.println("R : 한명씩 차례대로 할당 ");
//        System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
//        System.out.println("P : 우선순위가 높은 고객 먼저 할당");
//
//        int ch = System.in.read();
//        Scheduler scheduler = null;
//
//        try {
//            switch (ch) {
//                case 'R': case 'r':
//                    scheduler = new RoundRobin();
//                    break;
//                case 'L': case 'l':
//                    scheduler = new LeastJob();
//                    break;
//                case 'P': case 'p':
//                    scheduler = new PriorityAllocation();
//                    break;
//                default:
//                    throw new IllegalArgumentException("지원되지 않는 기능입니다.");
//            }
//
//            scheduler.getNextCall();
//            scheduler.sendCallToAgent();
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
//
//코드 분석 및 설명
//이 Java 프로그램은 사용자가 전화 상담 할당 방식을 선택하도록 하고, 그에 따라 적절한 할당 방식 클래스를 인스턴스화하여 호출을 처리합니다.
//
//코드를 라인별로 주석을 추가하여 설명
//java
//package scheduler;
//
//import java.io.IOException;
//
//public class SchedulerTest {
//
//    public static void main(String[] args) throws IOException {
//        // 사용자에게 할당 방식을 선택하도록 안내하는 메시지를 출력합니다.
//        System.out.println("전화 상담 할당 방식을 선택하세요.");
//        System.out.println("R : 한명씩 차례대로 할당 ");
//        System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
//        System.out.println("P : 우선순위가 높은 고객 먼저 할당");
//
//        // 사용자의 입력을 받습니다.
//        int ch = System.in.read();
//        Scheduler scheduler = null;
//
//        // 사용자 입력에 따라 적절한 스케줄러를 인스턴스화합니다.
//        if (ch == 'R' || ch == 'r') {
//            scheduler = new RoundRobin();
//        } else if (ch == 'L' || ch == 'l') {
//            scheduler = new LeastJob();
//        } else if (ch == 'P' || ch == 'p') {
//            scheduler = new PriorityAllocation();
//        } else {
//            // 유효하지 않은 입력이 들어왔을 때 메시지를 출력하고 프로그램을 종료합니다.
//            System.out.println("지원되지 않는 기능입니다.");
//            return;
//        }
//
//        // 선택된 스케줄러를 사용하여 다음 호출을 가져오고 상담원에게 전송합니다.
//        scheduler.getNextCall();
//        scheduler.sendCallToAgent();
//    }
//}
//각 클래스의 역할 설명
//Scheduler 인터페이스:
//
//메소드: getNextCall(), sendCallToAgent()
//
//모든 스케줄러 클래스가 구현해야 할 메소드들을 정의합니다.
//
//RoundRobin 클래스:
//
//역할: 각 상담원에게 순서대로 전화 상담을 할당합니다.
//
//메소드 구현:
//
//java
//public class RoundRobin implements Scheduler {
//    @Override
//    public void getNextCall() {
//        System.out.println("한명씩 차례대로 다음 상담 전화를 가져옵니다.");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        System.out.println("차례대로 상담원에게 전화를 보냅니다.");
//    }
//}
//LeastJob 클래스:
//
//역할: 현재 쉬고 있거나 대기 중인 상담원이 가장 적은 상담원에게 전화 상담을 할당합니다.
//
//메소드 구현:
//
//java
//public class LeastJob implements Scheduler {
//    @Override
//    public void getNextCall() {
//        System.out.println("쉬고 있거나 대기 중인 상담원에게 다음 상담 전화를 가져옵니다.");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        System.out.println("대기 중인 상담원에게 전화를 보냅니다.");
//    }
//}
//PriorityAllocation 클래스:
//
//역할: 우선순위가 높은 고객의 전화를 먼저 상담원에게 할당합니다.
//
//메소드 구현:
//
//java
//public class PriorityAllocation implements Scheduler {
//    @Override
//    public void getNextCall() {
//        System.out.println("우선순위가 높은 고객의 전화를 가져옵니다.");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        System.out.println("우선순위가 높은 고객의 전화를 상담원에게 보냅니다.");
//    }
//}
//요약
//이 프로그램은 사용자가 선택한 할당 방식에 따라 적절한 스케줄러 클래스의 인스턴스를 생성하여, getNextCall()과 sendCallToAgent() 메소드를 호출합니다. 인터페이스 Scheduler는 다형성을 통해 다양한 할당 방식을 구현할 수 있게 합니다.
//
//추가적으로 궁금한 점이나 알고 싶은 내용이 있다면 언제든지 질문해 주세요
//
//아래에 제공해주신 Scheduler 인터페이스와 SchedulerTest 클래스에 대해 자세히 설명드리겠습니다. 또한, RoundRobin, LeastJob, PriorityAllocation 클래스의 구현 예제도 함께 제공하여, 전체적인 흐름과 개념을 명확히 이해할 수 있도록 도와드리겠습니다.
//
//1. 전체 코드 구조 이해
//1.1. Scheduler 인터페이스
//먼저, Scheduler 인터페이스는 두 개의 메서드를 선언하고 있습니다:
//
//java
//코드 복사
//package scheduler;
//
//public interface Scheduler {
//    public void getNextCall();
//    public void sendCallToAgent();
//}
//getNextCall(): 다음 전화를 가져오는 역할을 합니다.
//sendCallToAgent(): 가져온 전화를 상담원에게 전달하는 역할을 합니다.
//이 인터페이스는 콜센터나 고객 지원 시스템에서 전화 상담을 효율적으로 할당하기 위한 다양한 전략을 정의하는 데 사용됩니다.
//
//1.2. SchedulerTest 클래스
//SchedulerTest 클래스는 사용자로부터 상담 할당 방식을 입력받아, 해당 방식을 구현하는 클래스를 인스턴스화하고 메서드를 호출하는 역할을 합니다.
//
//java
//코드 복사
//package scheduler;
//
//import java.io.IOException;
//
//public class SchedulerTest {
//
//    public static void main(String[] args) throws IOException {
//        // TODO Auto-generated method stub
//        System.out.println("전화 상담 할당 방식을 선택하세요.");
//        System.out.println("R : 한명씩 차례대로 할당 ");
//        System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
//        System.out.println("P : 우선순위가 높은 고객 먼저 할당");
//
//        int ch = System.in.read();
//        Scheduler scheduler = null;
//
//        if (ch == 'R' || ch == 'r') {
//            scheduler = new RoundRobin();
//        } else if (ch == 'L' || ch == 'l') {
//            scheduler = new LeastJob();
//        } else if (ch == 'P' || ch == 'p') {
//            scheduler = new PriorityAllocation();
//        } else {
//            System.out.println("지원되지 않는 기능입니다.");
//            return;
//        }
//
//        scheduler.getNextCall();
//        scheduler.sendCallToAgent();
//    }
//}
//주요 기능:
//
//사용자 입력 받기: 사용자에게 상담 할당 방식을 선택하도록 요청합니다.
//입력에 따른 클래스 인스턴스화: 사용자가 입력한 옵션에 따라 해당하는 클래스(RoundRobin, LeastJob, PriorityAllocation)의 인스턴스를 생성합니다.
//메서드 호출: 생성된 인스턴스의 getNextCall()과 sendCallToAgent() 메서드를 호출하여 상담을 할당합니다.
//2. Scheduler 인터페이스 구현 클래스
//이제 Scheduler 인터페이스를 구현하는 세 가지 클래스를 작성해보겠습니다: RoundRobin, LeastJob, PriorityAllocation.
//
//2.1. RoundRobin 클래스
//RoundRobin 방식은 상담원에게 차례대로 전화를 할당하는 간단한 방식입니다.
//
//java
//코드 복사
//package scheduler;
//
//public class RoundRobin implements Scheduler {
//    private int agentCount = 3; // 예시로 상담원 3명
//    private int currentAgent = 0;
//
//    @Override
//    public void getNextCall() {
//        System.out.println("RoundRobin 방식: 다음 전화를 가져옵니다.");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        currentAgent = (currentAgent + 1) % agentCount;
//        System.out.println("RoundRobin 방식: 상담원 " + (currentAgent + 1) + "에게 전화를 전달합니다.");
//    }
//}
//설명:
//
//agentCount: 상담원의 총 수를 나타냅니다.
//currentAgent: 현재 전화를 할당할 상담원의 인덱스를 추적합니다.
//getNextCall(): 다음 전화를 가져오는 로직을 구현합니다.
//sendCallToAgent(): 현재 상담원에게 전화를 할당하고, 다음 상담원으로 이동합니다.
//2.2. LeastJob 클래스
//LeastJob 방식은 현재 쉬고 있거나 대기가 가장 적은 상담원에게 전화를 할당하는 방식입니다.
//
//java
//코드 복사
//package scheduler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LeastJob implements Scheduler {
//    private Map<String, Integer> agentWorkload;
//
//    public LeastJob() {
//        agentWorkload = new HashMap<>();
//        // 예시로 상담원 1, 2, 3의 현재 작업량을 초기화
//        agentWorkload.put("상담원1", 2);
//        agentWorkload.put("상담원2", 1);
//        agentWorkload.put("상담원3", 3);
//    }
//
//    @Override
//    public void getNextCall() {
//        System.out.println("LeastJob 방식: 다음 전화를 가져옵니다.");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        String leastBusyAgent = null;
//        int leastJobs = Integer.MAX_VALUE;
//
//        for (Map.Entry<String, Integer> entry : agentWorkload.entrySet()) {
//            if (entry.getValue() < leastJobs) {
//                leastJobs = entry.getValue();
//                leastBusyAgent = entry.getKey();
//            }
//        }
//
//        if (leastBusyAgent != null) {
//            System.out.println("LeastJob 방식: " + leastBusyAgent + "에게 전화를 전달합니다.");
//            // 상담원이 전화를 받으면 작업량 증가
//            agentWorkload.put(leastBusyAgent, agentWorkload.get(leastBusyAgent) + 1);
//        } else {
//            System.out.println("LeastJob 방식: 상담원이 없습니다.");
//        }
//    }
//}
//설명:
//
//agentWorkload: 각 상담원의 현재 작업량을 저장하는 맵입니다.
//sendCallToAgent(): 현재 작업량이 가장 적은 상담원을 찾아 전화를 할당하고, 해당 상담원의 작업량을 증가시킵니다.
//2.3. PriorityAllocation 클래스
//PriorityAllocation 방식은 우선순위가 높은 고객에게 먼저 전화를 할당하는 방식입니다.
//
//java
//코드 복사
//package scheduler;
//
//import java.util.PriorityQueue;
//
//public class PriorityAllocation implements Scheduler {
//    private PriorityQueue<Customer> customerQueue;
//
//    public PriorityAllocation() {
//        customerQueue = new PriorityQueue<>();
//        // 예시로 우선순위가 높은 고객들을 초기화
//        customerQueue.add(new Customer("고객1", 2));
//        customerQueue.add(new Customer("고객2", 1));
//        customerQueue.add(new Customer("고객3", 3));
//    }
//
//    @Override
//    public void getNextCall() {
//        System.out.println("PriorityAllocation 방식: 다음 전화를 가져옵니다.");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        Customer nextCustomer = customerQueue.poll();
//        if (nextCustomer != null) {
//            System.out.println("PriorityAllocation 방식: 우선순위 " + nextCustomer.getPriority() + "의 " + nextCustomer.getName() + "에게 전화를 전달합니다.");
//        } else {
//            System.out.println("PriorityAllocation 방식: 대기 중인 고객이 없습니다.");
//        }
//    }
//}
//
//// Customer 클래스
//class Customer implements Comparable<Customer> {
//    private String name;
//    private int priority; // 우선순위 (1이 가장 높음)
//
//    public Customer(String name, int priority) {
//        this.name = name;
//        this.priority = priority;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPriority() {
//        return priority;
//    }
//
//    @Override
//    public int compareTo(Customer other) {
//        return Integer.compare(this.priority, other.priority);
//    }
//}
//설명:
//
//Customer 클래스: 고객의 이름과 우선순위를 나타냅니다. 우선순위가 낮을수록 높은 우선순위를 의미합니다.
//customerQueue: 우선순위 큐를 사용하여 우선순위가 높은 고객을 먼저 처리합니다.
//sendCallToAgent(): 우선순위가 가장 높은 고객을 찾아 상담원에게 전화를 할당합니다.
//3. 전체 예제 실행 및 결과
//이제 모든 클래스를 구현했으므로, SchedulerTest 클래스를 실행하여 전체 흐름을 확인해보겠습니다.
//
//3.1. 전체 클래스 구조
//프로젝트 구조는 다음과 같습니다:
//
//arduino
//코드 복사
//scheduler/
//│
//├── Scheduler.java
//├── SchedulerTest.java
//├── RoundRobin.java
//├── LeastJob.java
//├── PriorityAllocation.java
//└── Customer.java
//3.2. 실행 예시
//콘솔 출력:
//
//yaml
//코드 복사
//전화 상담 할당 방식을 선택하세요.
//R : 한명씩 차례대로 할당 
//L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 
//P : 우선순위가 높은 고객 먼저 할당
//사용자 입력: R (또는 r)
//
//출력:
//
//코드 복사
//RoundRobin 방식: 다음 전화를 가져옵니다.
//RoundRobin 방식: 상담원 1에게 전화를 전달합니다.
//또는 L 입력 시:
//
//코드 복사
//LeastJob 방식: 다음 전화를 가져옵니다.
//LeastJob 방식: 상담원2에게 전화를 전달합니다.
//또는 P 입력 시:
//
//코드 복사
//PriorityAllocation 방식: 다음 전화를 가져옵니다.
//PriorityAllocation 방식: 우선순위 1의 고객2에게 전화를 전달합니다.
//4. 주요 학습 포인트
//4.1. 인터페이스의 활용
//인터페이스 선언: Scheduler 인터페이스는 상담 할당 방식의 계약을 정의합니다. 이를 구현하는 클래스들은 인터페이스에서 선언한 메서드들을 반드시 구현해야 합니다.
//
//다중 구현 가능: 하나의 클래스가 여러 인터페이스를 구현할 수 있습니다. 이는 다중 상속의 대안으로 유용합니다.
//
//4.2. 다형성 (Polymorphism)
//인터페이스를 통한 다형성 구현: Scheduler 인터페이스를 통해 다양한 상담 할당 방식을 동일한 타입으로 다룰 수 있습니다.
//
//유연한 코드 작성: Scheduler scheduler = new RoundRobin();과 같이 인터페이스 타입으로 객체를 선언하면, 나중에 다른 구현체로 쉽게 변경할 수 있습니다.
//
//4.3. 클래스 설계 및 책임 분리
//단일 책임 원칙: 각 클래스는 하나의 책임만을 가지도록 설계되었습니다. 예를 들어, RoundRobin은 단순히 차례대로 할당하는 역할만을 담당합니다.
//
//확장성: 새로운 상담 할당 방식을 추가하고 싶을 때, Scheduler 인터페이스를 구현하는 새로운 클래스를 추가하면 됩니다. 기존 코드를 수정할 필요 없이 기능을 확장할 수 있습니다.
//
//4.4. 사용자 입력 처리
//입력 검증: 사용자가 올바른 옵션(R, L, P)을 입력했는지 검증하고, 그렇지 않을 경우 적절한 메시지를 출력합니다.
//
//대응하는 클래스 인스턴스화: 사용자의 입력에 따라 적절한 클래스(RoundRobin, LeastJob, PriorityAllocation)를 인스턴스화하여, 메서드를 호출합니다.
//
//5. 추가 학습 팁
//5.1. 예외 처리
//현재 SchedulerTest 클래스는 throws IOException을 사용하여 예외를 던지고 있습니다. 더 나은 사용자 경험을 위해 예외를 처리할 수 있도록 개선해보겠습니다.
//
//java
//코드 복사
//package scheduler;
//
//import java.io.IOException;
//
//public class SchedulerTest {
//
//    public static void main(String[] args) {
//        try {
//            System.out.println("전화 상담 할당 방식을 선택하세요.");
//            System.out.println("R : 한명씩 차례대로 할당 ");
//            System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
//            System.out.println("P : 우선순위가 높은 고객 먼저 할당");
//
//            int ch = System.in.read();
//            Scheduler scheduler = null;
//
//            if (ch == 'R' || ch == 'r') {
//                scheduler = new RoundRobin();
//            } else if (ch == 'L' || ch == 'l') {
//                scheduler = new LeastJob();
//            } else if (ch == 'P' || ch == 'p') {
//                scheduler = new PriorityAllocation();
//            } else {
//                System.out.println("지원되지 않는 기능입니다.");
//                return;
//            }
//
//            scheduler.getNextCall();
//            scheduler.sendCallToAgent();
//
//        } catch (IOException e) {
//            System.out.println("입력 처리 중 오류가 발생했습니다.");
//            e.printStackTrace();
//        }
//    }
//}
//설명:
//
//예외 처리: try-catch 블록을 사용하여 IOException을 처리합니다. 이는 입력 처리 중 오류가 발생했을 때, 프로그램이 비정상적으로 종료되지 않고 적절한 메시지를 출력하도록 합니다.
//5.2. 개선된 사용자 입력 처리
//현재 System.in.read()는 한 글자만 읽고, 개행 문자를 처리하지 않습니다. 여러 글자를 입력받고, 개행 문자를 제거하는 더 나은 방법을 사용할 수 있습니다. 예를 들어, Scanner 클래스를 사용하는 방법입니다.
//
//java
//코드 복사
//package scheduler;
//
//import java.util.Scanner;
//
//public class SchedulerTest {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("전화 상담 할당 방식을 선택하세요.");
//        System.out.println("R : 한명씩 차례대로 할당 ");
//        System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
//        System.out.println("P : 우선순위가 높은 고객 먼저 할당");
//
//        String input = scanner.nextLine();
//        Scheduler scheduler = null;
//
//        if (input.equalsIgnoreCase("R")) {
//            scheduler = new RoundRobin();
//        } else if (input.equalsIgnoreCase("L")) {
//            scheduler = new LeastJob();
//        } else if (input.equalsIgnoreCase("P")) {
//            scheduler = new PriorityAllocation();
//        } else {
//            System.out.println("지원되지 않는 기능입니다.");
//            scanner.close();
//            return;
//        }
//
//        scheduler.getNextCall();
//        scheduler.sendCallToAgent();
//
//        scanner.close();
//    }
//}
//설명:
//
//Scanner 사용: Scanner 클래스를 사용하여 사용자의 입력을 읽습니다. 이는 여러 글자를 입력받고, 개행 문자를 제거하는 데 유용합니다.
//
//equalsIgnoreCase 메서드: 대소문자에 관계없이 입력을 비교합니다.
//
//5.3. 상담원 관리 기능 추가
//실제 시스템에서는 상담원의 상태를 동적으로 관리할 필요가 있습니다. 예를 들어, 상담원이 통화를 마치면 작업량을 감소시키는 등의 기능을 추가할 수 있습니다. 이를 위해 Scheduler 인터페이스와 구현 클래스를 확장할 수 있습니다.
//
//예시: LeastJob 클래스에 상담원 작업량 감소 기능 추가
//
//java
//코드 복사
//package scheduler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LeastJob implements Scheduler {
//    private Map<String, Integer> agentWorkload;
//
//    public LeastJob() {
//        agentWorkload = new HashMap<>();
//        // 예시로 상담원 1, 2, 3의 현재 작업량을 초기화
//        agentWorkload.put("상담원1", 2);
//        agentWorkload.put("상담원2", 1);
//        agentWorkload.put("상담원3", 3);
//    }
//
//    @Override
//    public void getNextCall() {
//        System.out.println("LeastJob 방식: 다음 전화를 가져옵니다.");
//    }
//
//    @Override
//    public void sendCallToAgent() {
//        String leastBusyAgent = null;
//        int leastJobs = Integer.MAX_VALUE;
//
//        for (Map.Entry<String, Integer> entry : agentWorkload.entrySet()) {
//            if (entry.getValue() < leastJobs) {
//                leastJobs = entry.getValue();
//                leastBusyAgent = entry.getKey();
//            }
//        }
//
//        if (leastBusyAgent != null) {
//            System.out.println("LeastJob 방식: " + leastBusyAgent + "에게 전화를 전달합니다.");
//            // 상담원이 전화를 받으면 작업량 증가
//            agentWorkload.put(leastBusyAgent, agentWorkload.get(leastBusyAgent) + 1);
//        } else {
//            System.out.println("LeastJob 방식: 상담원이 없습니다.");
//        }
//    }
//
//    // 상담원이 통화를 마친 후 작업량을 감소시키는 메서드
//    public void endCall(String agentName) {
//        if (agentWorkload.containsKey(agentName) && agentWorkload.get(agentName) > 0) {
//            agentWorkload.put(agentName, agentWorkload.get(agentName) - 1);
//            System.out.println(agentName + "의 작업량을 감소시켰습니다.");
//        } else {
//            System.out.println(agentName + "의 작업량이 이미 0입니다.");
//        }
//    }
//
//    // 상담원의 현재 작업량을 확인하는 메서드
//    public void showWorkload() {
//        System.out.println("현재 상담원 작업량:");
//        for (Map.Entry<String, Integer> entry : agentWorkload.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//    }
//}
//설명:
//
//endCall(String agentName): 상담원이 통화를 마친 후 작업량을 감소시킵니다.
//
//showWorkload(): 현재 각 상담원의 작업량을 출력합니다.
//
//SchedulerTest 클래스에서의 활용 예시:
//
//java
//코드 복사
//package scheduler;
//
//import java.util.Scanner;
//
//public class SchedulerTest {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("전화 상담 할당 방식을 선택하세요.");
//        System.out.println("R : 한명씩 차례대로 할당 ");
//        System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
//        System.out.println("P : 우선순위가 높은 고객 먼저 할당");
//
//        String input = scanner.nextLine();
//        Scheduler scheduler = null;
//
//        if (input.equalsIgnoreCase("R")) {
//            scheduler = new RoundRobin();
//        } else if (input.equalsIgnoreCase("L")) {
//            scheduler = new LeastJob();
//        } else if (input.equalsIgnoreCase("P")) {
//            scheduler = new PriorityAllocation();
//        } else {
//            System.out.println("지원되지 않는 기능입니다.");
//            scanner.close();
//            return;
//        }
//
//        scheduler.getNextCall();
//        scheduler.sendCallToAgent();
//
//        // 추가 기능: 상담원이 통화를 마쳤다고 가정하고 작업량 감소
//        if (scheduler instanceof LeastJob) {
//            LeastJob leastJobScheduler = (LeastJob) scheduler;
//            System.out.println("상담원이 통화를 마쳤습니다.");
//            leastJobScheduler.endCall("상담원2"); // 예시로 상담원2의 작업량을 감소시킵니다.
//            leastJobScheduler.showWorkload();
//        }
//
//        scanner.close();
//    }
//}
//설명:
//
//instanceof 연산자: scheduler 객체가 LeastJob 클래스의 인스턴스인지 확인합니다.
//
//endCall 및 showWorkload 메서드 호출: 상담원이 통화를 마쳤다고 가정하고, 특정 상담원의 작업량을 감소시키고, 현재 작업량을 출력합니다.
//
//6. 객체 지향 프로그래밍(OOP) 개념과의 연관성
//6.1. 인터페이스와 추상화
//인터페이스는 클래스들이 특정 메서드를 구현하도록 강제하여, 일관된 방식으로 동작하도록 만듭니다. 이는 추상화의 한 형태로, 구체적인 구현을 숨기고 무엇을 해야 하는지를 정의합니다.
//6.2. 다형성 (Polymorphism)
//다형성은 하나의 인터페이스 타입으로 여러 구현체를 다룰 수 있는 능력을 말합니다. Scheduler scheduler = new RoundRobin();, Scheduler scheduler = new LeastJob();와 같이 다양한 객체를 동일한 타입으로 처리할 수 있습니다.
//
//이를 통해 코드는 더 유연해지고, 새로운 기능을 추가할 때 기존 코드를 수정하지 않고도 확장할 수 있습니다.
//
//6.3. 캡슐화 (Encapsulation)
//각 클래스는 자신의 데이터를 보호하고, 외부에서 직접 접근하지 못하도록 메서드를 통해서만 조작할 수 있도록 합니다. 예를 들어, LeastJob 클래스의 agentWorkload는 외부에서 직접 수정할 수 없고, endCall()과 같은 메서드를 통해서만 조작할 수 있습니다.
//6.4. 상속 (Inheritance)
//이번 예제에서는 인터페이스를 사용했지만, 상속을 통해서도 다형성을 구현할 수 있습니다. 예를 들어, Scheduler 인터페이스 대신 추상 클래스를 사용하여 공통된 기능을 제공할 수도 있습니다.
//7. 결론
//제공해주신 Scheduler 인터페이스와 SchedulerTest 클래스는 자바의 객체 지향 프로그래밍 개념을 잘 보여주는 예제입니다. 인터페이스를 통해 다양한 상담 할당 방식을 정의하고, 다형성을 활용하여 유연하게 객체를 다루는 방법을 학습할 수 있습니다.
//
//학습 포인트 요약:
//
//인터페이스를 사용하여 공통된 메서드 시그니처를 정의하고, 이를 구현하는 여러 클래스를 작성할 수 있습니다.
//다형성을 통해 동일한 인터페이스 타입으로 다양한 구현체를 다룰 수 있어, 코드의 유연성과 확장성이 높아집니다.
//상속과 인터페이스는 객체 지향 프로그래밍에서 중요한 개념으로, 올바르게 활용하면 유지보수성과 재사용성을 높일 수 있습니다.
//예외 처리와 입력 검증을 통해 사용자 입력에 따른 프로그램의 안정성을 향상시킬 수 있습니다.
//클래스 설계 시 단일 책임 원칙을 따르고, 각 클래스가 하나의 책임만을 가지도록 설계하는 것이 중요합니다.
//이 예제를 바탕으로 다양한 객체 지향 프로그래밍 개념을 실습해보며, 실제 프로젝트에서 이를 효과적으로 적용할 수 있도록 연습해보시기 바랍니다. 추가적인 질문이나 도움이 필요하시면 언제든지 문의해주세요!