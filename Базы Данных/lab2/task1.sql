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