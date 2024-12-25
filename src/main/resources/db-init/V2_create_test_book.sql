DO $$
    DECLARE
        book_text TEXT := '';    -- Переменная для накопления текста книги
        line TEXT;               -- Переменная для построчного чтения текста
    BEGIN
        -- Читаем текст книги построчно из файла
        FOR line IN SELECT * FROM unnest(string_to_array(pg_read_file('C:/Work/Gulag.txt'), E'\n')) LOOP
                book_text := book_text || line || E'\n';  -- Добавляем строку в текст книги
            END LOOP;

        -- Вставляем данные книги в таблицу
        INSERT INTO books (inner_text)
        VALUES (book_text);
    END $$;
