var Gender;
(function (Gender) {
    Gender[Gender["MALE"] = 0] = "MALE";
    Gender[Gender["FEMALE"] = 1] = "FEMALE";
})(Gender || (Gender = {}));
class Point {
    get X() { return this._x; }
    get Y() { return this._y; }
    set X(x) { this._x = x; }
    set Y(y) { this._y = y; }
}
class Student {
    constructor() { }
    get name() {
        return this._name;
    }
    get age() {
        return this._age;
    }
    get marks() {
        return this._marks;
    }
    get topics() {
        return this._topics;
    }
    set name(name) {
        this._name = name;
    }
    set age(age) {
        this._age = age;
    }
    set marks(marks) {
        this._marks = marks;
    }
    set topics(topics) {
        this._topics = topics;
    }
    display() {
        console.log(`${this._name} is of age ${this._age} and has ${this._marks} marks in ${this._topics.join(", ")}`);
    }
}
