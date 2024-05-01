package com.example.institute.controller;
/*
import com.example.institute.entity.Stundents;
import com.example.institute.service.StudentsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(StudentController.class)
public class StudentIntegrationTest {
    @MockBean
    StudentsService studentsService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void createStudentIntegration() throws Exception {
    Stundents stundents=new Stundents();
    stundents.setStudentName("bus");
    stundents.setCourseId("1");
   stundents.setStudentId("1");
      ResultActions resultActions= mockMvc.perform(post("/students/addStudent")
              .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(stundents)));
      resultActions.andDo(print()).andExpect(status().isCreated());
    }
    @Test
    public void createStudentIntegrationWithNegativeScenario() throws Exception {
        Stundents stundents=new Stundents();
        ResultActions resultActions= mockMvc.perform(post("/students/addStudent")
        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString("Unable to save User : " +stundents.getEmailId())));
        resultActions.andDo(print()).andExpect(status().isInternalServerError());
    }
    @Test
    public void getStudentByIdIntegrationTest() throws Exception {
        String id="1";
                mockMvc.perform(get("/students/getStudent/{id}",id)
                        .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }
    @Test
    void getAllStudentsIntegrationTest() throws Exception {
        mockMvc.perform(get("/students/getAll").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }
    @Test
    void getAllStudentsIntegrationTestWithThrows() throws Exception {
        mockMvc.perform(get("/students/getAll")
                .accept(MediaType.APPLICATION_JSON))
               .andDo(print())
                .andExpect(status().isInternalServerError());
    }

}
*/