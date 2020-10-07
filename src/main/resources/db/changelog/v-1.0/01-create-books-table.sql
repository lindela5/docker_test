CREATE TABLE books (
  id         SERIAL,
  title       TEXT,
  author      TEXT,

  PRIMARY KEY (id)
);
GO

INSERT INTO public.books (
  id, title, author)
VALUES (1, 'Madol Duwa', 'Martin Wickramasinghe'),
  (2, 'Gamperaliya', 'Martin Wickramasinghe');


GO