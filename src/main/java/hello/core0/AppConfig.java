package hello.core0;
import hello.core0.discount.DiscountPolicy;
import hello.core0.discount.FixDiscountPolicy;
import hello.core0.member.MemberRepository;
import hello.core0.member.MemberService;
import hello.core0.member.MemberServiceImpl;
import hello.core0.member.MemoryMemberRepository;
import hello.core0.order.OrderService;
import hello.core0.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {

        return new FixDiscountPolicy();
    }
}