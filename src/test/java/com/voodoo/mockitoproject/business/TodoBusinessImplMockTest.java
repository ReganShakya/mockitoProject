package com.voodoo.mockitoproject.business;

import com.voodoo.mockitoproject.data.api.TodoService;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author regan
 */
public class TodoBusinessImplMockTest {
    
    @Test
    public void testRetrieveTodosRelatedToStpring_usingAMock() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Junit", "Learn to Dance");
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = 
                new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Dummy");
        
        assertEquals(2, filteredTodos.size());
    }
    
    @Test
    public void testRetrieveTodosRelatedToStpring_usingAEmptyArray() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList();
        
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = 
                new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Java");
        
        assertEquals(0, filteredTodos.size());
    }
}
