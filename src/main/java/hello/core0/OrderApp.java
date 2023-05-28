package hello.core0;

import hello.core0.member.Grade;
import hello.core0.member.Member;
import hello.core0.member.MemberService;
import hello.core0.member.MemberServiceImpl;
import hello.core0.order.Order;
import hello.core0.order.OrderService;
import hello.core0.order.OrderServiceImpl;



public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);

        System.out.println("order ="+ order); // 이전의 toString반환
        System.out.println("order.calculatePrice = "+ order.calculatePrice());

    }
}
