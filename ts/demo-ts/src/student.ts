
type gender = 'Male' | 'Female'

enum Gender {
    MALE, FEMALE
}

class Point {

    private _x:number
    private _y:number

    get X() { return this._x}

    get Y() {return this._y}

    set X(x: number) {this._x = x}

    set Y(y: number) {this._y = y}
}

class Student{
   
    private _name:string
    private _age:number
    private _marks:number
    private _topics:string[]
    private _sex:Gender

    constructor(){}

    get name():string{
        return this._name
    }

    get age():number{
        return this._age
    }

    get marks():number{
        return this._marks
    }

    get topics():string[]{
        return this._topics
    }

    set name(name:string){
        this._name=name
    }

    set age(age:number){
        this._age=age
    }

    set marks(marks:number){
        this._marks=marks
    }

    set topics(topics:string[]){
        this._topics=topics
    }

    public display(): void{
        console.log(`${this._name} is of age ${this._age} and has ${this._marks} marks in ${this._topics.join(", ")}`)
    }
}