--Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:
--Н_ТИПЫ_ВЕДОМОСТЕЙ, Н_ВЕДОМОСТИ.
--Вывести атрибуты: Н_ТИПЫ_ВЕДОМОСТЕЙ.ИД, Н_ВЕДОМОСТИ.ДАТА.
--Фильтры (AND):
--a) Н_ТИПЫ_ВЕДОМОСТЕЙ.НАИМЕНОВАНИЕ = Экзаменационный лист.
--b) Н_ВЕДОМОСТИ.ЧЛВК_ИД > 142390.
--c) Н_ВЕДОМОСТИ.ЧЛВК_ИД = 163249.
--Вид соединения: LEFT JOIN.

SELECT "Н_ТИПЫ_ВЕДОМОСТЕЙ"."НАИМЕНОВАНИЕ", "Н_ВЕДОМОСТИ"."ЧЛВК_ИД"
FROM "Н_ВЕДОМОСТИ"
         LEFT JOIN "Н_ТИПЫ_ВЕДОМОСТЕЙ" ON "Н_ВЕДОМОСТИ"."ВЕД_ИД" = "Н_ТИПЫ_ВЕДОМОСТЕЙ"."ИД"
WHERE "Н_ТИПЫ_ВЕДОМОСТЕЙ"."НАИМЕНОВАНИЕ" < 'Перезачет'
  AND "Н_ВЕДОМОСТИ"."ИД" > 142390
  AND "Н_ВЕДОМОСТИ"."ИД" = 163249;

--Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:
--Таблицы: Н_ЛЮДИ, Н_ОБУЧЕНИЯ, Н_УЧЕНИКИ.
--Вывести атрибуты: Н_ЛЮДИ.ИМЯ, Н_ОБУЧЕНИЯ.ЧЛВК_ИД, Н_УЧЕНИКИ.ГРУППА.
--Фильтры: (AND)
--a) Н_ЛЮДИ.ФАМИЛИЯ < Соколов.
--b) Н_ОБУЧЕНИЯ.ЧЛВК_ИД < 163276.
--Вид соединения: INNER JOIN.

SELECT  "Н_ЛЮДИ"."ИМЯ", "Н_ОБУЧЕНИЯ"."ЧЛВК_ИД", "Н_УЧЕНИКИ"."ГРУППА"
FROM "Н_ОБУЧЕНИЯ"
    INNER JOIN "Н_ЛЮДИ" ON "Н_ОБУЧЕНИЯ"."ЧЛВК_ИД" = "Н_ЛЮДИ"."ИД"
    INNER JOIN "Н_УЧЕНИКИ" ON "Н_ОБУЧЕНИЯ"."ЧЛВК_ИД" = "Н_УЧЕНИКИ"."ЧЛВК_ИД"
WHERE "Н_ЛЮДИ"."ФАМИЛИЯ" < 'Соколов'
    AND "Н_ОБУЧЕНИЯ"."ЧЛВК_ИД" < 163276;

--Вывести число студентов ФКТИУ, которые младше 20 лет.
--Ответ должен содержать только одно число.

SELECT COUNT(*)
FROM
	"Н_ОТДЕЛЫ"
JOIN "Н_ПЛАНЫ" ON
	Н_ПЛАНЫ."ОТД_ИД" = Н_ОТДЕЛЫ."ИД"
JOIN "Н_УЧЕНИКИ" ON
	Н_УЧЕНИКИ."ПЛАН_ИД" = Н_ПЛАНЫ."ИД"
JOIN "Н_ОБУЧЕНИЯ" ON
	Н_ОБУЧЕНИЯ."ЧЛВК_ИД"  = Н_УЧЕНИКИ."ЧЛВК_ИД"
JOIN "Н_ЛЮДИ" ON
	Н_ЛЮДИ."ИД" = Н_ОБУЧЕНИЯ."ЧЛВК_ИД"
WHERE
	Н_ЛЮДИ."ДАТА_РОЖДЕНИЯ" < '29-04-2004'::date
	AND Н_ОТДЕЛЫ."КОРОТКОЕ_ИМЯ" = 'КТиУ';

--Найти группы, в которых в 2011 году было более 10 обучающихся студентов на ФКТИУ.
--Для реализации использовать соединение таблиц.

