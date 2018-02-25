#!/bin/bash
echo "compiling $1"
javac $1
SUBSTRING="$(echo $1 | cut -d '.' -f 1)"
echo "sensing input from $SUBSTRING"
java $SUBSTRING