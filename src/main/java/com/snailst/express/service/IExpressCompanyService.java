package com.snailst.express.service;

import com.snailst.express.entity.ExpressCompany;
import com.baomidou.mybatisplus.service.IService;
import com.snailst.express.entity.QueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-31
 */
public interface IExpressCompanyService extends IService<ExpressCompany> {

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

    /**
     * 保存快递公司
     * @param company
     */
    void saveExpressCompany(ExpressCompany company);
}
