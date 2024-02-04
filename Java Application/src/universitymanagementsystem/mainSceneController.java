/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @Ahmed Ali
 */
public class mainSceneController implements Initializable{
    

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button Dashboard_btn;

    @FXML
    private Button addStudents_btn;

    @FXML
    private Button availableCourse_btn;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private Label home_totalFemale;

    @FXML
    private Label home_totalMale;

    @FXML
    private BarChart<?, ?> home_totalEnrolledChart;

    @FXML
    private AreaChart<?, ?> home_totalFemaleChart;

    @FXML
    private LineChart<?, ?> home_totalMaleChart;

    @FXML
    private AnchorPane addStudents_form;

    @FXML
    private TableView<StudentData> addStudents_tableView;

    @FXML
    private TableColumn<StudentData, String> addStudents_col_studentNum;

    @FXML
    private TableColumn<StudentData, String> addStudents_col_firstName;

    @FXML
    private TableColumn<StudentData, String> addStudents_col_lastName;

    @FXML
    private TableColumn<StudentData, String> addStudents_col_birthdate;

    @FXML
    private TableColumn<StudentData, String> addStudents_col_mob;

    @FXML
    private TableColumn<StudentData, String> addStudents_col_deptID;

    @FXML
    private TextField addStudents_studentNum;

    @FXML
    private TextField addStudents_firstName;

    @FXML
    private TextField addStudents_lastName;

    @FXML
    private DatePicker addStudents_birth;

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private Button addStudents_updateBtn;

    @FXML
    private Button addStudents_deleteBtn;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private TextField addStudents_mob;

    @FXML
    private TextField addStudents_deptID;

    @FXML
    private AnchorPane availableCourse_form;

    @FXML
    private TextField availableCourse_course;

    @FXML
    private TextField availableCourse_description;

    @FXML
    private TextField availableCourse_degree;

    @FXML
    private Button availableCourse_addBtn;

    @FXML
    private Button availableCourse_updateBtn;

    @FXML
    private Button availableCourse_clearBtn;

    @FXML
    private Button availableCourse_deleteBtn;

    @FXML
    private TableView<courseData> availableCourse_tableView;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_course;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_description;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_degree;

    @FXML
    private AnchorPane studentGrade_form;

    @FXML
    private TextField studentGrade_studentID;

    @FXML
    private TextField studentGrade_studentCourseID;

    @FXML
    private TextField studentGrade_Grade;

    @FXML
    private TextField studentGrade_Year;

    @FXML
    private TextField studentGrade_Sem;

    @FXML
    private Button studentGrade_updateBtn;

    @FXML
    private Button studentGrade_clearBtn;

    @FXML
    private TextField studentGrade_studentNum1;

    @FXML
    private TextField studentGrade_studentNum11;

    @FXML
    private TableView<StudentGrades> studentGrade_tableView;

    @FXML
    private TableColumn<StudentGrades , String> studentGrade_col_studentNum;

    @FXML
    private TableColumn<StudentGrades , String> studentGrade_col_CourseID;

    @FXML
    private TableColumn<StudentGrades , String> studentGrade_col_Grade;

    @FXML
    private TableColumn<StudentGrades , String> studentGrade_col_year;

    @FXML
    private TableColumn<StudentGrades , String> studentGrade_col_Sem;
    
    @FXML
    private Button studentGrade_deleteBtn;

    @FXML
    private Button studentGrade_addBtn;
    
    @FXML
    private TableView<studentReport> tab_repo;

    @FXML
    private TableColumn<studentReport, String> repo_col_courseID;

    @FXML
    private TableColumn<studentReport, String> repo_col_courseName;

    @FXML
    private TableColumn<studentReport, String> repo_col_enrolled;

    @FXML
    private TableColumn<studentReport, String> repo_col_avgGPA;
    
    @FXML
    private Button Btn_Depts;
    
    @FXML
    private AnchorPane Dept_form1;

    @FXML
    private TableView<DepartmentCourses> DeptCourse_tableView11;

    @FXML
    private TableColumn<DepartmentCourses, String> deptCourse_col_DeptNum11;

