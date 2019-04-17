#!/bin/bash

ps -ef |grep monitor.jar |awk '{print $2}'|xargs kill -9
nohup java -jar -Dspring.profiles.active=prod Ccg-Spider-Analysis-Cert-1.0-SNAPSHOT.jar  >/dev/null 2>&1&