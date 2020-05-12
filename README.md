# Hadoop HDFS

## Using with Docker

### Guide

[https://clubhouse.io/developer-how-to/how-to-set-up-a-hadoop-cluster-in-docker/](https://clubhouse.io/developer-how-to/how-to-set-up-a-hadoop-cluster-in-docker/)

* Docker
* Docker Machine [https://docs.docker.com/machine/overview/](https://docs.docker.com/machine/overview/)
* Clone the repo `git clone https://github.com/big-data-europe/docker-hadoop.git`
* Start `docker-compose up -d`
* Access [http://localhost:9870](http://localhost:9870)

* Accessing bash: `docker exec -it namenode bash`
* Send file to docker container: `docker cp <file> container-name:/<dir>/<file>`

## Actions in HDFS

* **hdfs dfs -**[command]
* Create a file: `hdfs dfs -touchz /user/root/input/sample.txt`
* Read file: `hdfs dfs -cat <file>`
* Create directory: `-mkdir`
* Copy: `-cp`
* Move: `-mv`

## Permissions

* Change mode: **hdfs dfs -chmod** [num] /directory
* Change mode recursive: **hdfs dfs -chmod -R** [num] /directory
* Change group: **hdfs dfs -chgrp** [group]/directory
* Change owner: **hdfs dfs -chown** [owner] /directory
* Change owner recursive: **hdfs dfs -chown -R** [owner] /directory

## Moving Data

* Send local file to HDFS: `hdfs dfs -put /tmp/<file> <file>`
* Send local file to HDFS and delete the origin: `hdfs dfs -moveFromLocal /tmp/<file> <file>`
* Get HDFS file to local: `hdfs dfs -get <file> /tmp/<file>`

## Maintenance Commands

* Delete complete (empty trash): `hdfs dfs -expunge <file>`
