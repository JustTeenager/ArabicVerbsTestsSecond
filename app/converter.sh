#!/bin/sh

for f in $(find . -name '*.mp3')
do 
    f_n="${f%.*}"
    lame --mp3input -b 48 $f $f_n.temp
    rm $f
done

for f in $(find . -name '*.temp')
do 
    f_n="${f%.*}"
    mv $f $f_n.mp3
done

# for d in $(find . -maxdepth 2 -type d)
# do
#   #Do something, the directory is accessible with $d:
#   echo $d
# done