SELECT DISTINCT "ГРУППЫ_2011"."ГРУППА"
FROM (SELECT "Н_УЧЕНИКИ"."ГРУППА", COUNT("Н_УЧЕНИКИ"."ИД") AS "КОЛИЧЕСТВО"
    FROM "Н_УЧЕНИКИ"
    WHERE "Н_УЧЕНИКИ"."НАЧАЛО" < '2011-01-01'::date
        AND "Н_УЧЕНИКИ"."КОНЕЦ" > '2011-12-30'::date
    GROUP BY "Н_УЧЕНИКИ"."ГРУППА") AS "ГРУППЫ_2011"
        RIGHT JOIN "Н_ГРУППЫ_ПЛАНОВ" ON "Н_ГРУППЫ_ПЛАНОВ"."ГРУППА" = "ГРУППЫ_2011"."ГРУППА"
        RIGHT JOIN "Н_ПЛАНЫ" ON "Н_ГРУППЫ_ПЛАНОВ"."ПЛАН_ИД" = "Н_ПЛАНЫ"."ИД"
WHERE "ГРУППЫ_2011"."КОЛИЧЕСТВО" > 10
    AND "Н_ПЛАНЫ"."ОТД_ИД" = (SELECT "Н_ОТДЕЛЫ"."ИД"
                            FROM "Н_ОТДЕЛЫ"
                            WHERE "Н_ОТДЕЛЫ"."КОРОТКОЕ_ИМЯ" = 'КТиУ');

--Выведите таблицу со средними оценками студентов группы 4100 (Номер, ФИО, Ср_оценка),
--у которых средняя оценка больше минимальной оценк(е|и) в группе 3100.

SELECT "Н_ВЕДОМОСТИ"."ЧЛВК_ИД",
       AVG(CASE
               WHEN ("ОЦЕНКА" <> 'зачет' AND "ОЦЕНКА" <> 'осв' AND "ОЦЕНКА" <> 'незач' AND "ОЦЕНКА" <> 'неявка')
                   THEN CAST("ОЦЕНКА" AS INTEGER) END) AS "СР_ОЦЕНКА",
       "Н_ЛЮДИ"."ФАМИЛИЯ",
       "Н_ЛЮДИ"."ИМЯ",
       "Н_ЛЮДИ"."ОТЧЕСТВО"
FROM "Н_ВЕДОМОСТИ"
         JOIN "Н_УЧЕНИКИ" ON "Н_УЧЕНИКИ"."ЧЛВК_ИД" = "Н_ВЕДОМОСТИ"."ЧЛВК_ИД"
         JOIN "Н_ЛЮДИ" ON "Н_ВЕДОМОСТИ"."ЧЛВК_ИД" = "Н_ЛЮДИ"."ИД"
WHERE "ГРУППА" = '4100'
GROUP BY "Н_ВЕДОМОСТИ"."ЧЛВК_ИД", "ФАМИЛИЯ", "ИМЯ", "ОТЧЕСТВО"
HAVING AVG(CASE
               WHEN ("ОЦЕНКА" <> 'зачет'
                   AND "ОЦЕНКА" <> 'осв'
                   AND "ОЦЕНКА" <> 'незач'
                   AND "ОЦЕНКА" <> 'неявка')
                   THEN CAST("ОЦЕНКА" AS INTEGER)
    END) > (SELECT MIN("ОЦЕНКИ_3100"."МИНИМАЛЬНЫЕ")
             FROM (SELECT MIN(CASE
                                  WHEN ("Н_ВЕДОМОСТИ"."ОЦЕНКА" <> 'зачет' AND
                                        "Н_ВЕДОМОСТИ"."ОЦЕНКА" <> 'осв' AND
                                        "Н_ВЕДОМОСТИ"."ОЦЕНКА" <> 'незач' AND
                                        "Н_ВЕДОМОСТИ"."ОЦЕНКА" <> 'неявка')
                                      THEN CAST("ОЦЕНКА" AS INTEGER) END) AS "МИНИМАЛЬНЫЕ"
                   FROM "Н_УЧЕНИКИ"
                            RIGHT JOIN "Н_ВЕДОМОСТИ" ON "Н_ВЕДОМОСТИ"."ЧЛВК_ИД" = "Н_УЧЕНИКИ"."ЧЛВК_ИД"
                   WHERE "Н_УЧЕНИКИ"."ГРУППА" = '3100'
                   GROUP BY "Н_УЧЕНИКИ"."ЧЛВК_ИД") AS "ОЦЕНКИ_3100");

