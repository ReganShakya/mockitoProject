package com.voodoo.mockitoproject.business;

import com.voodoo.mockitoproject.data.api.TodoService;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author regan
 */

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoTest {
    
    @Mock
    TodoService todoServiceMock;
    
    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;
    //TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    
    @Test
    public void testRetrieveTodosRelatedToStpring_usingAMock() {
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Junit", "Learn to Dance");
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Dummy");
        
        assertEquals(2, filteredTodos.size());
    }
    
    @Test
    public void testRetrieveTodosRelatedToStpring_usingAEmptyArray() {
        List<String> todos = Arrays.asList();
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Java");
        
        assertEquals(0, filteredTodos.size());
    }
}
