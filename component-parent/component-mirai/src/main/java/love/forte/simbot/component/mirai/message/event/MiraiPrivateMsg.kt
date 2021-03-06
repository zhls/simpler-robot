/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  parent
 * File     MiraiPrivateMsg.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 */

package love.forte.simbot.component.mirai.message.event

import love.forte.simbot.api.message.assists.Flag
import love.forte.simbot.api.message.containers.AccountInfo
import love.forte.simbot.api.message.containers.GroupContainer
import love.forte.simbot.api.message.containers.GroupInfo
import love.forte.simbot.api.message.events.MessageContent
import love.forte.simbot.api.message.events.PrivateMsg
import love.forte.simbot.component.mirai.message.*
import net.mamoe.mirai.message.FriendMessageEvent
import net.mamoe.mirai.message.TempMessageEvent
import net.mamoe.mirai.message.data.MessageSource


/**
 * mirai的私聊消息事件。此为好友私聊。
 */
public class MiraiPrivateMsg(event: FriendMessageEvent) :
    MiraiMessageMsgGet<FriendMessageEvent>(event), PrivateMsg {

    /**
     * 账号的信息。
     */
    override val accountInfo: AccountInfo = MiraiFriendAccountInfo(event.friend)

    /**
     * 获取私聊消息类型，好友类型。
     */
    override val privateMsgType: PrivateMsg.Type = PrivateMsg.Type.FRIEND

    // private var _msgContent: MessageContent = MiraiMessageChainContent(message)

    /**
     *  消息事件的消息正文文本。
     *  使用 [MiraiMessageContent]作为最终消息载体。
     */
    override val msgContent: MessageContent = MiraiMessageChainContent(message)

    /**
     * 提供一个简单的方法来获取 [msgContent] 中的文本内容。
     */
    override val msg: String?
        get() = msgContent.msg

    /**
     * 私聊消息标识，
     * 非线程安全的懒加载。
     */
    override val flag: Flag<MiraiPrivateFlagContent> by lazy(LazyThreadSafetyMode.NONE) {
        miraiMessageFlag(MiraiPrivateFlagContent(event.source))
    }

    /**
     * id 直接使用 [标识][flagId] 获取。
     */
    override val id: String
        get() = flag.flagId

}

/**
 * mirai的私聊消息事件。此为群临时会话消息。
 * 可以得到群信息。
 */
public class MiraiTempMsg(event: TempMessageEvent) :
    MiraiMessageMsgGet<TempMessageEvent>(event), PrivateMsg, GroupContainer {

    private val tempAccountInfo = MiraiMemberAccountInfo(event.sender)

    /**
     * 账号的信息。
     */
    override val accountInfo: AccountInfo get() = tempAccountInfo

    /**
     * 群信息。
     */
    override val groupInfo: GroupInfo get() = tempAccountInfo

    /**
     * 获取私聊消息类型，群临时消息类型。
     */
    override val privateMsgType: PrivateMsg.Type = PrivateMsg.Type.GROUP_TEMP


    /**
     *  消息事件的消息正文文本。
     *  使用 [MiraiMessageContent]作为最终消息载体。
     */
    override val msgContent: MessageContent = MiraiMessageChainContent(message)

    /**
     * 提供一个简单的方法来获取 [msgContent] 中的文本内容。
     */
    override val msg: String?
        get() = msgContent.msg

    /**
     * 私聊消息标识，
     * 非线程安全的懒加载。
     */
    override val flag: Flag<MiraiPrivateFlagContent> by lazy(LazyThreadSafetyMode.NONE) {
        miraiMessageFlag(MiraiPrivateFlagContent(event.source))
    }

    /**
     * id 直接使用 [标识][flagId] 获取。
     */
    override val id: String
        get() = flag.flagId

}

/** flag content. */
public class MiraiPrivateFlagContent(override val source: MessageSource) :
    MiraiMessageSourceFlagContent(), PrivateMsg.FlagContent





