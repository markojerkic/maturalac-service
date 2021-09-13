package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.data.entity.SavedFile;
import com.maturalac.maturalacservice.data.entity.util.FileType;
import com.maturalac.maturalacservice.data.repository.SavedFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class SavedFilesService {
    private final SavedFileRepository savedFileRepository;

    private final String BASEPATH = "C:\\Dev\\maturalac-service\\files\\";

    public byte[] getFileByFileName(String fileName) throws IOException {
        SavedFile savedFile = this.savedFileRepository.findByFileName(fileName);
        Path filePath = Paths.get(this.BASEPATH + fileName + (savedFile.getFileType() == FileType.IMAGE? ".png": ".mp3"));
        return Files.readAllBytes(filePath);
    }
}
