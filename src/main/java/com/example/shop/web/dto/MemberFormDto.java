package com.example.shop.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@Getter
public class MemberFormDto {
    @NotBlank(message = "필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력값 입니다.")
    @Email(message="이메일 형식으로 입력해 주시길 바랍니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값 입니다.")
    @Length(min = 4, max = 15, message = "비밀번호는 4자 이상, 15자 이하로 입력해주시길 바랍니다.")
    private String password;

    @NotEmpty(message ="주소는 필수 입력 값입니다.")
    private String address;

    @Builder
    public MemberFormDto(String name, String email, String pw, String address){
        this.name = name;
        this.email = email;
        this.password=pw;
        this.address=address;
    }
}
