package hello.core0.beanfind;

import hello.core0.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac. getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { // iter, tab키
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name= "+beanDefinitionName + " object "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기 ")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac. getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { // iter, tab키
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);


            // Role ROLE_APPLICATION : 직접등록한 어플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){ // bean이 내가 설정한 bean이라면
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name= "+beanDefinitionName + "  object = "+bean);

            }
        }
    }
}
