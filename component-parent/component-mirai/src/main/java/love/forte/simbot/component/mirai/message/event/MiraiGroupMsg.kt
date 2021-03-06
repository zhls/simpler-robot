/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  parent
 * File     MiraiGroupMsg.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 */

package love.forte.simbot.component.mirai.message.event

import love.forte.simbot.api.message.assists.Flag
import love.forte.simbot.api.message.assists.Permissions
import love.forte.simbot.api.message.containers.AccountInfo
import love.forte.simbot.api.message.containers.GroupInfo
import love.forte.simbot.api.message.events.GroupMsg
import love.forte.simbot.api.message.events.MessageContent
import love.forte.simbot.component.mirai.message.*
import net.mamoe.mirai.message.GroupMessageEvent
import net.mamoe.mirai.message.data.MessageSource

/**
 *
 * mirai 群消息事件。
 *
 * @author ForteScarlet -> https://github.com/ForteScarlet
 */
public class MiraiGroupMsg(event: GroupMessageEvent) :
    MiraiMessageMsgGet<GroupMessageEvent>(event), GroupMsg {

    private val miraiGroupMemberInfo = MiraiMemberAccountInfo(event.sender)

    override val accountInfo: AccountInfo
        get() = miraiGroupMemberInfo

    override val groupInfo: GroupInfo
        get() = miraiGroupMemberInfo

    override val groupMsgType: GroupMsg.Type = GroupMsg.Type.NORMAL

    override val flag: Flag<MiraiGroupFlagContent> by lazy(LazyThreadSafetyMode.NONE) {
        miraiMessageFlag(MiraiGroupFlagContent(event.source))
    }

    override val msgContent: MessageContent = MiraiMessageChainContent(message)

    override val msg: String?
        get() = msgContent.msg

    override val permission: Permissions get() = event.sender.toSimbotPermissions()
}


/** flag content. */
public class MiraiGroupFlagContent(override val source: MessageSource) :
    MiraiMessageSourceFlagContent(), GroupMsg.FlagContent