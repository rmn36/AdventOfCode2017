#!/usr/bin/env ruby
require 'set'

set = Set.new []
f = File.read("input.txt").split("\t").map(&:to_i)
set.add(f.join(','))

old_size = set.size
new_size = old_size
counter = 0
begin
    val = f.max
    indx = f.index(val)
    f[indx] = 0

    while val != 0
        indx += 1
        if indx >= f.length 
            indx = indx - f.length
        end
        f[indx] += 1
        val -= 1
    end

    set.add(f.join(','))
    old_size = new_size
    new_size = set.size
    counter+= 1

end while old_size != new_size

puts counter