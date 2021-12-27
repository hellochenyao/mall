package com.pro.member.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author chenyao
 * date 2021-03-18
 */
@Data
public class MemberRegistVo {
    private String userName;

    private String passWord;

    private String phone;
}
