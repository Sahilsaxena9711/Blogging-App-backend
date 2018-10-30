package org.sping.api.resource;

import org.sping.api.model.Blog;
import org.sping.api.model.Response;
import org.sping.api.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/blog")
public class BlogResource {

    @Autowired
    BlogRepository blogRepository;

    @GetMapping(value="/all")
    public Response getAll(){
        Response response = new Response();
        response.setMessage("Request completed Sucessfully");
        response.setData(blogRepository.findAll());
        return response;
    }

    @PostMapping(value="/create")
    public Response createBlog(@RequestBody Blog blog){
            Response response = new Response();
            response.setData(blogRepository.save(blog));
            response.setMessage("Request Completed Successfully");
        return response;

    }

    @GetMapping(value = "/get/{userName}")
    public Response getByUserName(@PathVariable final String userName){
        Response response = new Response();
            response.setMessage("Request Completed Successfully");
            response.setData(blogRepository.getByUserName(userName));
        return response;
    }

    @GetMapping(value = "/get/title/{title}")
    public Response getByTitle(@PathVariable final String title){
        Response response = new Response();
        response.setMessage("Request Completed Successfully");
        response.setData(blogRepository.getByTitle(title));
        return response;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Response deleteById(@PathVariable final Integer id){
        blogRepository.delete(id);
        Response response = new Response();
        response.setMessage("Request Completed Successfully");
        return response;

    }
}