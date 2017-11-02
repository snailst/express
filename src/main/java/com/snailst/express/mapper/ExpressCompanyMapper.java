package com.snailst.express.mapper;

import com.snailst.express.entity.ExpressCompany;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.snailst.express.entity.QueryParam;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-31
 */
public interface ExpressCompanyMapper extends BaseMapper<ExpressCompany> {

    /**
     * 获取所有的快递公司
     * @param param
     * @return
     */
    List<ExpressCompany> getExpressCompanys(QueryParam param);

    /**
     * 查询总记录数
     * @param param
     * @return
     */
    long getCount(QueryParam param);
}