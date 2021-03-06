INSERT INTO exam_year (id, exam_name) VALUES (1, '2019./20. JESEN');
INSERT INTO exam_year (id, exam_name) VALUES (2, '2019./20. LJETO');

INSERT INTO subjects (id, subject_name) VALUES (9, 'Biologija');
INSERT INTO subjects (id, subject_name) VALUES (3, 'Engleski jezik - osnovna razina');
INSERT INTO subjects (id, subject_name) VALUES (2, 'Engleski jezik - viša razina');
INSERT INTO subjects (id, subject_name) VALUES (7, 'Fizika');
INSERT INTO subjects (id, subject_name) VALUES (6, 'Hrvatski jezik - osnovna razina');
INSERT INTO subjects (id, subject_name) VALUES (5, 'Hrvatski jezik - viša razina');
INSERT INTO subjects (id, subject_name) VALUES (4, 'Kemija');
INSERT INTO subjects (id, subject_name) VALUES (8, 'Matematika - osnovna razina');
INSERT INTO subjects (id, subject_name) VALUES (10, 'Matematika - viša razina');
INSERT INTO subjects (id, subject_name) VALUES (1, 'Test');

INSERT INTO subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (1, 1, 1, 0);
INSERT INTO subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (2, 2, 1, 1);
INSERT INTO subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (3, 2, 2, 1);
INSERT INTO subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (4, 3, 1, 1);
INSERT INTO subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (6, 4, 1, 1);
INSERT INTO subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (8, 5, 1, 1);
INSERT INTO subject_year_relation (id, subject_id, exam_year_id, is_public) VALUES (9, 5, 2, 1);