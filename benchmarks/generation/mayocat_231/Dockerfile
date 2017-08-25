# Dockerfile
FROM ubuntu:trusty

RUN groupadd -r postgres --gid=999 && useradd -r -g postgres --uid=999 postgres

RUN apt-get update && apt-get install -y --no-install-recommends ca-certificates wget git maven openjdk-7-jdk

RUN git clone https://github.com/mayocat/mayocat-shop && \
    cd mayocat-shop && \
    git checkout fb28b82 

RUN cd mayocat-shop/shop/application && \
    cp mayocat.yml.example mayocat.yml

RUN cd mayocat-shop && \
    mvn install

RUN echo 'deb http://httpredir.debian.org/debian jessie-backports main' >> /etc/apt/sources.list.d/jessie-backports.list
RUN echo "deb http://apt.postgresql.org/pub/repos/apt/ trusty-pgdg main" >> /etc/apt/sources.list.d/pgdg.list
RUN wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add -

RUN gpg --keyserver pgpkeys.mit.edu --recv-key 8B48AD6246925553
RUN gpg -a --export 8B48AD6246925553 | sudo apt-key add -

RUN apt-get update

RUN apt-get -y --no-install-recommends install \
                    postgresql postgresql-contrib postgresql-common \
                    maven

ENV GOSU_VERSION 1.9
RUN set -x \
    && apt-get update && apt-get install -y --no-install-recommends ca-certificates wget && rm -rf /var/lib/apt/lists/* \
    && dpkgArch="$(dpkg --print-architecture | awk -F- '{ print $NF }')" \
    && wget -O /usr/local/bin/gosu "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$dpkgArch" \
    && wget -O /usr/local/bin/gosu.asc "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$dpkgArch.asc" \
    && export GNUPGHOME="$(mktemp -d)" \
    && gpg --keyserver ha.pool.sks-keyservers.net --recv-keys B42F6819007F00F88E364FD4036A9C25BF357DD4 \
    && gpg --batch --verify /usr/local/bin/gosu.asc /usr/local/bin/gosu \
    && rm -r "$GNUPGHOME" /usr/local/bin/gosu.asc \
    && chmod +x /usr/local/bin/gosu \
    && gosu nobody true 


ENV PG_MAJOR 9.6

RUN echo 'deb http://apt.postgresql.org/pub/repos/apt/ jessie-pgdg main' $PG_MAJOR > /etc/apt/sources.list.d/pgdg.list

RUN mkdir -p /var/run/postgresql && chown -R postgres /var/run/postgresql

ENV PATH /usr/lib/postgresql/$PG_MAJOR/bin:$PATH
ENV PGDATA /var/lib/postgresql/data

RUN mkdir -p /var/lib/postgresql/data 
RUN chmod 777 /var/lib/postgresql/data 
RUN chown -R postgres /var/lib/postgresql/data 
RUN chmod 777 /run/postgresql 
RUN chown -R postgres /run/postgresql

RUN gosu postgres initdb

# RUN gosu postgres pg_ctl -D /var/lib/postgresql/data  start &

# RUN echo "server.host = `ifconfig docker0 | grep -Eo 'inet (addr:)?([0-9]*\.){3}[0-9]*' | grep -Eo '([0-9]*\.){3}[0-9]*' | grep -v '127.0.0.1'`" >  mayocat-shop/shop/application/config.ini

RUN apt-get -qq update && apt-get -qq -y install curl

RUN gosu postgres pg_ctl -D /var/lib/postgresql/data start  > /dev/null && \
    sleep 1 && \
    gosu postgres psql -c "create database shop;" && \
    cd mayocat-shop/shop/application && \
    ./migrate.sh

RUN mkdir /docker-entrypoint-initdb.d
COPY entrypoint.sh /
COPY mayocat.yml mayocat-shop/shop/application/
COPY startup_development.sh mayocat-shop/shop/application/startup_development.sh
ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 8080
EXPOSE 8081
EXPOSE 5005