    @FXML
    private TableColumn<DepartmentCourses, String> DeptCourse_col_CourseID11;

    @FXML
    private Button deptCourse_addBtn111;

    @FXML
    private Button deptCourse_deleteBtn111;

    @FXML
    private TextField DeptCourse_txtField_courseID;

    @FXML
    private TextField DeptCourse_txtField_deptID;

    @FXML
    private TableView<Departments> Dept_tableView1;

    @FXML
    private TableColumn<Departments, String> Dept_col_DeptNum1;

    @FXML
    private TableColumn<Departments, String> Dept_col_DeptName;

    @FXML
    private Button dept_addBtn111;

    @FXML
    private Button dept_deleteBtn11;

    @FXML
    private TextField Dept_txtField_deptID;

    @FXML
    private TextField Dept_txtField_deptName;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    public ObservableList<StudentData> addStudentsListData() {

        ObservableList<StudentData> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM university.student";

        connect = database.connectDb();

        try {
            StudentData studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new StudentData(result.getInt("STUDENT_ID"),
                        result.getString("FIRST_NAME"),
                        result.getString("LAST_NAME"),
                        result.getDate("BIRTH_DATE"),
                        result.getString("MOB_NUMBER"),
                        result.getInt("DEPT_ID"));

                listStudents.add(studentD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }

    private ObservableList<StudentData> addStudentsListD;
    public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();

        addStudents_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        addStudents_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudents_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudents_col_birthdate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        addStudents_col_mob.setCellValueFactory(new PropertyValueFactory<>("mobNumber"));
        addStudents_col_deptID.setCellValueFactory(new PropertyValueFactory<>("deptId"));

        addStudents_tableView.setItems(addStudentsListD);

    }
    
    public void addStudentsSelect() {

        StudentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addStudents_studentNum.setText(String.valueOf(studentD.getStudentId()));
        addStudents_firstName.setText(studentD.getFirstName());
        addStudents_lastName.setText(studentD.getLastName());
        addStudents_birth.setValue(studentD.getBirthDate().toLocalDate());
        addStudents_deptID.setText(String.valueOf(studentD.getDeptId()));
        addStudents_mob.setText(studentD.getMobNumber());
        
    }

    
    
     public void switchForm(ActionEvent event) {
        if (event.getSource() == Dashboard_btn) {
            home_form.setVisible(true);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            Dept_form1.setVisible(false);
            
            studentReportShowData();

        } else if (event.getSource() == addStudents_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(true);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            Dept_form1.setVisible(false);
            
            addStudentsShowListData();
            
        } else if (event.getSource() == availableCourse_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(true);
            studentGrade_form.setVisible(false);
            Dept_form1.setVisible(false);
            
            availableCourseShowListData();

        } else if (event.getSource() == studentGrade_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(true);
            Dept_form1.setVisible(false);
            
            studentGradesShowListData();
        }else if (event.getSource() == Btn_Depts) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            Dept_form1.setVisible(true);
            
            DeptInfoShowData();
            DeptNameShowData();
        }
    }
     
