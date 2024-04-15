BEGIN;
    CREATE TYPE DISEASE_PAIN_LEVEL AS ENUM(
    'очень сильно',
    'сильно',
    'не тяжело',
    'слегка'
);

CREATE TABLE IF NOT EXISTS human(
    id SERIAL NOT NULL PRIMARY KEY,
    human_name text NOT NULL,
    human_state text NOT NULL,
    human_disease_status BOOLEAN NOT NULL DEFAULT FALSE,
    human_immunity BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS method(
    id SERIAL NOT NULL PRIMARY KEY,
    human_id INT NOT NULL REFERENCES human(id),
    method_target text NOT NULL,
    method_type text NOT NULL,
    method_difficulty text NOT NULL
);

CREATE TABLE IF NOT EXISTS conclusion(
    id SERIAL NOT NULL PRIMARY KEY,
    method_id INT NOT NULL REFERENCES method(id),
    conclusion_time TIME,
    conclusion_result BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS verification(
    id SERIAL NOT NULL PRIMARY KEY,
    conclusion_id INT NOT NULL REFERENCES conclusion(id),
    time_start TIME NOT NULL,
    time_end TIME,
    verification_state BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS item(
    id SERIAL NOT NULL NULL PRIMARY KEY,
    conclusion_id INT REFERENCES conclusion(id),
    item_name text NOT NULL,
    item_color text NOT NULL,
    item_form text NOT NULL,
    item_density text NOT NULL,
    item_size text NOT NULL,
    item_taste text NOT NULL
);

CREATE TABLE IF NOT EXISTS disease(
    id SERIAL NOT NULL PRIMARY KEY,
    human_id INT NOT NULL REFERENCES human(id),
    item_id INT REFERENCES item(id),
    disease_name text NOT NULL,
    disease_state BOOLEAN NOT NULL DEFAULT FALSE,
    disease_pain_level DISEASE_PAIN_LEVEL,
    disease_syptoms text,
    start_date DATE,
    end_date DATE
);

CREATE TABLE IF NOT EXISTS question(
    id SERIAL NOT NULL PRIMARY KEY,
    item_id INT REFERENCES item(id),
    question_text text NOT NULL
);
INSERT INTO human(human_name, human_state, human_disease_status, human_immunity)
    VALUES ('смотрящий на Луну', 'размышляет', FALSE, FALSE);

INSERT INTO method(human_id, method_target, method_type, method_difficulty)
    VALUES ('1', 'кругляши', 'абстрактного', 'первоклассную');

INSERT INTO conclusion(method_id, conclusion_time, conclusion_result)
    VALUES ('1', '04:05-08:00', TRUE);

INSERT INTO verification(conclusion_id, verification_state, time_start, time_end)
    VALUES ('1', TRUE, '00:08:00', '00:10:00');

INSERT INTO item(conclusion_id, item_name, item_color, item_form, item_density, item_size, item_taste)
    VALUES ('1', 'голыши', 'белые', 'круглые', 'мягкие', 'большой', 'очень вкусны');

INSERT INTO disease(human_id, item_id, disease_name, disease_state, disease_pain_level, start_date, end_date)
    VALUES ('1', '1', 'unk', FALSE, 'сильно', '2001-02-01', '2001-02-03');

INSERT INTO question(item_id, question_text)
    VALUES ('1', 'Может быть, и этот, большой, тоже?..');

COMMIT;
