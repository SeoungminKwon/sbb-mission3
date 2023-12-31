package com.example.sbbmission3.answer;

import com.example.sbbmission3.question.Question;
import com.example.sbbmission3.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(name = "content") String content){
        Question question = questionService.getQuestion(id);

        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
