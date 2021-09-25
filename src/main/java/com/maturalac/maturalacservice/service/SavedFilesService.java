package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.controller.dto.SavedFileResponse;
import com.maturalac.maturalacservice.data.entity.SavedFile;
import com.maturalac.maturalacservice.data.entity.util.FileType;
import com.maturalac.maturalacservice.data.repository.SavedFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SavedFilesService {
    private final SavedFileRepository savedFileRepository;

    private final String IMAGE_EXTENSION = ".png";
    private final String AUDIO_EXTENSION = ".mp4";

    @Value("${files.location}")
    private String filesRootPath;

    public SavedFileResponse getFileByFileName(String fileName) throws IOException {
        SavedFile savedFile = this.savedFileRepository.findByFileName(fileName);
        if (savedFile == null) {
            throw new FileNotFoundException("Datoteka " + fileName + " nije pronađena");
        }
        Path filePath = Paths.get(this.filesRootPath + fileName +
                (savedFile.getFileType() == FileType.IMAGE? IMAGE_EXTENSION: AUDIO_EXTENSION));
        return new SavedFileResponse(savedFile.getFileType(), Files.readAllBytes(filePath));
    }

    public SavedFile saveFile(MultipartFile file) throws IOException {
        UUID fileName = UUID.randomUUID();
        while (this.savedFileRepository.existsByFileName(fileName.toString())) {
            fileName = UUID.randomUUID();
        }
        SavedFile savedFile = new SavedFile();
        savedFile.setFileName(fileName.toString());

        savedFile.setFileType(Objects.requireNonNull(file.getContentType()).startsWith("image")? FileType.IMAGE: FileType.AUDIO);
        file.transferTo(Paths.get(this.filesRootPath + savedFile.getFileName() +
                (savedFile.getFileType() == FileType.IMAGE? IMAGE_EXTENSION: AUDIO_EXTENSION)));
        savedFile = this.savedFileRepository.save(savedFile);
        return savedFile;
    }
}
