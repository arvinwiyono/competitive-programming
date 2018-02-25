def howManyStudents(m, c)
	counters = Array.new(m) { 0 }
	c.each{ |class_index| counters[class_index] += 1 }
	counters
end

def howManyStudentsInject(m, c)
	c.inject(Array.new(m) { 0 }){ |memo, class_index| memo[class_index] += 1; memo }
end

num_student, num_class = gets.chomp.split.map(&:to_i)
classes = [0] * num_class
votes = gets.chomp.split.map(&:to_i)

result = howManyStudents(num_class, votes)
puts result.join(' ')

result = howManyStudentsInject(num_class, votes)
puts result.join(' ')