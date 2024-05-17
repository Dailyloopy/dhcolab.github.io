//예제 문제 : 도서관리 시스템
//문제 설명:
//도서 관리 시스템을 작성하세요.
// 이 시스템은 책(Book), 도서관(Library) 및 회원(Member)을 포함합니다.
// 다음의 요구사항을 만족하는 프로그램을 작성하세요.

class Book(var title: String, var autor: String, var year: Int) {
    //    fun info(){
//        println("${title}책은 ${autor}이 ${year}년도에 썼습니다.")
//    }// info 함수를 쓰면 책의 정보를 출력한다. -> 나중에 list를 출력할때 주소값이 출력이됌
    fun info(): String {
        return "${title}책은 ${autor}이 ${year}년도에 썼습니다."
    }
}//어짜피 문자출력이니까 info를 string으로 받아 return 하는 방법이 더 효율적

class Library(var name: String) {
    var books = mutableListOf<Book>()//listOf할때 <Book>()
//mutableListOf<String,Int>(함수호출)
//val mixedList = mutableListOf<Any>("Alice", 1, 2.5, true)
//println(mixedList) // 출력: [Alice, 1, 2.5, true] 이런식으로 사용

    fun addBook(book: Book) {//DataType에 class자체가 되는것도 가능
        books.add(book) //books라는 리스트에 .add를 진행
        println("${book.title}이 추가되었습니다")
        for (it in books) {
            print("${it.title},")
        }
        println()
        println("=====")
//        println(listBooks())
    }

    fun removeBook(title: String) { //책의 제목으로 검색해서 리스트에서 책을 제거
        //books.remove(book) //무슨 book을 지울지 모르겠다. title로 찾아야댐
        books.removeIf { it.title == title } //it은 리스트안에서 변수를 하나씩 확인해줌
        //        val book = books.find { it.title == title }
        for (it in books) { // it은 book이랑 다름이 없음
            if (title == it.title) {
                books.remove(it)
                println("책을 지웠습니다.")
            } else {
                println("해당 책이 없습니다.")
            }
        }
//        if (book != null) {
////        if(title == book.title){
//            books.remove(book)
//            println("책을 지웠습니다.")
//        }else{
//            println("해당 책이 없습니다.")
//        }
    }
}

class Member(firstName: String) {
    var borrowedBooks = mutableListOf<Book>()

    fun borrowBook(library: Library, title: String) {
        println("======borrowBook========")
        for (book in library.books) { // it은 mutableListOf<Book>()에 있는 Book
            if (title == book.title) { // 책이 있으면 리스트에 넣고 제목 출력
                borrowedBooks.add(0, book)//항상 0번 인덱스에 추가하고
                println("${book.title},")
                println("==============")
            }
        }
        library.books.remove(borrowedBooks[0])//항상 0번 인덱스인 항목을 삭제함
        println("=========빌린책 제외한 library 목록========")
        for (book in library.books) { // 빌린책이 삭제된 library목록을 출력함
            print(book.title + ", ")
        }
    }
    // For문돌고있는 list에서 수정이 들어가면 멈추거나 무한 루프에 빠진다.
    //println(library.books)

//        if(library.books == title){
//        borrowedBooks.add(Library에 있는 book)
//        //Library의 책은 제거되어야함

    fun returnBook(library: Library, title: String) {
        for (book in borrowedBooks) {
            if (title == book.title) {
                borrowedBooks.remove(book)
                library.books.add(book)
                println(borrowedBooks)
                println("=========빌린책 제외한 library 목록========")
                println(library.books)
            }
        }
    }
}

val library = Library("Guro")
val book1 = Book("intel", autor = "JaeCook", 2021)
val book2 = Book("GonuI", autor = "KHW", 1956)
val book3 = Book("AIGo", autor = "EOMDH", 1999)
val book4 = Book("FiveGuys", autor = "HaSS", 1875)
//도서관 책 추가
library.addBook(book1)
library.addBook(book2)
library.addBook(book3)
library.addBook(book4)


// 도서관의 책 목록 출력
println("\nBooks in the library:")
println(book1.info())
println(book2.info())
println(book3.info())
println(book4.info())

println("//회원 생성 및 책 대출")
//회원 생성 및 책 대출
val member = Member("person1")

member.borrowBook(library, "intel")
//member.borrowBook(library,"GoGo")//없는 책은 목록에 없음
//빌린 책 출력 이후 도서관에 남아있는 책 리스트 보여줌

