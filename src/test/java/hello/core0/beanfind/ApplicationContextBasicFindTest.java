package hello.core0.beanfind;

import hello.core0.AppConfig;
import hello.core0.member.MemberService;
import hello.core0.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig .class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        Object memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = "+ memberService);
        System.out.println("memberService.getClass()  = " + memberService.getClass());

        //test
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        Object memberService = ac.getBean(MemberService.class);
        //test
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        //test
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 실패 케이스
    // ac에서 "xxxx"라는 이름의 빈을 가져오는 시도가
    // NoSuchBeanDefinitionException을 throw하는지 확인하는 JUnit 테스트 코드
    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX(){
         //MemberService xxxx = ac.getBean("xxxx",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxx", MemberService.class));
    }


}
