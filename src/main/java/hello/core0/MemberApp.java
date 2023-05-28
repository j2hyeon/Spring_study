package hello.core0;

import hello.core0.member.Grade;
import hello.core0.member.Member;
import hello.core0.member.MemberService;
import hello.core0.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl(); // 회원서비스 객체  memberService 생성
        //회원추가
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}