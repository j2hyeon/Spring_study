package hello.core0.discount;

import hello.core0.member.Member;

public interface DiscountPolicy {

    // 할인해야하는 금액을 반환
    int discount(Member member, int price);



}
