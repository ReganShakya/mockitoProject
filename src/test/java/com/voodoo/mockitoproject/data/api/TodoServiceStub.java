 package com.voodoo.mockitoproject.data.api;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author regan
 */
public class TodoServiceStub implements TodoService{

    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC","Learn Spring", "Junit", "Learn to Dance"); 
    }
    
}
