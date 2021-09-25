package com.maturalac.maturalacservice.data.entity;

import com.maturalac.maturalacservice.data.entity.util.FileType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="files", uniqueConstraints = {
        @UniqueConstraint(name="file_name", columnNames="file_name")
})
public class SavedFile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="file_name")
    @NotNull
    private String fileName;

    @Column(name="file_type")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private FileType fileType;
}
