package com.sjs.mental.common;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Mapper
 */
public interface BaseCommonMapper<T> extends Mapper<T>,MySqlMapper<T>,IdsMapper<T>,ConditionMapper<T>{

}
