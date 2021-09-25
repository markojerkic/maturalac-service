package com.maturalac.maturalacservice.data.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="super_questions")
@Data
public class SuperQuestion {
    @Id
    @GeneratedValue()
    private UUID id;

    @Column(columnDefinition = "text")
    @NotNull
    private String question;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="img_id")
    private SavedFile image;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="audio_id")
    private SavedFile audio;
}
