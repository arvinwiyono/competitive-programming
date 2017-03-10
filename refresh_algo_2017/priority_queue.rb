# from http://www.brianstorti.com/implementing-a-priority-queue-in-ruby/

class Element
    include Comparable

    attr_accessor :priority
    def initialize(name, priority)
        @name = name
        @priority = priority
    end

    def <=>(other)
        @priority <=> other.priority
    end

    def to_s
        "#{@name} - #{@priority}"
    end
end

class PriorityQueue
    def initialize()
        @bin_array = [nil]
    end

    def <<(element)
        @bin_array << element
        bubble_up(@bin_array.length-1)
        puts @bin_array.inspect
    end

    def bubble_up(index)
        parent_index = index / 2
        stop = false
        while(!@bin_array[parent_index].nil? && !stop) do
            current = @bin_array[index]
            parent = @bin_array[parent_index]
            if current < parent
                # do the swap
                @bin_array[index], @bin_array[parent_index] = @bin_array[parent_index], @bin_array[index]
                index = parent_index
                parent_index = index / 2
            else
                stop = true
            end
        end
    end

    def pop
        if @bin_array.length > 1
            @bin_array[1], @bin_array[-1] = @bin_array[-1], @bin_array[1]
            result = @bin_array.pop
            bubble_down(1)
            puts @bin_array.inspect
            result
        else
            false
        end
    end

    def bubble_down(index)
        is_last_child = @bin_array.length <= 2 ? true : false
        stop = false
        while(!is_last_child && !stop) do
            puts @bin_array.inspect
            lc_index = index * 2
            rc_index = lc_index + 1

            left_child = @bin_array[lc_index]
            right_child = @bin_array[rc_index]

            has_left = !left_child.nil?
            has_right = !right_child.nil?

            current = @bin_array[index]

            if has_left && has_right
                if left_child <= right_child && left_child < current
                    selected = lc_index
                elsif right_child < left_child && right_child < current
                    selected = rc_index
                else
                    # both children are greater than current
                    stop = true
                end
            elsif has_left && !has_right
                if left_child < current
                    selected = lc_index
                else
                    stop = true
                end
            end
            # do the swap if finds nominated child
            if !stop
                @bin_array[index], @bin_array[selected] = @bin_array[selected], @bin_array[index]
                index = selected
                is_last_child = @bin_array[index*2].nil? && @bin_array[index*2 + 1].nil?
            end
        end
    end

    alias_method 'push', '<<'
end

def test_case_2
    pq = PriorityQueue.new
    5.downto(1).each do |p|
        pq.push p
    end
    puts pq.pop
    puts pq.pop
    puts pq.pop
    puts pq.pop
    puts pq.pop
    puts pq.pop
    pq.push(200)
    pq.push(100)
    pq.push(10)
    puts pq.pop
    puts pq.pop
end

def test_case_1()
    my_array = []
    10.downto(1).each do |i|
        my_array << Element.new("Element##{i}", i)
    end
    my_array.sort!
    my_array.each do |e|
        puts e.to_s
    end
end

test_case_2()
