package com.ssrg.hw.mapper;

import com.ssrg.hw.dto.StudentMistakeNoteDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMistakeNoteMapper {

    /**
     * 查询所有错题
     * @return
     */
    List<StudentMistakeNoteDto> queryStudentMistakeNoteList();

    /**
     * 根据studentId查询该学生所有错题
     * @param studentId
     * @return
     */
    List<StudentMistakeNoteDto> queryStudentMistakeNoteByStudentId(int studentId);

    /**
     * 根据noteName查询错题
     * @param noteName
     * @return
     */
    List<StudentMistakeNoteDto> queryStudentMistakeNoteByNoteName(String noteName);

    /**
     * 根据noteId查询错题
     * @param noteId
     * @return
     */
    StudentMistakeNoteDto queryStudentMistakeNoteByNoteId(int noteId);

    /**
     * 增加一个错题
     * @param studentMistakeNoteDto
     * @return
     */
    int addStudentMistakeNote(StudentMistakeNoteDto studentMistakeNoteDto);

    /**
     * 更新一个错题
     * @param studentMistakeNoteDto
     * @return
     */
    int updateStudentMistakeNote(StudentMistakeNoteDto studentMistakeNoteDto);

    /**
     * 删除一个错题
     * @param noteId
     * @return
     */
    int deleteStudentMistakeNote(int noteId);
}
