FROM postgres

ENV POSTGRES_USER journaldb
ENV POSTGRES_PASSWORD password
ADD *.sql /docker-entrypoint-initdb.d
EXPOSE 5432