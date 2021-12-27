package com.pro.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pro.common.utils.PageUtils;
import com.pro.member.entity.MemberEntity;
import com.pro.member.exception.PhoneExistException;
import com.pro.member.exception.UsernameExistException;
import com.pro.member.vo.MemberLoginVo;
import com.pro.member.vo.MemberRegistVo;
import com.pro.member.vo.SocialUser;

import java.util.Map;

/**
 * 会员
 *
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-07 10:39:01
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void regist(MemberRegistVo vo);

    void checkPhoneUnique(String phone) throws PhoneExistException;

    void checkUsernameUnique(String username) throws UsernameExistException;

    MemberEntity login(MemberLoginVo vo);

    MemberEntity login(SocialUser socialUser) throws Exception;

}

