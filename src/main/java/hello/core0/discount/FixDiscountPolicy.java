package hello.core0.discount;

import hello.core0.member.Grade;
import hello.core0.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    //천원 할인
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // VIP이면
        if(member.getGrade()==Grade.VIP){
            return discountFixAmount;
        }
        // basic이면
        else {
            return 0;
        }
    }
}
