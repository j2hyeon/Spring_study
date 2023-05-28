package hello.core0.member;

// 회원서비스 (회원가입, 회원조회)
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
