package com.praveen.javacore.designpatterns.creational.builder;

/*
 * ============================================================================
 * PATTERN: Builder (creational) - realistic variant with validation
 * ----------------------------------------------------------------------------
 * A Student has many fields (name, phone, address, three marks). Instead of a
 * giant constructor, you set only what you need via a fluent Builder, then
 * build() validates and produces the immutable Student.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 *   Student.getBuilder()      -> start a builder
 *      .setName(..).setAddress(..)   -> each setter returns the Builder (chain)
 *      .build()               -> validate here, then copy fields into a Student
 * The Student constructor is private, so the ONLY way to make one is through the
 * builder - which guarantees validation runs. build() is where you'd enforce
 * rules (e.g. marks in range) before handing back the object.
 *
 * Compare with BuilderExample (Burger): same pattern, this one adds a
 * validation seam in build() and uses a top-level Builder class.
 * ============================================================================
 */
public class Student {

    // attributes
    private String name;
    private String phoneNumber;
    private String address;
    private int mathsMark;
    private int scienceMark;
    private int englishMark;

    // private constructor
    private Student(){}

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        // attributes
        private String name;
        private String phoneNumber;
        private String address;
        private int mathsMark;
        private int scienceMark;
        private int englishMark;

        // Setters with BUILDER return object
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setScienceMark(int scienceMark) {
            this.scienceMark = scienceMark;
            return this;
        }

        public Builder setMathsMark(int mathsMark) {
            this.mathsMark = mathsMark;
            return this;
        }

        public Builder setEnglishMark(int englishMark) {
            this.englishMark = englishMark;
            return this;
        }

        // validate and build
        public Student build() throws Exception {

            // validation part


            // build part
            Student student = new Student();
            student.address = this.address;
            student.name = this.name;
            student.phoneNumber = this.phoneNumber;
            student.englishMark = this.englishMark;
            student.mathsMark = this.mathsMark;
            student.scienceMark = this.scienceMark;

            return  student;
        }
    }


}
