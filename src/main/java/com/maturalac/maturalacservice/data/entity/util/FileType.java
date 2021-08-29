package com.maturalac.maturalacservice.data.entity.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FileType {
    IMAGE(".png"), AUDIO(".mp3");
    public String value;
}
