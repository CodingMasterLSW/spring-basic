package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    }
    static class TestConfig{

        /**
         * setBean1은 메서드 자체가 실행이 안 됌
         * : required = false 이면 오류는 나지 않지만,
         * Member가 스프링 빈이 아니기 때문에 메서드 호출 자체를 하지 않음
         *
         * setNoBean2의 경우 null 값이 출력된다.
         * setNoBean3의 경우 Optional.empty 값이 출력된다
         */
        @Autowired(required = false)
        // Component 등록 안 된 아무 클래스 가져옴 (여기서는 Member)
        public void setNoBean1(Member member){
            System.out.println("setNoBean1 = " + member);
        }
        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("setNoBean2 = " + member);
        }
        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("setNoBean3 = " + member);
        }
    }

}
