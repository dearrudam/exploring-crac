#!/bin/bash

# Enable checkpoint compression (will reduce restore time a bit)
#export CRAC_CRIU_OPTS=--compress

java -XX:CRaCCheckpointTo=./tmp_manual_checkpoint -jar spring-crac/target/spring-crac-*.jar
