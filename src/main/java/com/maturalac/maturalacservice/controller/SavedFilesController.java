package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.controller.dto.SavedFileResponse;
import com.maturalac.maturalacservice.data.entity.SavedFile;
import com.maturalac.maturalacservice.data.entity.util.FileType;
import com.maturalac.maturalacservice.service.SavedFilesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/files")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class SavedFilesController {

    private final SavedFilesService savedFilesService;

    @GetMapping(value = "/{fileName}",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> getFile(@PathVariable String fileName) throws IOException {
        SavedFileResponse savedFileResponse =  this.savedFilesService.getFileByFileName(fileName);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(savedFileResponse.getFileType() == FileType.IMAGE?
                MediaType.IMAGE_PNG: MediaType.parseMediaType("audio/mpeg"));

        return new ResponseEntity<>(savedFileResponse.getFileBytes(),
                headers, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SavedFile> uploadFile(@RequestParam() MultipartFile file) throws IOException {
        SavedFile savedFile = this.savedFilesService.saveFile(file);
        return ResponseEntity.ok(savedFile);
    }
}
