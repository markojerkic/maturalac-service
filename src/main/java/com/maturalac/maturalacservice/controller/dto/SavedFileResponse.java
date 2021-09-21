package com.maturalac.maturalacservice.controller.dto;

import com.maturalac.maturalacservice.data.entity.util.FileType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SavedFileResponse {
    private FileType fileType;
    private byte[] fileBytes;
}
