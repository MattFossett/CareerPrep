#!/bin/sh

# This odd script was used to quickly make large files which were used to test 
#   other projects. This can produce a GB of simple data pretty quickly. 
# @MattFossett

echo "." > large.txt

for ((i=0; i<30; i++))
do
  value=$(<large.txt)
  echo $value  > large.txt
  echo $i
done
