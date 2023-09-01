package com.example.agebloomersbackend;

import com.example.agebloomersbackend.global.config.JasyptConfig;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = JasyptConfig.class)
public class JasyptTest {
    final BeanFactory beanFactory = new AnnotationConfigApplicationContext(JasyptConfig.class);
    final StringEncryptor stringEncryptor = beanFactory.getBean("jasyptStringEncryptor", StringEncryptor.class);

    @Test
    @DisplayName("암복호화 테스트")
    void encryptorTest() {
        String keyword = "plain text";
        String enc = stringEncryptor.encrypt(keyword);
        String des = stringEncryptor.decrypt(enc);
        assertThat(keyword).isEqualTo(des);

        // 틀릴 경우 에러
//        Assertions.assertThat(keyword).isEqualTo(enc); // 에러
//        Assertions.assertThat(enc).isEqualTo(des); // 에러
    }
}