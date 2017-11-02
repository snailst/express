package com.snailst.express.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.snailst.express.entity.ExpressCompany;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.mapper.ExpressCompanyMapper;
import com.snailst.express.service.IExpressCompanyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
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

    /**
     * 查询总记录数
     *
     * @param param
     * @return
     */
    @Override
    public long getCount(QueryParam param) {
        return baseMapper.getCount(param);
    }

    /**
     * 保存快递公司
     *
     * @param company
     */
    @Override
    public void saveExpressCompany(ExpressCompany company) {
        if (company.getId() == null) {
            baseMapper.insert(company);
        } else {
            baseMapper.update(company, new EntityWrapper<ExpressCompany>()
                    .eq("id", company.getId()));
        }
    }
}
