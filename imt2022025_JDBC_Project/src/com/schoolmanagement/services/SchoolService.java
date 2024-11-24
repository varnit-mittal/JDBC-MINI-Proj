package com.schoolmanagement.services;

import com.schoolmanagement.dao.*;
import com.schoolmanagement.models.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SchoolService {

    private final StudentDAO studentDAO;
    private final TeacherDAO teacherDAO;
    private final CourseDAO courseDAO;
    private final BookDAO bookDAO;
    private final LibraryDAO libraryDAO;
    private ResultSet rs;

    public SchoolService(Connection connection) {
        this.studentDAO = new StudentDAO(connection);
        this.teacherDAO = new TeacherDAO(connection);
        this.courseDAO = new CourseDAO(connection);
        this.bookDAO = new BookDAO(connection);
        this.libraryDAO = new LibraryDAO(connection);
    }

    // Student Management Methods
    public void addStudent(Student student) throws SQLException {
        studentDAO.create(student);
        System.out.println("Student added: " + student.getName());
    }

    public Student getStudentById(int id) throws SQLException {
        return studentDAO.read(id);
    }

    public void getAllStudents() throws SQLException {
        List<Student> st = studentDAO.mapResultSetToList(rs);
        st.forEach(student -> System.out.println(student));
    }

    public void updateStudent(Student student) throws SQLException {
        studentDAO.update(student);
        System.out.println("Student updated: " + student.getName());
    }

    public void deleteStudent(int id) throws SQLException {
        studentDAO.delete(id);
        System.out.println("Student deleted with ID: " + id);
    }

    // Teacher Management Methods
    public void addTeacher(Teacher teacher) throws SQLException {
        teacherDAO.create(teacher);
        System.out.println("Teacher added: " + teacher.getName());
    }

    public Teacher getTeacherById(int id) throws SQLException {
        return teacherDAO.read(id);
    }

    public void getAllTeachers() throws SQLException {
        List<Teacher> t =  teacherDAO.mapResultSetToList(rs);
        t.forEach(teacher -> System.out.println(teacher));
    }

    public void updateTeacher(Teacher teacher) throws SQLException {
        teacherDAO.update(teacher);
        System.out.println("Teacher updated: " + teacher.getName());
    }

    public void deleteTeacher(int id) throws SQLException {
        teacherDAO.delete(id);
        System.out.println("Teacher deleted with ID: " + id);
    }

    // Course Management Methods
    public void addCourse(Course course) throws SQLException {
        courseDAO.create(course);
        System.out.println("Course added: " + course.getCourseName());
    }

    public Course getCourseById(int id) throws SQLException {
        return courseDAO.read(id);
    }

    public void getAllCourses() throws SQLException {
        List<Course> cs = courseDAO.mapResultSetToList(rs);
        cs.forEach(course -> System.out.println(course));
    }

    public void updateCourse(Course course) throws SQLException {
        courseDAO.update(course);
        System.out.println("Course updated: " + course.getCourseName());
    }

    public void deleteCourse(int id) throws SQLException {
        courseDAO.delete(id);
        System.out.println("Course deleted with ID: " + id);
    }

    // Library and Book Management Methods
    public void addBook(Book book) throws SQLException {
        bookDAO.create(book);
        System.out.println(book);
    }

    public Book getBookById(int id) throws SQLException {
        return bookDAO.read(id);
    }

    public void getAllBooks() throws SQLException {
        List<Book>  b= bookDAO.mapResultSetToList(rs);
        b.forEach(book -> System.out.println(book));
    }

    public void updateBook(Book book) throws SQLException {
        bookDAO.update(book);
        System.out.println("Book updated: " + book.getTitle());
    }

    public void deleteBook(int id) throws SQLException {
        bookDAO.delete(id);
        System.out.println("Book deleted with ID: " + id);
    }

    public void addLibrary(Library library) throws SQLException {
        libraryDAO.create(library);
        System.out.println(library);
    }

    public Library getLibraryById(int id) throws SQLException {
        return libraryDAO.read(id);
    }

    public void updateLibrary(Library library) throws SQLException {
        libraryDAO.update(library);
        System.out.println("Library updated: " + library.getName());
    }

    public void deleteLibrary(int id) throws SQLException {
        libraryDAO.delete(id);
        System.out.println("Library deleted with ID: " + id);
    }

    public void updateCGPA(int studentId, float newCGPA) {
        studentDAO.updateCGPA(studentId, newCGPA);
    }

    public void incrementSalary(int teacherId, float incrementAmount) {
        teacherDAO.incrementSalary(teacherId, incrementAmount);
    }

    public void markBookWithCourse(int bookId, int courseId) {
        bookDAO.markBookWithCourse(bookId, courseId);
    }

    public void getTopper() {
        Student st = studentDAO.getTopper();
        System.out.println(st);
    }

    public void getHighestPaidTeacher() {
        Teacher th = teacherDAO.getHighestPaidTeacher();
        System.out.println(th);
    }

    public void getCourseBooks(int courseId) {
        List<Book> books = bookDAO.getBooksForCourse(courseId);
        books.forEach(book -> System.out.println(book));
    }

    public void unmarkBookWithCourse(int bookId, int courseId) {
        bookDAO.unmarkBookWithCourse(bookId, courseId);
    }

    public void addStudentToCourse(int studentId, int courseId) {
        studentDAO.addStudentToCourse(studentId, courseId);
    }

    public void removeStudentFromCourse(int studentId, int courseId) {
        studentDAO.removeStudentFromCourse(studentId, courseId);
    }

    public void getStudentbooks(int studentId) {
        List<Book> books = studentDAO.getBooksforStudents(studentId);
        books.forEach(book -> System.out.println(book));
    }
}
