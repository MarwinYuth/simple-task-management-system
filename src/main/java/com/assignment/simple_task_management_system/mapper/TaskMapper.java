package com.assignment.simple_task_management_system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.assignment.simple_task_management_system.model.TaskModel;

@Mapper
public interface TaskMapper {
    
    @Select("SELECT * FROM tasks ORDER BY id")
    List<TaskModel> findAll();

    @Select("SELECT * FROM tasks WHERE id = #{id}")
    TaskModel findById(Long id);

    @Insert("INSERT INTO tasks(title, description, status) VALUES(#{title}, #{description}, #{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(TaskModel taskModel);

    @Update("UPDATE tasks SET title=#{title}, description=#{description}, status=#{status} WHERE id=#{id}")
    int update(TaskModel taskModel);

    @Delete("DELETE FROM tasks WHERE id = #{id}")
    int delete(Long id);

    @Select("SELECT COUNT(*) FROM tasks WHERE title = #{title}")
    int findExistTaskTitle(@Param("title") String title);
}
