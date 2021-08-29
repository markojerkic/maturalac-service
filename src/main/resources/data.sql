
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (9, 'Biologija');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (3, 'Engleski jezik - osnovna razina');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (2, 'Engleski jezik - viša razina');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (7, 'Fizika');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (6, 'Hrvatski jezik - osnovna razina');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (5, 'Hrvatski jezik - viša razina');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (4, 'Kemija');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (8, 'Matematika - osnovna razina');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (10, 'Matematika - viša razina');
INSERT INTO drzavnamatura.subjects (id, subject_name) VALUES (1, 'Test');

INSERT INTO drzavnamatura.exam_year (id, exam_name) VALUES (1, '2019./20. JESEN');
INSERT INTO drzavnamatura.exam_year (id, exam_name) VALUES (2, '2019./20. LJETO');


INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (1, 1, 1, 0);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (2, 2, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (3, 2, 2, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (4, 3, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (6, 4, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (8, 5, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (9, 5, 2, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (10, 6, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (11, 6, 2, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (12, 7, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (13, 7, 2, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (14, 8, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (15, 8, 2, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (16, 9, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (17, 9, 2, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (18, 10, 1, 1);
INSERT INTO drzavnamatura.subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (19, 10, 2, 1);