--Получить список студентов, зачисленных ровно первого сентября 2012 года на первый курс заочной формы обучения. В результат включить:
--номер группы;
--номер, фамилию, имя и отчество студента;
--номер и состояние пункта приказа;

SELECT
	Н_УЧЕНИКИ."ГРУППА",
	Н_ЛЮДИ."ИД" AS "НОМЕР",
	Н_ЛЮДИ."ФАМИЛИЯ",
	Н_ЛЮДИ."ИМЯ",
	Н_ЛЮДИ."ОТЧЕСТВО",
	Н_УЧЕНИКИ."П_ПРКОК_ИД" AS "НОМЕР ПРИКАЗА",
	Н_УЧЕНИКИ."СОСТОЯНИЕ" AS "СОСТОЯНИЕ ПУНКТА ПРИКАЗА"
FROM
	Н_УЧЕНИКИ
JOIN "Н_ОБУЧЕНИЯ" ON
	Н_ОБУЧЕНИЯ."ЧЛВК_ИД" = Н_УЧЕНИКИ."ЧЛВК_ИД"
	AND Н_ОБУЧЕНИЯ."ВИД_ОБУЧ_ИД" = Н_УЧЕНИКИ."ВИД_ОБУЧ_ИД"
JOIN Н_ЛЮДИ ON
	Н_ЛЮДИ."ИД" = Н_ОБУЧЕНИЯ."ЧЛВК_ИД"
WHERE
	DATE("НАЧАЛО") = '2012-09-01'
	AND Н_УЧЕНИКИ."ПЛАН_ИД" IN (
	SELECT
		Н_ПЛАНЫ."ИД"
	FROM
		Н_ПЛАНЫ
	WHERE
		Н_ПЛАНЫ."КУРС" = 1
		AND Н_ПЛАНЫ."НАПС_ИД" IN (
		SELECT
			Н_ФОРМЫ_ОБУЧЕНИЯ."ИД"
		FROM
			Н_ФОРМЫ_ОБУЧЕНИЯ
		WHERE
			Н_ФОРМЫ_ОБУЧЕНИЯ."НАИМЕНОВАНИЕ" = 'Заочная'
    )
);

--Вывести список людей, не являющихся или не являвшихся студентами ФКТИУ (данные, о которых отсутствуют в таблице Н_УЧЕНИКИ).
--В запросе нельзя использовать DISTINCT.

SELECT "Н_ЛЮДИ"."ИД",
       "Н_ЛЮДИ"."ФАМИЛИЯ",
       "Н_ЛЮДИ"."ИМЯ",
       "Н_ЛЮДИ"."ОТЧЕСТВО"
FROM "Н_ЛЮДИ"
WHERE NOT EXISTS (SELECT *
                  FROM "Н_УЧЕНИКИ"
                           JOIN "Н_ПЛАНЫ" ON "Н_УЧЕНИКИ"."ПЛАН_ИД" = "Н_ПЛАНЫ"."ИД"
                           JOIN "Н_ОТДЕЛЫ" ON "Н_ПЛАНЫ"."ОТД_ИД" = "Н_ОТДЕЛЫ"."ИД"
                  WHERE "Н_ОТДЕЛЫ"."КОРОТКОЕ_ИМЯ" = 'КТиУ'
                    AND "Н_УЧЕНИКИ"."ЧЛВК_ИД" = "Н_ЛЮДИ"."ИД");

SELECT "Н_ЛЮДИ"."ИД",
       "Н_ЛЮДИ"."ФАМИЛИЯ",
       "Н_ЛЮДИ"."ИМЯ",
       "Н_ЛЮДИ"."ОТЧЕСТВО"
FROM "Н_ЛЮДИ"
WHERE "Н_ЛЮДИ"."ИД" NOT IN (SELECT "Н_УЧЕНИКИ"."ЧЛВК_ИД"
                  FROM "Н_УЧЕНИКИ"
                           JOIN "Н_ПЛАНЫ" ON "Н_УЧЕНИКИ"."ПЛАН_ИД" = "Н_ПЛАНЫ"."ИД"
                           JOIN "Н_ОТДЕЛЫ" ON "Н_ПЛАНЫ"."ОТД_ИД" = "Н_ОТДЕЛЫ"."ИД"
                  WHERE "Н_ОТДЕЛЫ"."КОРОТКОЕ_ИМЯ" = 'КТиУ');