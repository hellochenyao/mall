package com.pro.member.dao;

import com.pro.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author chenyao
 * @email 842266201@qq.com
 * @date 2021-01-07 10:39:01
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
