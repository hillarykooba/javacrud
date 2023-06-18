package org.lidaafrica.request.laf.ommon;

import org.junit.jupiter.api.Test;
import org.lidaafrica.request.laf.common.EmailValidator;

import static org.assertj.core.api.Assertions.assertThat;

class EmailValidatorTest {

    private final EmailValidator underTest = new EmailValidator();

    @Test
    public void itShouldValidateCorrectEmail(){
        assertThat(underTest.test("hello@gmail.com")).isTrue();
    }

    @Test
    public void itShouldValidateIncorrectEmail(){
        assertThat(underTest.test("hellogmail.com")).isFalse();
    }


}