//문제: 동물원 관리 시스템
//문제 설명:
//당신은 동물원 관리 시스템을 만드는 중입니다.
//각 동물은 이름, 나이, 종(species) 등의 정보를 가지고 있으며, 동물원에 있는 동물들의 정보를 관리하고,
//특정 조건에 따라 동물을 찾거나, 나이를 계산하는 기능을 구현하려고 합니다.

class Animal(var name : String, var age : Int, var species : String){
    fun aniInfo():String{
    //toString는 탑재된 매서드라 override toString():String{ 이렇게만 해도 자동으로 호출됌
    //내가 만든 aniInfo는 println을 하면 해시코드가 출력됌
        return "이름 : ${name}, 나이 : ${age}, 종족 : ${species}"
    }
}
var dog = Animal("시고르잡종",2,"개")
println(dog) // 그냥 클래스랑 해시코드가 출력됌
println(dog.aniInfo()) //toString 안쓸꺼면 이렇게 해야댐

//동물 데이터를 가진 배열or리스트를 만들어라 ->자체를 변수로 선언
var animals = mutableListOf(
    Animal("백구",5,"개"),
    Animal("푸바오",7,"판다"),
    Animal("아이바오",3,"판다"),
    Animal("루피",2,"비버"),
    Animal("누룽지",7,"개"),
    Animal("두부",12,"개")
    //var animal6 = Animal("두부",12,"개")처럼 변수 선언이 아닌 바로 인스턴스를 나열
)
fun categoryAge(){ //나이를 기준으로 해당 리스트에서 동물들을 추출할꺼야-> filter함수 활용
    //when(Animal.age){}이렇게 쓰면 안됌 생각한후 타이핑할것, Animal class의 객체로 받는 animal의 나이니까
    var babys = animals.filter{it.age <= 3}
    var children = animals.filter{it.age <= 5 && it.age > 3}
    var adults = animals.filter{it.age > 5}

    for(baby in babys){
        println("========애기인 동물들===========")
        println(baby.name)
    }
    for(child in children){
        println("========자라는 동물들===========")
        println(child.name)
    }
    for(audult in adults){
        println("========어른 동물들===========")
        println(audult.name)
    }
}
categoryAge()

fun passOneYear(){//1년이 지나면 나이가 하나씩 늘어남. Animal을 클래스로 갖는 객체 animal
    println("1년이 지났습닌다")
//    for(animal in animals){
//        animal.age += 1
//        println("${animal.name} 나이가 ${animal.age}살이 되었습니다.")
        //이렇게 만들면 1년씩 출력은 되지만 기존 리스트의 값은 수정되지않음
    //for문으로 기존 리스트 값들을 가져오면서 새로운 리스트 변수를 선언해준다
    for (animal in animals) {
        var newAnimals = Animal(animal.name, animal.age + 1, animal.species)
        println("이름 : ${newAnimals.name}, 나이 : ${newAnimals.age} , 종족 : ${newAnimals.species}")
    }
}
for (animal in animals) {//기존 리스트들의 값
    println(animal.aniInfo())
}
passOneYear()


//동물들의 평균 나이를 입력 받으려고 한다
//꺽새 안에 Int,String등을 적는다
//클래스나 매서드,프로퍼티를 정의할때 데이터타입을 변수로 지정하고 사용할때 타입을 Type 파라미터로 정의
//

fun averageAge(animalList : List<Animal>):Double{
    var totalAge = animalList.map{it.age}.sum()
    return totalAge.toDouble()/animalList.size
}
averageAge(animals)
// 1년이 지났을때의 평균 나이를
// ???
"""질문 사항 : 동물들의 리스트를 만들고 1년이 지났을때 나이의 평균을 구하고 싶습니다
    전역변수로 선언되었던 기존 animals라는 리스트는 평균을 구할수가있는데
    passOneYear함수를 통해서 1년을 지난 나이의 평균은 어떻게..? """

