package com.voodoo.mockitoproject.business;

import com.voodoo.mockitoproject.business.TodoBusinessImpl;
import com.voodoo.mockitoproject.data.api.TodoService;
import com.voodoo.mockitoproject.data.api.TodoServiceStub;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author regan
 */
public class TodoBusinessImplStubTest {
    
    @Test
    public void testRetrieveTodosRelatedToStpring_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = 
                new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Java");
        
        assertEquals(2, filteredTodos.size());
    }
}
