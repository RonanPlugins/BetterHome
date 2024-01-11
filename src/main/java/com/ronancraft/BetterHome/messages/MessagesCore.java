package com.ronancraft.BetterHome.messages;

import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.List;

public enum MessagesCore {

    //SetHome
    SETHOME_SUCCESS("SetHome.Success"),
    SETHOME_SUCCESS_CUSTOM("SetHome.Custom"),
    //Home
    HOME_SUCCESS("Home.Success"),
    HOME_NONE("Home.None"),

    //BetterHome
    RELOAD("Reload"),
    NOPERMISSION("NoPermission"),
    INVALID("Invalid"),
    ;

    final String section;

    MessagesCore(String section) {
        this.section = section;
    }

    private static final String pre = "Messages.";

    public void send(CommandSender sendi) {
        Message_RTP.sms(sendi, Message_RTP.getLang().getString(pre + section));
    }

    public void send(CommandSender sendi, Object placeholderInfo) {
        Message_RTP.sms(sendi, Message_RTP.getLang().getString(pre + section), placeholderInfo);
    }

    public void send(CommandSender sendi, List<Object> placeholderInfo) {
        Message_RTP.sms(sendi, Message_RTP.getLang().getString(pre + section), placeholderInfo);
    }

    public String get(CommandSender p, Object placeholderInfo) {
        return Message.placeholder(p, Message_RTP.getLang().getString(pre + section), placeholderInfo);
    }

    public void send(CommandSender sendi, HashMap<String, String> placeholder_values) {
        String msg = Message_RTP.getLang().getString(pre + section);
        for (String ph : placeholder_values.values())
            msg = msg.replace(ph, placeholder_values.get(ph));
        Message_RTP.sms(sendi, msg);
    }
}
