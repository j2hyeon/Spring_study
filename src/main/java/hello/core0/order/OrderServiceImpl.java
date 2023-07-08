package hello.core0.order;

import hello.core0.discount.DiscountPolicy;
import hello.core0.member.Member;
import hello.core0.member.MemberRepository;
import hello.core0.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final  DiscountPolicy discountPolicy; //철저히 interface에 의존 => DIP o

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){ // 생성자
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);
    }


}
