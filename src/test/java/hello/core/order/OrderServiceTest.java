package hello.core.order;

import static org.assertj.core.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() throws Exception{
        //given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        //when
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        //then
        assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }

}
