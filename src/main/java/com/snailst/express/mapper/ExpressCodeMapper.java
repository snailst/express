package com.snailst.express.mapper;

import com.snailst.express.entity.ExpressCode;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.snailst.express.web.dto.ExpressCodeDto;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
public interface ExpressCodeMapper extends BaseMapper<ExpressCode> {

    /**
     * 获取下一个未使用的快递单号
     * @param com
     * @return
     */
    String getNextExpressCode(@Param("com") String com);

    /**
     * 快递单号充值
     * @param param
     */
    void rechargeExpressCode(ExpressCodeDto param);

    /**
     * 设置快递单号是否可用
     * @param useable
     * @param code
     */
    void setState(@Param("useable") boolean useable, @Param("code") String code);
}