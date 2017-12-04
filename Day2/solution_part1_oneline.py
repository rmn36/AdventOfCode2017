#!/usr/bin/env python
print sum([int(x[(len(x)-1)])-int(x[0]) for x in [sorted(x, key=int) for x in [x.split("\t") for x in [x.strip('\n') for x in open('input.txt').readlines()]]]])
