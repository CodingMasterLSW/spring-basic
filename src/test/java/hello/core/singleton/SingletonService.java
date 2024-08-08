package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열여서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 한다
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언해 외부 접근 막음
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글통 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        assertThat(instance1).isEqualTo(instance2);

        instance1.logic();
    }

}
