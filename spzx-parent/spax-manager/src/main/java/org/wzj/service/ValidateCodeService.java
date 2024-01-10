package org.wzj.service;

import org.wzj.spzx.model.vo.system.ValidateCodeVo;

public interface ValidateCodeService {
    //生成图片验证码
    ValidateCodeVo generateValidateCode();
}
