package com.maturalac.maturalacservice.data.entity;

import com.maturalac.maturalacservice.data.entity.util.FileType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedFile {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="file_name", unique=true)
    @NotNull
    private String fileName;

    @Column(name="file_type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private FileType fileType;
}