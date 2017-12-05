#!/usr/bin/env python

with open('input.txt') as f:
    content = [int(x) for x in f.readlines()]

counter = 0
index = 0
while index < len(content):
    offset = content[index]
    content[index] += 1
    index += offset
    counter += 1

print counter