     public void availableCourseAdd() {

        String insertData = "INSERT INTO university.course (COURSE_ID, COURSE_NAME, COURSE_HOURS) VALUES(?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (availableCourse_course.getText().isEmpty()
                    || availableCourse_description.getText().isEmpty()
                    || availableCourse_degree.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
//            CHECK IF THE COURSE YOU WANT TO INSERT IS ALREADY EXIST!
                String checkData = "SELECT COURSE_ID FROM university.course WHERE COURSE_ID = '"
                        + availableCourse_course.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course: " + availableCourse_course.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, availableCourse_course.getText());
                    prepare.setString(2, availableCourse_description.getText());
                    prepare.setString(3, availableCourse_degree.getText());

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableCourseShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableCourseClear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public void availableCourseUpdate() {

        String updateData = "UPDATE UNIVERSITY.course SET COURSE_NAME = '"
                + availableCourse_description.getText() + "', COURSE_HOURS = '"
                + availableCourse_degree.getText() + "' WHERE COURSE_ID = '"
                + availableCourse_course.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (availableCourse_course.getText().isEmpty()
                    || availableCourse_description.getText().isEmpty()
                    || availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Course: " + availableCourse_course.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableCourseShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableCourseClear();

                } else {
                    return;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public void availableCourseDelete() {

        String deleteData = "DELETE FROM UNIVERSITY.course WHERE COURSE_ID = '"
                + availableCourse_course.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (availableCourse_course.getText().isEmpty()
                    || availableCourse_description.getText().isEmpty()
                    || availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
//                ALL GOOD GUYS! NOW LETS PROCEED TO ADD STUDENTS FORM
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Course: " + availableCourse_course.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableCourseShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableCourseClear();

                } else {
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void addStudentsAdd() {
        
         try {
        
        String insertData = "INSERT INTO university.student "
                + "(STUDENT_ID, FIRST_NAME, LAST_NAME, BIRTH_DATE, MOB_NUMBER, DEPT_ID) "
                + "VALUES(?,?,?,?,?,?)";

        connect = database.connectDb();

            Alert alert;

            if (addStudents_studentNum.getText().isEmpty()
                    || addStudents_firstName.getText().isEmpty()
                    || addStudents_lastName.getText().isEmpty()
                    || addStudents_mob.getText().isEmpty()
                    || addStudents_birth.getValue() == null
                    || addStudents_deptID.getText().isEmpty() ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                // CHECK IF THE STUDENTNUMBER IS ALREADY EXIST
                String checkData = "SELECT STUDENT_ID FROM university.student WHERE STUDENT_ID = '"
                        + addStudents_studentNum.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID " + addStudents_studentNum.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addStudents_studentNum.getText());
                    prepare.setString(2, addStudents_firstName.getText());
                    prepare.setString(3, addStudents_lastName.getText());
                    java.sql.Date sqlDate = java.sql.Date.valueOf(addStudents_birth.getValue());
                    prepare.setDate(4, sqlDate);
                    prepare.setString(5, addStudents_mob.getText());
                    prepare.setString(6, addStudents_deptID.getText());
                  
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    
                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();
                    
                }
            }

        } catch (SQLException ex) {
            showAlert(Alert.AlertType.ERROR, "SQL Error", "Error updating data in the database", ex.getMessage());
        }
    }
     public void addStudentsUpdate() {

        try {
            
            String updateData = "{call UNIVERSITY.update_student_info(?, ?, ?, ?, ?, ?)}";
                                  
                Alert alert;
                if (addStudents_studentNum.getText().isEmpty()
                        || addStudents_firstName.getText().isEmpty()
                        || addStudents_lastName.getText().isEmpty()
                        || addStudents_mob.getText().isEmpty()
                        || addStudents_birth.getValue() == null
                        || addStudents_deptID.getText().isEmpty() ) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all blank fields");
                    alert.showAndWait();
                } else {

                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to UPDATE Student #" + addStudents_studentNum.getText() + "?");
                    Optional<ButtonType> option = alert.showAndWait();
                    
                    if (option.get().equals(ButtonType.OK)) {
                        
                        PreparedStatement preparedStatement = connect.prepareStatement(updateData);
                        preparedStatement.setString(1, addStudents_studentNum.getText());
                        preparedStatement.setString(2, addStudents_firstName.getText());
                        preparedStatement.setString(3, addStudents_lastName.getText());
                        preparedStatement.setDate(4, Date.valueOf(addStudents_birth.getValue()));
                        preparedStatement.setString(5, addStudents_mob.getText());
                        preparedStatement.setString(6, addStudents_deptID.getText());

                        connect = database.connectDb();
                        
                        preparedStatement.executeUpdate();

                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Updated!");
                        alert.showAndWait();
                        
                        // TO UPDATE THE TABLEVIEW
                        addStudentsShowListData();
                        // TO CLEAR THE FIELDS
                        addStudentsClear();
                        
                    } else {
                        return;
                    }
                }
            
        } catch (SQLException ex) {

            showAlert(Alert.AlertType.ERROR, "SQL Error", "Error updating data in the database", ex.getMessage());}
        }
     
       public void addStudentsDelete() {

        String deleteData = "DELETE FROM university.student WHERE STUDENT_ID = '"
                + addStudents_studentNum.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (addStudents_studentNum.getText().isEmpty() ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Student ID" + addStudents_studentNum.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    
                    String checkData = "SELECT STUDENT_ID FROM university.student WHERE STUDENT_ID = '"
                           + addStudents_studentNum.getText() + "'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();

                    // IF THE STUDENT NUMBER IS EXIST THEN PROCEED TO DELETE
                    if (result.next()) {
                        
                        statement = connect.createStatement();
                        statement.executeUpdate(deleteData);
                        
                         alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Deleted!");
                        alert.showAndWait();

                    }
                    else {
                         alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("The student ID that you inserted is not existed!");
                        alert.showAndWait();
                    
                    }
                    
                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();

                } else {
                    return;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
    public void addStudentsClear() {
        addStudents_studentNum.setText("");
        addStudents_firstName.setText("");
        addStudents_lastName.setText("");
        addStudents_birth.setValue(null);
        addStudents_mob.setText("");
        addStudents_deptID.setText("");

    }
    
    public void availableCourseClear() {
        availableCourse_course.setText("");
        availableCourse_description.setText("");
        availableCourse_degree.setText("");
    }
     
    public ObservableList<courseData> availableCourseListData() {

        ObservableList<courseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM UNIVERSITY.COURSE";

        connect = database.connectDb();

        try {
            courseData courseD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                courseD = new courseData(result.getInt("COURSE_ID"),
                        result.getString("COURSE_NAME"),
                        result.getInt("COURSE_HOURS"));

                listData.add(courseD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    private ObservableList<courseData> availableCourseList;

    public void availableCourseShowListData() {
        availableCourseList = availableCourseListData();

        availableCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        availableCourse_col_description.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        availableCourse_col_degree.setCellValueFactory(new PropertyValueFactory<>("courseHours"));

        availableCourse_tableView.setItems(availableCourseList);

    }
    
     public void availableCourseSelect() {
        courseData courseD = availableCourse_tableView.getSelectionModel().getSelectedItem();
        int num = availableCourse_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        availableCourse_course.setText(String.valueOf(courseD.getCourseID()));
        availableCourse_description.setText(courseD.getCourseName());
        availableCourse_degree.setText(String.valueOf(courseD.getCourseHours()));

    }
    
    
     public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                //HIDE YOUR DASHBOARD FORM
                logout.getScene().getWindow().hide();

                //LINK YOUR LOGIN FORM 
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
     private void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    } 
     
    public ObservableList<StudentGrades> studentGradesListData() {

        ObservableList<StudentGrades> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM STUDENT_COURSE";

        connect = database.connectDb();
        try {
            StudentGrades studentD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new StudentGrades(result.getInt("STUDENT_ID"),
                         result.getInt("COURSE_ID"),
                         result.getInt("GRADE"),
                         result.getInt("YEAR"),
                         result.getInt("SEMESTER"));
                listData.add(studentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }  
          
     
     private ObservableList<StudentGrades> studentGradesList;

    public void studentGradesShowListData() {
        studentGradesList = studentGradesListData();

        studentGrade_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        studentGrade_col_CourseID.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        studentGrade_col_Grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        studentGrade_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        studentGrade_col_Sem.setCellValueFactory(new PropertyValueFactory<>("semester"));
//        WE NEED TO FIX THE DELETE ON ADD STUDENT FORM 
        studentGrade_tableView.setItems(studentGradesList);

    }
    
    
    public void studentCourseUpdate() {

     try {
        String updateData = "UPDATE UNIVERSITY.STUDENT_COURSE SET STUDENT_ID = '"
                + studentGrade_studentID.getText() + "', COURSE_ID = '"
                + studentGrade_studentCourseID.getText() + "', GRADE = '"
                + studentGrade_Grade.getText() + "', YEAR = '"
                + studentGrade_Year.getText() + "', SEMESTER = '"
                + studentGrade_Sem.getText() + "' WHERE STUDENT_ID = '"
                + studentGrade_studentID.getText() + "' AND COURSE_ID = '"
                + studentGrade_studentCourseID.getText() + "'";

        connect = database.connectDb();

   
            Alert alert;

            if (studentGrade_studentID.getText().isEmpty()
                        || studentGrade_studentCourseID.getText().isEmpty()
                        || studentGrade_Grade.getText().isEmpty()
                        || studentGrade_Year.getText().isEmpty()
                        || studentGrade_Sem.getText().isEmpty() ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                
                try {
                int gradeValue = Integer.parseInt(studentGrade_Grade.getText());
                if (gradeValue < 0 || gradeValue > 100) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid grade value in Range (0-100)");
                alert.showAndWait();
                return;
            }

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE ?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    studentGradesShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    studentCourseClear();

                } else {
                    return;
                }

            }

        } catch (SQLException ex) {
             showAlert(Alert.AlertType.ERROR, "SQL Error", "Error updating data in the database", ex.getMessage());
        }

    }
    
     public void studentCourseAdd() {

        String insertData = "INSERT INTO university.STUDENT_COURSE (STUDENT_ID, COURSE_ID, GRADE, YEAR, SEMESTER) VALUES(?,?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (studentGrade_studentID.getText().isEmpty()
                        || studentGrade_studentCourseID.getText().isEmpty()
                        || studentGrade_Year.getText().isEmpty()
                        || studentGrade_Sem.getText().isEmpty() ){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                
                 try {
                int gradeValue = Integer.parseInt(studentGrade_Grade.getText());
                if (gradeValue < 0 || gradeValue > 100) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid grade value in Range (0-100)");
                alert.showAndWait();
                return;
            }
                    String checkProgram = "SELECT COUNT(*) AS Count \n" +
                                        "FROM UNIVERSITY.STUDENT S JOIN UNIVERSITY.DEPT_COURSES D\n" +
                                        "ON S.DEPT_ID = D.DEPT_ID \n" +
                                        "WHERE S.STUDENT_ID = ? AND D.COURSE_ID = ? ";

                        prepare = connect.prepareStatement(checkProgram);
                        prepare.setString(1, studentGrade_studentID.getText());
                        prepare.setString(2, studentGrade_studentCourseID.getText());

                        result = prepare.executeQuery();
                        
                        
                    if (result.next() && result.getInt("Count") > 0) {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, studentGrade_studentID.getText());
                    prepare.setString(2, studentGrade_studentCourseID.getText());
                                        
                    String gradeValue = studentGrade_Grade.getText();
                        if (gradeValue.isEmpty()) {
                            prepare.setNull(3, Types.INTEGER); // Setting GRADE to null
                     } else {
                            int grade = Integer.parseInt(gradeValue);
                            prepare.setInt(3, grade);
                     }
                    prepare.setString(4, studentGrade_Year.getText());
                    prepare.setString(5, studentGrade_Sem.getText());
                    
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    
                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    studentGradesShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    studentCourseClear();
                    } else {
                    // The course does not belong to the same program
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The Department does not has this course !");
                    alert.showAndWait();
                
            }
                    
        }
          }catch (SQLException ex) {
             showAlert(Alert.AlertType.ERROR, "SQL Error", "Error Inserting data in the database", ex.getMessage());
        }
    }
     
     public void studentCourseDelete() {
         
        try { 
            
            String deleteData = "DELETE FROM UNIVERSITY.STUDENT_COURSE WHERE STUDENT_ID = ? and COURSE_ID = ? ";
            
            connect = database.connectDb();

            Alert alert;

            if (studentGrade_studentID.getText().isEmpty()
                || studentGrade_studentCourseID.getText().isEmpty() ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
//                ALL GOOD GUYS! NOW LETS PROCEED TO ADD STUDENTS FORM
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Course? ");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, studentGrade_studentID.getText());
                    prepare.setString(2, studentGrade_studentCourseID.getText());
            
                    prepare.executeUpdate();
            
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    studentGradesShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    studentCourseClear();

                } else {
                    return;
                }
            }

        } catch (SQLException ex) {
            showAlert(Alert.AlertType.ERROR, "SQL Error", "Error Deleting data from the database", ex.getMessage());
        }

    }
    
    public void studentCourseSelect() {
        StudentGrades studentG = studentGrade_tableView.getSelectionModel().getSelectedItem();
        int num = studentGrade_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        studentGrade_studentID.setText(String.valueOf(studentG.getStudentID()));
        studentGrade_studentCourseID.setText(String.valueOf(studentG.getCourseID()));
        studentGrade_Grade.setText(String.valueOf(studentG.getGrade()));
        studentGrade_Year.setText(String.valueOf(studentG.getYear()));
        studentGrade_Sem.setText(String.valueOf(studentG.getSemester()));
        
    }
    
    public void studentCourseClear() {
        studentGrade_studentID.setText("");
        studentGrade_studentCourseID.setText("");
        studentGrade_Grade.setText("");
        studentGrade_Year.setText("");
        studentGrade_Sem.setText("");
    }
    
    
    
    
    
    
    
    
    public ObservableList<studentReport> studentReportData() {

        ObservableList<studentReport> listReport = FXCollections.observableArrayList();
        
        String sql = "select sc.COURSE_ID as COURSE_ID , c.COURSE_NAME as COURSE_NAME , count(sc.STUDENT_ID) as ENROLLED ,round(avg(sc.Grade),2) as AVG\n" +
                        "from UNIVERSITY.STUDENT_COURSE sc, UNIVERSITY.COURSE c\n" +
                        "where sc.COURSE_ID = c.COURSE_ID\n" +
                        "Group by sc.COURSE_ID, c.COURSE_NAME ";
        
        connect = database.connectDb();
        try {
            studentReport studentR;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentR = new studentReport(result.getInt("COURSE_ID"),
                         result.getString("COURSE_NAME"),
                         result.getInt("ENROLLED"),  
                         result.getInt("AVG"));  
                         
                listReport.add(studentR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listReport;
    }  
    
    private ObservableList<studentReport> studentReport;

    public void studentReportShowData() {
        studentReport = studentReportData();

        repo_col_courseID.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        repo_col_courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        repo_col_enrolled.setCellValueFactory(new PropertyValueFactory<>("EnrolledStudents"));
        repo_col_avgGPA.setCellValueFactory(new PropertyValueFactory<>("avgGPA"));
//        WE NEED TO FIX THE DELETE ON ADD STUDENT FORM 
        tab_repo.setItems(studentReport);

    }
        

    public ObservableList<Departments> deptData() {

        ObservableList<Departments> listDeptInfo = FXCollections.observableArrayList();
        
        String sql = "SELECT * from UNIVERSITY.DEPARTMENT";
        
        connect = database.connectDb();
        try {
            Departments DeptInfo;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                DeptInfo = new Departments(result.getInt("DEPT_ID"),
                         result.getString("DEPT_NAME"));
                listDeptInfo.add(DeptInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDeptInfo;
    }
    
    private ObservableList<Departments> DepartmentData;

    public void DeptNameShowData() {
        DepartmentData = deptData();

        Dept_col_DeptNum1.setCellValueFactory(new PropertyValueFactory<>("deptId"));
        Dept_col_DeptName.setCellValueFactory(new PropertyValueFactory<>("deptName"));
//        WE NEED TO FIX THE DELETE ON ADD STUDENT FORM 
        Dept_tableView1.setItems(DepartmentData);

    }
    
    
    
    public void deptNameSelect() {
        Departments deptS = Dept_tableView1.getSelectionModel().getSelectedItem();
        int num = Dept_tableView1.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        Dept_txtField_deptID.setText(String.valueOf(deptS.getDeptId()));
        Dept_txtField_deptName.setText(deptS.getDeptName());
        
    }
    
    
    public void deptAdd() {

        String insertData = "INSERT INTO university.DEPARTMENT VALUES ( ? , ? )";

        connect = database.connectDb();

        try {
            Alert alert;

            if (Dept_txtField_deptID.getText().isEmpty()
                    || Dept_txtField_deptName.getText().isEmpty() ){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, Dept_txtField_deptID.getText());
                    prepare.setString(2, Dept_txtField_deptName.getText());

                    prepare.executeUpdate();
                                        
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    DeptNameShowData();

            }
        }catch (SQLException ex) {
             showAlert(Alert.AlertType.ERROR, "SQL Error", "Error Inserting data in the database", ex.getMessage());
        }
    } 
        
    
    public void deptDelete() {
         
        try { 
            
            String deleteData = "DELETE FROM UNIVERSITY.DEPARTMENT WHERE DEPT_ID = ?";
            
            connect = database.connectDb();

            Alert alert;

            if (Dept_txtField_deptID.getText().isEmpty() ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
//                ALL GOOD GUYS! NOW LETS PROCEED TO ADD STUDENTS FORM
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Course? ");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, Dept_txtField_deptID.getText());
            
                    prepare.executeUpdate();
            
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    DeptNameShowData();
                    

                } else {
                    return;
                }
            }

        } catch (SQLException ex) {
            showAlert(Alert.AlertType.ERROR, "SQL Error", "Error Deleting data from the database", ex.getMessage());
        }

    }
    
      
    public ObservableList<DepartmentCourses> deptCoursesData() {

        ObservableList<DepartmentCourses> listDeptCourses = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM UNIVERSITY.DEPT_COURSES";
        
        connect = database.connectDb();
        try {
            DepartmentCourses DeptInfo;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                DeptInfo = new DepartmentCourses(result.getInt("DEPT_ID"),
                         result.getInt("COURSE_ID")); 
                
                listDeptCourses.add(DeptInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDeptCourses;
    }  
    
    private ObservableList<DepartmentCourses> DepartmentInfo;

    public void DeptInfoShowData() {
        DepartmentInfo = deptCoursesData();

        deptCourse_col_DeptNum11.setCellValueFactory(new PropertyValueFactory<>("deptId"));
        DeptCourse_col_CourseID11.setCellValueFactory(new PropertyValueFactory<>("courseId"));
//        WE NEED TO FIX THE DELETE ON ADD STUDENT FORM 
        DeptCourse_tableView11.setItems(DepartmentInfo);

    }
    
    
    public void deptCourseSelect() {
        DepartmentCourses deptC = DeptCourse_tableView11.getSelectionModel().getSelectedItem();
        int num = DeptCourse_tableView11.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        DeptCourse_txtField_deptID.setText(String.valueOf(deptC.getDeptId()));
        DeptCourse_txtField_courseID.setText(String.valueOf(deptC.getCourseId()));
        
    }
    
    
    public void deptCourseAdd() {

        String insertData = "INSERT INTO university.DEPT_COURSES VALUES ( ? , ? )";

        connect = database.connectDb();

        try {
            Alert alert;

            if (DeptCourse_txtField_deptID.getText().isEmpty()
                    || DeptCourse_txtField_courseID.getText().isEmpty() ){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, DeptCourse_txtField_deptID.getText());
                    prepare.setString(2, DeptCourse_txtField_courseID.getText());

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    DeptInfoShowData();
            }
        }catch (SQLException ex) {
             showAlert(Alert.AlertType.ERROR, "SQL Error", "Error Inserting data in the database", ex.getMessage());
        }
    } 
    
    
        
    public void deptCourseDelete() {
         
        try { 
            
            String deleteData = "DELETE FROM UNIVERSITY.DEPT_COURSES WHERE DEPT_ID = ? and COURSE_ID = ? ";
            
            connect = database.connectDb();

            Alert alert;

            if (DeptCourse_txtField_deptID.getText().isEmpty()
                    || DeptCourse_txtField_courseID.getText().isEmpty() ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
//                ALL GOOD GUYS! NOW LETS PROCEED TO ADD STUDENTS FORM
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Course? ");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, DeptCourse_txtField_deptID.getText());
                    prepare.setString(2, DeptCourse_txtField_courseID.getText());
                    
                    prepare.executeUpdate();
            
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    DeptInfoShowData();
                    

                } else {
                    return;
                }
            }

        } catch (SQLException ex) {
            showAlert(Alert.AlertType.ERROR, "SQL Error", "Error Deleting data from the database", ex.getMessage());
        }

    }
   
    
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        studentReportShowData();
        addStudentsShowListData();
        availableCourseShowListData();
        
        studentGradesShowListData();
        DeptInfoShowData();
        DeptNameShowData();
    }
    
}
