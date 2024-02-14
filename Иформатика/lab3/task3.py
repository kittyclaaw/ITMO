import re

pattern = r'[A-Za-z._]{1,}@[A-Za-z]{1,}\.[A-Za-z]{2,3}$'

def test(regex):
    if re.fullmatch(pattern, regex):
        print((regex.split('@'))[1])
    else:
        print('fail!')

test('students.spam@yandex.ru')
test('example@example')
test('kucherukrodion@yandex.ru')
test('@gmail.com')
test('example@mail.com.com')

