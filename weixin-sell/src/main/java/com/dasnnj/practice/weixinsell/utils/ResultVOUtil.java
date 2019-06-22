package com.dasnnj.practice.weixinsell.utils;

import com.dasnnj.practice.weixinsell.vo.ResultVO;

/**
 * Description <P> DO : 返回对象工具类 <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-18 22:25
 */
public class ResultVOUtil {

    /**
     * Description <p> DO :  成功，返回data</p>
     *
     * @param     data
     * @return com.dasnnj.practice.weixinsell.vo.ResultVO
     *
     * @author dasnnj
     * @date 2019-06-18 10:30
     */
    public static ResultVO success(Object data) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setData(data);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /**
     * Description <p> DO :  成功，不返回data</p>
     *
     * @param
     * @return com.dasnnj.practice.weixinsell.vo.ResultVO
     *
     * @author dasnnj
     * @date 2019-06-18 10:30
     */
    public static ResultVO success() {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setData(null);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
    /**
     * Description <p> DO : 失败反馈 </p>
     *
     * @param     code
     * @param     msg
     * @return com.dasnnj.practice.weixinsell.vo.ResultVO
     *
     * @author dasnnj
     * @date 2019-06-18 10:30
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
