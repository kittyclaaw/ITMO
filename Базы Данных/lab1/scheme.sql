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
    human_disease_status BOOLEAN NOT NULL,
    human_disease_chance INT
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
    conclusion_time text NOT NULL,
    conclusion_result BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS verification(
    id SERIAL NOT NULL PRIMARY KEY,
    conclusion_id INT NOT NULL REFERENCES conclusion(id),
    verification_time text NOT NULL,
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
    disease_pain_level DISEASE_PAIN_LEVEL
);

CREATE TABLE IF NOT EXISTS question(
    id SERIAL NOT NULL PRIMARY KEY,
    item_id INT REFERENCES item(id),
    question_text text NOT NULL
);

INSERT INTO method(human_id, method_target, method_type, method_difficulty)
    VALUES ('1', 'кругляши', 'абстрактного', 'первоклассную');

INSERT INTO human(human_name, human_state, human_disease_status, human_disease_chance)
    VALUES ('смотрящий на Луну', 'unk', FALSE, 10);

INSERT INTO conclusion(method_id, conclusion_time, conclusion_result)
    VALUES ('1', '3-4 минуты', TRUE);

INSERT INTO verification(conclusion_id, verification_state, verification_time)
    VALUES ('1', TRUE, 'немедленно');

INSERT INTO item(conclusion_id, item_name, item_color, item_form, item_density, item_size, item_taste)
    VALUES ('1', 'голыши', 'белые', 'круглые', 'мягкие', 'большой', 'очень вкусны');

INSERT INTO disease(human_id, item_id, disease_name, disease_state, disease_pain_level)
    VALUES ('1', '1', 'unk', FALSE);

INSERT INTO question(item_id, question_text)
    VALUES ('1', 'Может быть, и этот, большой, тоже?..');

COMMIT;
