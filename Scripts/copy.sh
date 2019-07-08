#!/bin/bash

# This script takes a filename and a destination and if present will
#   move the file over to the destination path. Note this is not a copy but a full move.  
# Example use: Instead of manually copying over a file that has to be 
#   constantly downloaded, this script will move the file to the desired location. 
# @MattFossett

FILE="filename.xml"
DEST="/Users/example/directory"

while :
do
  if test -f "$FILE"; then
    echo "moving $FILE"
    cp $FILE $DEST
    rm $FILE
  fi
  sleep 10
done

