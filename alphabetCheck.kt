fun countAlphabet(word: String): Int {
//    var alphabet = mutableSetOf<String>()
//    for(value in word){ //value = Char
//        alphabet.add(value.toString())
//    }
//    answer = alphabet.size

    var alphabet = mutableListOf<Char>()
    var word = loCaCha(word = word)
    for (value in word) {

        if (value.lowercaseChar() !in alphabet) {
            alphabet.add(value.lowercaseChar())
        }
    }

//    var filteredList = mutableListOf<Char>()
//    for(i in 0..alphabet.size-2){
//        for(j in i+1..alphabet.size-1){
//            if(lowerAlpha.indexOf(alphabet[i]) != upperAlpha.indexOf(alphabet[j])){
//                filteredList.add(alphabet[i])
//            }
//        }
//
//    }


    return alphabet.size
}


countAlphabet("apple")
countAlphabet("banana")
countAlphabet("banaNA")
countAlphabet("BANANA")


var littleAlpha = mutableListOf('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')
var bigAlpha =     mutableListOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')

fun loCaCha(word : String):String{
    var index : Int
    var newWord = mutableListOf<Char>()
    for(value in word){ //B가 나오면
        for(i in 0..25){
            if(value == bigAlpha[i]){
                newWord.add(littleAlpha[i])
            }else if ( value == littleAlpha[i]){
                newWord.add(littleAlpha[i])
            }
        }
    }

    return newWord.joinToString("")
}
loCaCha("BanaNa")
