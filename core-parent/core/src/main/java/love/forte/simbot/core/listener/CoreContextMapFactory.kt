/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  parent
 * File     CoreContextMapFactory.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 */

package love.forte.simbot.core.listener

import love.forte.simbot.listener.ContextMap
import love.forte.simbot.listener.ContextMapFactory
import love.forte.simbot.listener.ContextMapImpl
import java.util.concurrent.ConcurrentHashMap

/**
 * [ContextMapFactory] 实现。
 *
 * @author ForteScarlet -> https://github.com/ForteScarlet
 */
public object CoreContextMapFactory : ContextMapFactory {

    /**
     * 当前context map. 每次获取则新建。
     */
    private val instant: MutableMap<String, Any> get() = ConcurrentHashMap()

    /**
     * 全局global map. 单例唯一。
     */
    private val global: MutableMap<String, Any> = ConcurrentHashMap()



    override val contextMap: ContextMap
        get() = ContextMapImpl(instant, global)
}