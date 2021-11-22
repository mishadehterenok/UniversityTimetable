package by.mdhtrnk.demouniversity.controller;

import by.mdhtrnk.demouniversity.dto.StudentDto;
import by.mdhtrnk.demouniversity.entity.Timetable;
import by.mdhtrnk.demouniversity.exceptionHandling.entity.IncorrectDataEntity;
import by.mdhtrnk.demouniversity.exceptionHandling.exception.IncorrectRequestBodyException;
import by.mdhtrnk.demouniversity.service.GroupService;
import by.mdhtrnk.demouniversity.service.StudentService;
import by.mdhtrnk.demouniversity.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UniversityController {

    private final TimetableService timetableService;

    @Autowired
    public UniversityController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @PostMapping("/university")
    public Timetable getSubjectsByStudentAndDay(@RequestBody StudentDto studentDto){
        Timetable timetable = timetableService.getTimetableByStudentDto(studentDto);
        if (timetable == null){
            throw new IncorrectRequestBodyException("Incorrect request body! Try again...");
        }
        return timetable;
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectDataEntity> handleException(IncorrectRequestBodyException ex){
        return new ResponseEntity<>(new IncorrectDataEntity(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/university")
    public String getString(){
        return "Hello World";
    }


}
