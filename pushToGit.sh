#!/bin/bash
msg="$1"
git add *
git commit -m ${msg}
git push -u origin master
