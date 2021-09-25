package com.maturalac.maturalacservice.data.repository;

import com.maturalac.maturalacservice.data.entity.SavedFile;
import com.maturalac.maturalacservice.data.entity.util.FileType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedFileRepository extends JpaRepository<SavedFile, Long> {
    SavedFile findByFileName(String fileName);
    SavedFile findByFileType(FileType fileType);
    List<SavedFile> findAllByFileType(FileType fileType);

    boolean existsByFileName(String fileName);
}
