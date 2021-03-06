/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  parent
 * File     NoSuchBotException.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 */

package love.forte.simbot.bot

/**
 *
 * 没有对应的bot异常。
 *
 * @author ForteScarlet -> https://github.com/ForteScarlet
 */
public class NoSuchBotException : IllegalStateException {
    constructor() : super()
    constructor(s: String?) : super(s)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}


/**
 * bot 验证（登录）异常。
 */
public class BotVerifyException : IllegalStateException {
    constructor() : super()
    constructor(s: String?) : super(s)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}







