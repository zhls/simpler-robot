/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  parent
 * File     FilterParameterMatcher.java
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 */

package love.forte.simbot.filter;

import love.forte.simbot.annotation.FilterValue;

import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * 动态参数匹配器。
 *
 * 在参数上标注注解 {@link FilterValue} 来使用。
 *
 * @author <a href="https://github.com/ForteScarlet"> ForteScarlet </a>
 */
public interface FilterParameterMatcher {

    /**
     * 获取原始字符串
     * @return 原始字符串
     */
    String getOriginal();

    /**
     * 获取用于匹配的正则
     * @return 匹配正则
     */
    Pattern getPattern();


    /**
     * 根据变量名称获取一个动态参数。
     * 此文本需要符合正则表达式。
     * @param name 变量名称
     * @param text 文本
     * @return 得到的参数
     */
    String getParam(String name, String text);

    /**
     * 从一段匹配的文本中提取出需要的参数。
     * 此文本需要符合正则表达式。
     * @param text 匹配的文本
     * @return 得到的参数
     */
    Map<String, String> getParams(String text);

}
