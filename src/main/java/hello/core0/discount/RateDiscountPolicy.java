package hello.core0.discount;

import hello.core0.member.Grade;
import hello.core0.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent =10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price * discountPercent/100;
        }else{
            return 0;
        }
    }
}