#!/bin/bash

# Имя файла для сохранения результатов
output_file="lab8.txt"

# Очищаем файл перед началом записи
> $output_file

# Записываем спецификации компьютера в файл
echo "Спецификация компьютера:" >> $output_file
echo "Процессор:" >> $output_file
sysctl -n machdep.cpu.brand_string >> $output_file
echo "Оперативная память:" >> $output_file
sysctl hw.memsize >> $output_file
echo "" >> $output_file

# Функция для запуска программы с указанными потоками и записью вывода в файл
run_test() {
    local n=$1  # Количество инкрементирующих потоков
    local m=$2  # Количество декрементирующих потоков

    # Записываем результат в файл
    echo "Тест с $n инкрементирующими и $m декрементирующими потоками:" >> $output_file
    java Lab8ReentrantLock $n $m >> $output_file
    echo "" >> $output_file
}

# Запуск тестов с различными наборами потоков
echo "Результаты выполнения программы с разным количеством потоков:" >> $output_file
run_test 1 1
run_test 2 2
run_test 4 4
run_test 8 8

# Сообщение об окончании тестирования
echo "Тестирование завершено. Результаты сохранены в файл $output_file."
