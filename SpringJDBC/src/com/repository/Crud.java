package com.repository;

import com.entity.bean.Student;
import com.rowmapper.RowMapperImpl;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Crud {

//    public Crud() {
//        System.out.println("Crud class loaded!");
//    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(int id, String name) {
        String sql = "insert into student(id,name) values(?,?)";
        int update = jdbcTemplate.update(sql, id, name);
        System.out.println(update);
    }

    public void update(int id, String name) {
        String sql = "update student set name=? where id=?";
        int update = jdbcTemplate.update(sql, name, id);
        System.out.println(update);
    }

    public void delete(int id) {
        String sql = "delete from student where id=?";
        int row = jdbcTemplate.update(sql, id);
        System.out.println(row);
    }

    public void readAllDefault() {
        String sql = "select * from student";
        for (Map<String, Object> stringObjectMap : jdbcTemplate.queryForList(sql)) {
            for (Map.Entry<String, Object> map : stringObjectMap.entrySet()) {
                System.out.println(map.getKey() + "--> " + map.getValue());
            }
        }
    }

    //read data from POJO
    public void readAllPojo() {
        String sql = "select * from student";
        List<Student> list = jdbcTemplate.query(sql, new RowMapperImpl());
        for (Student student : list) {
            System.out.println(student.getId() + " " + student.getName());
        }
    }

    //read single data
    public void readSingleRecord(int id) {
        String sql = "select * from student where id=?";
        Student student = jdbcTemplate.queryForObject(sql, new RowMapperImpl(), id);
        System.out.println(student);
    }

}
