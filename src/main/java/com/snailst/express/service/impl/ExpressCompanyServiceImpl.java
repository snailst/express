package com.snailst.express.service.impl;

import com.snailst.express.entity.ExpressCompany;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.mapper.ExpressCompanyMapper;
import com.snailst.express.service.IExpressCompanyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-31
 */
@Service
public class ExpressCompanyServiceImpl extends ServiceImpl<ExpressCompanyMapper, ExpressCompany> implements IExpressCompanyService {

    /**
     * 获取所有的快递公司
     *
     * @param param
     * @return
     */
    @Override
    public List<ExpressCompany> getExpressCompanys(QueryParam param) {
        return baseMapper.getExpressCompanys(param);
    }
}
