package com.snailst.express.service.impl;

import com.snailst.express.entity.ExpressCode;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.mapper.ExpressCodeMapper;
import com.snailst.express.service.IExpressCodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.snailst.express.web.dto.ExpressCodeDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@Service
public class ExpressCodeServiceImpl extends ServiceImpl<ExpressCodeMapper, ExpressCode> implements IExpressCodeService {
    /**
     * 获取下一个未使用的快递单号
     *
     * @param com
     * @return
     */
    @Override
    public String getNextExpressCode(String com) {
        return baseMapper.getNextExpressCode(com);
    }

    /**
     * 快递单号充值
     *
     * @param param
     */
    @Override
    public void rechargeExpressCode(ExpressCodeDto param) {
        baseMapper.rechargeExpressCode(param);
    }

    /**
     * 设置快递单号状态
     *
     * @param useable
     */
    @Override
    public void setState(boolean useable, String code) {
        baseMapper.setState(useable, code);
    }

    /**
     * 查询快递单号
     *
     * @param param
     * @return
     */
    @Override
    public List<ExpressCode> getExpressCodes(QueryParam param) {
        return baseMapper.getExpressCodes(param);
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
     * 删除快递单号
     *
     * @param id
     */
    @Override
    public void delExpressCode(Long id) {
        ExpressCode expressCode = baseMapper.selectById(id);
        if (!expressCode.getState()) {
            baseMapper.deleteById(id);
        }
    }
}
