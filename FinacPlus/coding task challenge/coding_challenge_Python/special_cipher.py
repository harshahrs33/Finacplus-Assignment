def caesar_cipher(text, shift):
    result = ''
    for char in text:
        if char.isalpha():
            start = ord('A') if char.isupper() else ord('a')
            result += chr(start + (ord(char) - start + shift) % 26)
        else:
            result += char
    return result

def run_length_encode(text):
    if not text:
        return ''
    
    encoded_text = ''
    prev_char = text[0]
    count = 1
    
    for char in text[1:]:
        if char == prev_char:
            count += 1
        else:
            encoded_text += prev_char + (str(count) if count > 1 else '')
            prev_char = char
            count = 1
    
    encoded_text += prev_char + (str(count) if count > 1 else '')
    return encoded_text

def special_cipher(text, shift):
    # Step 1: Apply Caesar's cipher
    caesar_text = caesar_cipher(text, shift)
    
    # Step 2: Apply RLE
    encoded_text = run_length_encode(caesar_text)
    
    return encoded_text

# Test the function
s=input("Enter the String : ")
k=int(input("Enter the key : "))
print("The Special cipher is : ",special_cipher(s,k))




