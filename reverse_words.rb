#
# Your last C# code is saved below:
#

# My name is Vedant => Vedant is name My
# ["M", "y", " ", "n", "a", "m", "e", " ", "i", "s", " ", "V", "e", "d", "a", "n", "t"] =>
# ["V", "e", "d", "a", "n", "t", " ", "i", "s", " ", "n", "a", "m", "e", " ", "M", "y"]

def reverse(chars)
    reverse_array chars
    i = 0
    while i < chars.length do
        left = i
        while chars[i] != ' ' && i < chars.length do
            i += 1
        end
        right = i - 1
        reverse_array chars, left, right
        i += 1
    end
    chars
end

def reverse_array(chars, left = 0, right = chars.length - 1)
    while left < right do
        chars[left], chars[right] = chars[right], chars[left]
        left += 1
        right -= 1
    end
    chars
end


puts reverse ["M", "y", " ", "n", "a", "m", "e", " ", "i", "s", " ", "V", "e", "d", "a", "n", "t"]


# tnadeV si eman yM
