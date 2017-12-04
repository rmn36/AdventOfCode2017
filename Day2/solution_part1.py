#!/usr/bin/env python

with open('input.txt') as f:
    content = [x.strip('\n') for x in f.readlines()]
sorted_lists = [sorted(x, key=int) for x in [x.split("\t") for x in content]]
summed = sum([int(x[(len(x)-1)])-int(x[0]) for x in sorted_lists])
print summed