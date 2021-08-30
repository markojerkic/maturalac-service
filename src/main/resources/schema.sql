create table exam_year
(
    id        int auto_increment
        primary key,
    exam_name varchar(30) not null,
    constraint exam_name
        unique (exam_name)
);
create table files
(
    id        int auto_increment
        primary key,
    file_name varchar(50) null,
    file_type varchar(10) null,
    constraint file_name
        unique (file_name)
);
create table subjects
(
    id           int auto_increment
        primary key,
    subject_name varchar(100) not null,
    constraint subject_name
        unique (subject_name)
);
create table subject_year_relation
(
    id           int auto_increment
        primary key,
    subject_id   int                  not null,
    exam_year_id int                  not null,
    is_public    tinyint(1) default 0 not null,
    constraint subject_year_relation_ibfk_1
        foreign key (subject_id) references subjects (id),
    constraint subject_year_relation_ibfk_2
        foreign key (exam_year_id) references exam_year (id)
);

create index exam_year_id
    on subject_year_relation (exam_year_id);

create index subject_id
    on subject_year_relation (subject_id);

create table super_questions
(
    id       int auto_increment
        primary key,
    question text not null,
    img_id   int  null,
    audio_id int  null,
    constraint audio_id
        foreign key (audio_id) references files (id),
    constraint img_id
        foreign key (img_id) references files (id)
);
create table questions
(
    id                   int auto_increment
        primary key,
    correctAns           int  not null,
    ansC                 text null,
    ansB                 text null,
    questionNumber       int  not null,
    ansA                 text null,
    typeOfAnswer         int  not null,
    question             text not null,
    ansD                 text null,
    subject_exam_year_id int  not null,
    super_question_id    int  null,
    question_img_id      int  null,
    ans_img_id           int  null,
    constraint ans_img_file_id
        foreign key (ans_img_id) references files (id),
    constraint question_img_id
        foreign key (question_img_id) references files (id),
    constraint subject_exam_year_id
        foreign key (subject_exam_year_id) references subject_year_relation (id),
    constraint super_question_id
        foreign key (super_question_id) references super_questions (id)
);

create index ans_img_id
    on questions (question_img_id);
