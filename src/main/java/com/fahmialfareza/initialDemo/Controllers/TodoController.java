package com.fahmialfareza.initialDemo.Controllers;

import com.fahmialfareza.initialDemo.Entity.Todo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class TodoController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/todos")
    public String getTodo() {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", String.class);
    }

    @PostMapping("/todos")
    public String postTodo(@RequestBody Todo todo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Todo> entity = new HttpEntity<Todo>(todo, headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.POST, entity, String.class).getBody();
    }

    @PutMapping("/todos/{id}")
    public String putTodo(@PathVariable(name = "id") Long id, @RequestBody Todo todo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        todo.setID(id);
        HttpEntity<Todo> entity = new HttpEntity<Todo>(todo, headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable(value = "id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Todo> entity = new HttpEntity<Todo>(null, headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
