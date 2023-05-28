package hello.core0.member;

import java.util.HashMap;
import java.util.Map;

// memberrespoitory의 interface를 구현받은 구현체
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }


    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
