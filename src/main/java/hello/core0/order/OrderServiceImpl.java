package hello.core0.order;

import hello.core0.discount.DiscountPolicy;
import hello.core0.discount.FixDiscountPolicy;
import hello.core0.member.Member;
import hello.core0.member.MemberRepository;
import hello.core0.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);
    }


}
