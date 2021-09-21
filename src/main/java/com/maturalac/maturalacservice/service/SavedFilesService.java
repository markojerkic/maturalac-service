package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.controller.dto.SavedFileResponse;
import com.maturalac.maturalacservice.data.entity.SavedFile;
import com.maturalac.maturalacservice.data.entity.util.FileType;
import com.maturalac.maturalacservice.data.repository.SavedFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class SavedFilesService {
    private final SavedFileRepository savedFileRepository;

    @Value("${files.location}")
    private String filesRootPath;

    public SavedFileResponse getFileByFileName(String fileName) throws IOException {
        SavedFile savedFile = this.savedFileRepository.findByFileName(fileName);
        if (savedFile == null) {
            throw new FileNotFoundException("Datoteka " + fileName + " nije pronađena");
        }
        Path filePath = Paths.get(this.filesRootPath + fileName + (savedFile.getFileType() == FileType.IMAGE? ".png": ".mp3"));
        return new SavedFileResponse(savedFile.getFileType(), Files.readAllBytes(filePath));
    }
}
