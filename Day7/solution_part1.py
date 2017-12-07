#!/usr/bin/env python



with open('input.txt') as f:
    content = [x.strip().split('-> ') for x in f.readlines()]
d = {}
for y in content:
    if len(y) == 2:
        d[y[0].strip()] = [z.strip() for z in y[1].split(',')]
    else:
        d[y[0].strip()] = []

non_leafs = [k for k in d.keys() if d[k] != []]
node_names = [k.split()[0] for k in non_leafs]

count = 0
for n in node_names:
    for key in d.keys():
        if n in d[key]:
            count += 1
        else:
            pass
    if count > 0:
        count = 0
    else:
        print n

