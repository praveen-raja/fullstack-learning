class Student {
    studentName: string;
    studentRank: number;
    studentMarks: number;

    constructor(studentName: string, studentRank: number, studentMarks: number) 
    {
        this.studentName = studentName;
        this.studentRank = studentRank;
        this.studentMarks = studentMarks;
    }

    getStudentGrade(): string 
    {
        if(this.studentMarks >=80)
        {
            return "A";
        }
        else if(this.studentMarks >= 70 && this.studentMarks < 80)
        {
            return "B";
        }
        else if(this.studentMarks >= 60 && this.studentMarks < 70)
        {
            return "C";
        }
        else if(this.studentMarks >= 50 && this.studentMarks < 60)
        {
            return "D";
        }
        else
        {
            return "F";
        }
    }
}

let praveen = new Student("Praveen", 4, 70 );
praveen.studentMarks = 50;

console.log(praveen.getStudentGrade());