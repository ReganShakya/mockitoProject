package com.voodoo.mockitoproject.data.api;

import java.util.List;

/**
 *
 * @author regan
 */
public interface TodoService {
    public List<String> retrieveTodos(String user);
}
