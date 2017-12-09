#!/usr/bin/env python
class Tree(object):
    "Generic tree node."
    def __init__(self, name='root', children=None, weight=0):
        self.name = name
        self.weight=weight
        self.children = []
        if children is not None:
            for child in children:
                self.add_child(child)
    def __repr__(self):
        return self.name
    def add_child(self, node):
        assert isinstance(node, Tree)
        self.children.append(node)

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
        print n #part 1 solution

