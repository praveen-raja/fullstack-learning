var Student = /** @class */ (function () {
    function Student(studentName, studentRank, studentMarks) {
        this.studentName = studentName;
        this.studentRank = studentRank;
        this.studentMarks = studentMarks;
    }
    Student.prototype.getStudentGrade = function () {
        if (this.studentMarks >= 80) {
            return "A";
        }
        else if (this.studentMarks >= 70 && this.studentMarks < 80) {
            return "B";
        }
        else if (this.studentMarks >= 60 && this.studentMarks < 70) {
            return "C";
        }
        else if (this.studentMarks >= 50 && this.studentMarks < 60) {
            return "D";
        }
        else {
            return "F";
        }
    };
    return Student;
}());
var praveen = new Student("Praveen", 4, 70);
praveen.studentMarks = 50;
console.log(praveen.getStudentGrade());
