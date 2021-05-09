package com.voodoo.mockitoproject.business;

import com.voodoo.mockitoproject.data.api.TodoService;
import java.util.Arrays;
import java.util.List;
import javax.management.RuntimeErrorException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author regan
 */
public class ListTest {
    
    @Test
    public void letsMockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }
    
    @Test
    public void letsMockListSize_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }
    
    @Test
    public void letsMockListGet() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("voodoo");
        assertEquals("voodoo", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }
    
    @Test
    public void letsMockList_usingBDD() {
        //Given
        List<String> listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("voodoo");
        
        //When
        String firstElement = listMock.get(0);
        
        //Then
        assertThat(firstElement, is("voodoo"));
    }
    
    @Test(expected = RuntimeException.class)
    public void letsMockList_thorwAnException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        
        listMock.get(0);
    }
    
    @Test(expected = RuntimeException.class)
    public void letsMockList_mixingUp() {
        List listMock = mock(List.class);
        when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
        
        listMock.get(0);
    }
    
    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {
        //Given
        TodoService todoServiceMock =mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        
        //When
        List<String> filteredTodos = todoBusinessImpl.
                retrieveTodosRelatedToSpring("Dummy");
        //Then
        assertThat(filteredTodos.size(), is(2));
    }
}