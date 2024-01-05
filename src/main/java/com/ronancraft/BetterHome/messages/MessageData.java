package com.ronancraft.BetterHome.messages;

import com.ronancraft.BetterHome.file.FileData;

public interface MessageData {

    String section();

    String prefix();

    FileData file();

    default String get() {
        return file().getString(prefix() + section());
    }
}
