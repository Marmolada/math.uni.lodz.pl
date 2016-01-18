package com.gft.structuraltest.testconference.registrationdata;

import static org.junit.Assert.*;
import org.junit.*;

public class AnswerEntityTest{

    @Test
    public void shouldReturnFalseWhenObjectIsNull(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = null;
        assertFalse(an1.equals(an2));
    }
    
	@Test
    public void shouldReturnTrueWhenObjectsAreSame(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = an1;
		assertTrue(an1.equals(an2));
    }
	
	@Test
    public void shouldReturnTrueWhenObjectsAreSameClass(){
        AnswerEntity an1 = new AnswerEntity();
        String an2 = new String();
		assertTrue(an1.equals(an2));
    }
	
	@Test
    public void shouldReturnTrueWhenAreEqual(){
		QuestionEntity qe = new QuestionEntity();
		
        AnswerEntity an1 = new AnswerEntity();
		an1.setId(10);
		an1.setAnswerText("answer");
		an1.setQuestion(qe);
		
        AnswerEntity an2 = new AnswerEntity();
		an2.setId(10);
		an2.setAnswerText("answer");
		an2.setQuestion(qe);
		
		assertTrue(an1.equals(an2));
    }
	
	@Test
    public void shouldReturnFalseWhenIDsArentEqual(){
		QuestionEntity qe = new QuestionEntity();
		
        AnswerEntity an1 = new AnswerEntity();
		an1.setAnswerText("answer");
		an1.setQuestion(qe);
		
        AnswerEntity an2 = new AnswerEntity();
		an2.setId(10);
		an2.setAnswerText("answer");
		an2.setQuestion(qe);
		
		assertFalse(an1.equals(an2));
    }
	
	@Test
    public void shouldReturnFalseWhenAnsTextsArentEqual(){
		QuestionEntity qe = new QuestionEntity();
		
        AnswerEntity an1 = new AnswerEntity();
		an1.setId(10);
		an1.setQuestion(qe);
		
        AnswerEntity an2 = new AnswerEntity();
		an2.setId(10);
		an2.setAnswerText("answer");
		an2.setQuestion(qe);
		
		assertFalse(an1.equals(an2));
    }
	
	@Test
    public void shouldReturnFalseWhenQuestionsArentEqual(){
		QuestionEntity qe = new QuestionEntity();
		
		QuestionEntity qe2 = new QuestionEntity();
		qe2.setQuestionText("questionText");
		
        AnswerEntity an1 = new AnswerEntity();
		an1.setId(10);
		an1.setAnswerText("answer");
		an2.setQuestion(qe);
		
        AnswerEntity an2 = new AnswerEntity();
		an2.setId(10);
		an2.setAnswerText("answer");
		an2.setQuestion(qe2);
		assertFalse(an1.equals(an2));
    }
}