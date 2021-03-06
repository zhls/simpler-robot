/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  parent
 * File     ErrorGetter.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 */

@file:JvmName("ErrorGetterFactories")
package love.forte.simbot.api.sender

import love.forte.simbot.api.message.events.MsgGet
import love.forte.simbot.api.message.containers.BotContainer


/**
 * [Getter] 的 无效化实现，所有的方法均会抛出异常。
 *
 * @see ErrorGetterFactory
 *
 */
object ErrorGetter : Getter {
    override val authInfo: Nothing
        get() = NO("Getter.authInfo")
    override val botInfo: Nothing
        get() = NO("Getter.botInfo")

    override fun getFriendInfo(code: String): Nothing =
        NO("Getter.getFriendInfo")

    override fun getMemberInfo(group: String, code: String): Nothing =
        NO("Getter.getMemberInfo")

    override fun getGroupInfo(group: String): Nothing =
        NO("Getter.getGroupInfo")

    override fun getFriendList(cache: Boolean, limit: Int): Nothing =
        NO("Getter.getFriendList")

    override fun getGroupList(cache: Boolean, limit: Int): Nothing =
        NO("Getter.getGroupList")

    override fun getGroupMemberList(group: String, cache: Boolean, limit: Int): Nothing =
        NO("Getter.getGroupMemberList")

    override fun getBanList(group: String, cache: Boolean, limit: Int): Nothing =
        NO("Getter.getBanList")

    override fun getGroupNoteList(group: String, cache: Boolean, limit: Int): Nothing =
        NO("Getter.getGroupNoteList")
}


/**
 * [ErrorGetter] 的构建工厂，得到的 [Getter] 实例的所有方法均会抛出异常。
 */
@get:JvmName("getErrorGetterFactory")
public val ErrorGetterFactory : GetterFactory = object : GetterFactory {
    override fun getOnMsgGetter(msg: MsgGet): Getter = ErrorGetter
    override fun getOnBotGetter(bot: BotContainer): Getter = ErrorGetter
}
