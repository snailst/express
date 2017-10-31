package com.snailst.express.service;

import com.snailst.express.entity.ExpressCode;
import com.baomidou.mybatisplus.service.IService;
import com.snailst.express.web.dto.ExpressCodeDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
public interface IExpressCodeService extends IService<ExpressCode> {

    /**
     * 获取下一个未使用的快递单号
     * @param com
     * @return
     */
    String getNextExpressCode(String com);

    /**
     * 快递单号充值
     * @param param
     */
    void rechargeExpressCode(ExpressCodeDto param);

    /**
     * 设置快递单号状态
     * @param useable
     * @param code
     */
    void setState(boolean useable, String code);
}
