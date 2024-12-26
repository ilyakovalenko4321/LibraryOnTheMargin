-- Использование UUID для уникальных идентификаторов
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Таблица пользователей
CREATE TABLE IF NOT EXISTS users
(
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(1024) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица для книг
CREATE TABLE IF NOT EXISTS books
(
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    inner_text TEXT, -- Для хранения основного текста книги
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица для заметок
CREATE TABLE IF NOT EXISTS notes
(
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    book_id UUID NOT NULL,
    note_header VARCHAR(255) NOT NULL,
    note_text TEXT NOT NULL,
    start_offset INT, -- Номер начального символа фрагмента текста
    end_offset INT,   -- Номер конечного символа фрагмента текста
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_notes_book FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE NO ACTION ON UPDATE NO ACTION ,
    CONSTRAINT chk_offset_valid CHECK (start_offset <= end_offset) -- Проверка корректности диапазона
);


-- Таблица для связи пользователей и заметок
CREATE TABLE IF NOT EXISTS users_notes
(
    user_id UUID NOT NULL,
    note_id UUID NOT NULL,
    permissions VARCHAR(50) DEFAULT 'owner', -- owner, editor, viewer
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, note_id),
    CONSTRAINT fk_users_notes_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE NO ACTION ,
    CONSTRAINT fk_users_notes_notes FOREIGN KEY (note_id) REFERENCES notes(id) ON DELETE CASCADE ON UPDATE NO ACTION
);

-- Индексы для улучшения производительности
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_notes_book_id ON notes(book_id);
CREATE INDEX idx_users_notes_user_id ON users_notes(user_id);
CREATE INDEX idx_users_notes_note_id ON users_notes(note_id);
