#!/bin/bash
# Raj's First Bash Script
# This scripts prompts for a name and writes it to a file
# Then it copies the file, so there will be 2 files
clear
echo "Hello Dude"
read -p "Please enter your name:" name
echo "$name" >> names.txt
cp names.txt names2.txt
echo "Hello $name, I have written your name to 2 files"
echo "=================================================="
cat names.txt
echo "=================================================="

