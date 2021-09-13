package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.service.SavedFilesService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/files")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class SavedFilesController {

    private final SavedFilesService savedFilesService;

    @GetMapping(value = "/{fileName}",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public byte[] getFile(@PathVariable String fileName) throws IOException {
        return this.savedFilesService.getFileByFileName(fileName);
    }
}
