package hello.core.order;

import static org.assertj.core.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

/**
 * 생성자 주입을 사용해 간단하게 자바 단위테스트 작성 가능
 */
public class OrderServiceImplTest {

    @Test
    void createOrder(){

        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order orderA = orderService.createOrder(1L, "memberA", 10000);

        assertThat(orderA.getDiscountPrice()).isEqualTo(1000);
    }

}
